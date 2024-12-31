package Dominio.Juego;
import Dominio.Usuarios.Jugador;
import Dominio.PokerException;
import Dominio.SituacionJugador;
import java.util.ArrayList;

public class Mesa {
    private int numero;
    private int minimoDeJugadores;
    private double apuestaBase;
    private double porcentajeComision;
    private EstadoMesa estadoMesa;
    private ArrayList<Jugador> jugadores = new ArrayList();
    private Jugador jugadorGanador;
    private FiguraStrategy figuraGanadora;
    private double totalApostado;
    private int numeroManoActual = 1;
    private ManoMesa manoMesaActual;
    static int _numeracion = 1;
    
    public Mesa( int minimoDeJugadores, double apuestaBase, double porcentaje) {
        this.numero = _numeracion;
        _numeracion++;
        this.minimoDeJugadores = minimoDeJugadores;
        this.apuestaBase = apuestaBase;
        this.porcentajeComision = porcentaje;
        this.estadoMesa = EstadoMesa.Abierta;
        this.manoMesaActual = new ManoMesa();
    }
    
    public void validar() throws PokerException{
        if(minimoDeJugadores<2 || minimoDeJugadores>5) throw new PokerException("Cantidad de jugadores no válida");
        if(apuestaBase<1) throw new PokerException("Apuesta base inválida");
        if(porcentajeComision < 1 || porcentajeComision > 50) throw new PokerException("Comisión inválida");
    }
    
    public void AgregarJugador(Jugador jugador) throws PokerException {
        if(this.estadoMesa != EstadoMesa.Abierta){
            throw new PokerException("La mesa ya no se encuentra abierta");
        }
        
        if(jugador.getSaldo() < (this.apuestaBase * 10)){
            throw new PokerException("Saldo insuficiente");
        }
        
        jugador.setMano(this.manoMesaActual.obtenerManoCartas());
        jugador.pagar(this.apuestaBase);
        this.totalApostado += this.apuestaBase;
        this.manoMesaActual.modificarPozo(apuestaBase);
        this.jugadores.add(jugador);
        
        if(this.jugadores.size() == this.minimoDeJugadores){
            this.setEstadoMesa(EstadoMesa.Iniciada);
        }
    }
    
    public void QuitarJugador(Jugador jugador){
        this.jugadores.remove(jugador);
        if(this.estadoMesa.equals(EstadoMesa.Abierta)){
            jugador.aumentarSaldo(this.apuestaBase);
            this.totalApostado -= this.apuestaBase;
            this.manoMesaActual.modificarPozo(-apuestaBase);
        }
        
        if(this.jugadores.isEmpty() && this.estadoMesa.equals(EstadoMesa.Iniciada)){
            this.setEstadoMesa(EstadoMesa.Finalizada);
        }
    }
    
    public boolean tieneJugador(Jugador jugador){
        return this.jugadores.contains(jugador);
    }

    public void pasarMano(Jugador jugador) throws PokerException {
        if(!jugador.obtenerEstadoMano().equals(EstadoMano.EsperandoApuesta)){
            throw new PokerException("No es posible indicar que no deseas iniciar una apuesta en este momento");
        }
              
        jugador.cambiarSituacionMano(SituacionJugador.NoPagoLaApuesta);
        cambiarEstadoManoMesaYJugadores(SituacionJugador.NoPagoLaApuesta, jugador);
        cambiarEstadoManoMesaTerminada();
    }
    
    public void pedirCartas(Jugador jugador) throws PokerException{
        if(!this.manoMesaActual.getEstadoMano().equals(EstadoMano.PidiendoCartas)){
            throw new PokerException("No es posible pedir cartas en este momento");
        }
        
        if(!jugador.getMano().getEstadoManoJugador().equals(EstadoMano.PidiendoCartas)){
            throw new PokerException("No puedes pedir cartas");
        }
        
        int cantidadCartasCambiadas = 0;
        for(Carta c:jugador.obtenerCartasDeSuMano()){
            if(!c.estaVisible()){
                cantidadCartasCambiadas++;
            }
        }
        
        jugador.getMano().setCantidadCartasCambiadas(cantidadCartasCambiadas);
        jugador.getMano().setCartas(this.manoMesaActual.cambiarCartas(jugador.getMano().getCartas()));
        jugador.cambiarEstadoMano(EstadoMano.Terminada);
        cambiarEstadoManoMesaTerminada();
    }

    public void realizarApuesta(double apuesta, Jugador jugador) throws PokerException{
        if(!estadoMesa.equals(EstadoMesa.Iniciada) || !this.manoMesaActual.getEstadoMano().equals(EstadoMano.EsperandoApuesta)){
            throw new PokerException("No es posible realizar una apuesta en este momento");
        }
        
        validarApuesta(jugador, apuesta);
        this.manoMesaActual.setEstadoMano(EstadoMano.ApuestaIniciada);
        cambiarEstadoManoMesaYJugadores(SituacionJugador.ApuestaIniciada, jugador);
        confirmarApuesta(jugador, apuesta);
    }

    public void validarApuesta(Jugador jugador, double apuesta) throws PokerException{
        if(jugador.getSaldo() < apuesta){
            throw new PokerException("Apuesta maxima $" + jugador.getSaldo());
        }
        
        if(apuesta < 1){
            throw new PokerException("Apuesta minima $1");
        }
        
        if(!jugador.getMano().getSituacion().equals(SituacionJugador.AccionPendiente)){ //todo esta bien aca*******?
            throw new PokerException("Ya no puedes apostar");
        }
    }
    
    public void igualarApuesta(Jugador jugador) throws PokerException{
        if(!this.manoMesaActual.getEstadoMano().equals(EstadoMano.ApuestaIniciada)){
            throw new PokerException("No es posible pagar una apuesta en este momento");
        }
        
        if(jugador.getMano().getSituacion().equals(SituacionJugador.ApuestaPagada)){
            throw new PokerException("Ya pagaste la apuesta");
        }
        
        if(jugador.getMano().getSituacion().equals(SituacionJugador.ApuestaIniciada)){
            throw new PokerException("Tu iniciaste esta apuesta");
        }
        
        validarApuesta(jugador, this.manoMesaActual.getApuesta());
        cambiarEstadoManoMesaYJugadores(SituacionJugador.ApuestaPagada, jugador);
        confirmarApuesta(jugador, this.manoMesaActual.getApuesta());
    }
        
    private void confirmarApuesta(Jugador jugador, double apuesta){
        this.totalApostado += apuesta;
        jugador.pagar(apuesta);
        this.manoMesaActual.modificarPozo(apuesta);
        this.manoMesaActual.setApuesta(apuesta);
    }
    
    public void proximaMano(){
        this.manoMesaActual = new ManoMesa();
        this.numeroManoActual++;
    }
    
    private void cambiarEstadoManoMesaYJugadores(SituacionJugador situacion, Jugador jugador) throws PokerException{
        switch(situacion){
            case SituacionJugador.ApuestaIniciada:
                jugador.cambiarSituacionMano(situacion);
                jugador.cambiarEstadoMano(EstadoMano.PidiendoCartas);
                cambiarEstadoManoMesaPidiendoCartas();
                break;
            case SituacionJugador.ApuestaPagada:
                jugador.getMano().setSituacion(situacion);
                jugador.cambiarEstadoMano(EstadoMano.PidiendoCartas);
                cambiarEstadoManoMesaPidiendoCartas();
                break;
            case SituacionJugador.NoPagoLaApuesta:
                jugador.cambiarEstadoMano(EstadoMano.Terminada);
                cambiarEstadoManoMesaPidiendoCartas();//verifica si lo tiene que cambiar
                break;
        }
    }
    
    private void cambiarEstadoManoMesaPidiendoCartas(){
        int cantidadConEstado = 0;
        for(Jugador j: jugadores){
            if(j.getMano().getEstadoManoJugador().equals(EstadoMano.PidiendoCartas) || j.getMano().getEstadoManoJugador().equals(EstadoMano.Terminada)){
                cantidadConEstado++;
            }
        }
        
        if(cantidadConEstado == jugadores.size()){
            this.manoMesaActual.setEstadoMano(EstadoMano.PidiendoCartas);
        }
    }
    
    private void cambiarEstadoManoMesaTerminada(){
        int cantidadConEstado = 0;
        for(Jugador j: jugadores){
            if(j.getMano().getEstadoManoJugador().equals(EstadoMano.Terminada)){
                cantidadConEstado++;
            }
        }
        
        if(cantidadConEstado == jugadores.size()){
            this.manoMesaActual.setEstadoMano(EstadoMano.Terminada);
            
            int puntajeMaximo = -1;
            int mayorValorCarta = 0;
            for(Jugador j:jugadores){
                if(j.getMano().getSituacion().equals(SituacionJugador.ApuestaPagada) || j.getMano().getSituacion().equals(SituacionJugador.ApuestaIniciada)){
                    ResultadoMano resultado = j.getMano().obtenePuntaje();
                    if(resultado.getValor() > puntajeMaximo && resultado.getValorMasAlto() > mayorValorCarta){
                        puntajeMaximo = resultado.getValor();
                        jugadorGanador = j;
                        mayorValorCarta = resultado.getValorMasAlto();
                    }
                }
            }
            
            if(jugadorGanador != null){
                jugadorGanador.aumentarSaldo(this.manoMesaActual.getPozo() * (100 - this.porcentajeComision) / 100);
                figuraGanadora = jugadorGanador.getMano().getFiguraGanadora();
            }
        }
    }

    public FiguraStrategy getFiguraGanadora() {
        return figuraGanadora;
    }

    public void setFiguraGanadora(FiguraStrategy figuraGanadora) {
        this.figuraGanadora = figuraGanadora;
    }
    
    public void setManoMesaActual(ManoMesa manoMesaActual) {
        this.manoMesaActual = manoMesaActual;
    }

    public double getTotalRecaudado() {
        return (this.totalApostado * this.porcentajeComision) / 100;
    }
 
    public int getNumeroManoActual() {
        return numeroManoActual;
    }

    public void setNumeroManoActual(int manoActual) {
        this.numeroManoActual = manoActual;
    }

    public double getTotalApostado() {
        return totalApostado;
    }

    public void setTotalApostado(double pozo) {
        this.totalApostado = pozo;
    }
    
    public ManoMesa getManoMesaActual() {
        return manoMesaActual;
    }
    
    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public EstadoMesa getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(EstadoMesa estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }
    
    public int getNumero() {
        return numero;
    }

    public int getMinimoDeJugadores() {
        return minimoDeJugadores;
    }

    public double getApuestaBase() {
        return apuestaBase;
    }

    public void continuarJugando(Jugador jugador, boolean quiere) throws PokerException {
        if(!this.manoMesaActual.getEstadoMano().equals(EstadoMano.Terminada)){
            throw new PokerException("No es posible realizar esa accion en este momento");
        }
        
        jugador.continuarJugando(quiere);
        boolean continuar = true;      
        for (Jugador jugadore : jugadores) {
            if(!jugadore.isContinuarJugando()){
                continuar = false;
            }
        }
        if(continuar){
            if(jugadorGanador==null){
                this.manoMesaActual=new ManoMesa(this.manoMesaActual.getPozo());
            }else {
                this.manoMesaActual=new ManoMesa();
            }
            this.numeroManoActual++;
            this.jugadorGanador = null;
            for (Jugador jugadore : jugadores) {
                jugadore.setMano(this.manoMesaActual.obtenerManoCartas());
                jugadore.continuarJugando(false);
            }
        }
    }

    public int cantidadDeJugadores(){
        return jugadores.size();
    }
    
    public double obtenerPozo(){
        return this.manoMesaActual.getPozo();
    }
    
    public String obtenerEstadoManoMesa(){
        return this.manoMesaActual.getEstadoManoString();
    }

    public String nombreDelGanador() {
        if(jugadorGanador!=null){
            return this.jugadorGanador.getNombreCompleto();
        }else{
            return "Aun no hay ningun ganador";
        }
    }
    
}
