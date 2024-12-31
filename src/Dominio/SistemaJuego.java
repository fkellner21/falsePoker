package Dominio;

import Dominio.Juego.Carta;
import Dominio.Juego.Escalera;
import Dominio.Juego.EstadoMesa;
import Dominio.Juego.FiguraStrategy;
import Dominio.Juego.Mesa;
import Dominio.Juego.Par;
import Dominio.Juego.Pierna;
import Dominio.Juego.Poker;
import Dominio.Juego.ResultadoMano;
import Dominio.Juego.SinFigura;
import Dominio.Usuarios.Jugador;
import Utilidades.Observable;
import java.util.ArrayList;
import java.util.List;

public class SistemaJuego extends Observable {
    private ArrayList<Mesa> mesas = new ArrayList();
    private ArrayList<FiguraStrategy> figuras = new ArrayList();
    
    public ArrayList<Mesa> getMesas(){
        return mesas;
    }
    
    public void pedirCartas(Mesa mesa, Jugador jugador) throws PokerException{
        mesa.pedirCartas(jugador);
        this.avisar(EventoMesa.ACTUALIZAR_PANEL);
        this.avisar(EventoMesa.ACTUALIZAR_MESAS_ADMINISTRADOR);
    }
    
    public void pasarMano(Mesa mesa, Jugador jugador) throws PokerException{
        mesa.pasarMano(jugador);
        this.avisar(EventoMesa.ACTUALIZAR_PANEL);
    }
    
    public void realizarApuesta(Mesa mesa, double apuesta, Jugador jugador) throws PokerException{
        mesa.realizarApuesta(apuesta, jugador);
        this.avisar(EventoMesa.ACTUALIZAR_MESAS_ADMINISTRADOR);
        this.avisar(EventoMesa.ACTUALIZAR_PANEL);
    }
    
    public void igualarApuesta(Mesa mesa, Jugador jugador) throws PokerException{
        mesa.igualarApuesta(jugador);
        this.avisar(EventoMesa.ACTUALIZAR_MESAS_ADMINISTRADOR);
        this.avisar(EventoMesa.ACTUALIZAR_PANEL);
    }
    
    public ArrayList<Mesa> obtenerMesasAbiertas(){
        ArrayList<Mesa> abiertas = new ArrayList();
        for (Mesa mesa : mesas) {
            if(mesa.getEstadoMesa()==EstadoMesa.Abierta){
                abiertas.add(mesa);
            }
        }
        return abiertas;
    }

    public void agregarMesa(String cantidadJugadores, String montoBase, String comision) throws PokerException {
        int nuevaCantidadJugadores = Integer.parseInt(cantidadJugadores);
        double nuevoMontoBase = Double.parseDouble(montoBase);
        double nuevaComision = Double.parseDouble(comision);
        Mesa mesa = new Mesa(nuevaCantidadJugadores, nuevoMontoBase, nuevaComision);
        mesa.validar();
        mesas.add(mesa);
        this.avisar(EventoMesa.ACTUALIZAR_MESAS_JUGADOR);
        this.avisar(EventoMesa.ACTUALIZAR_MESAS_ADMINISTRADOR);
    }
    
    public void cargarFiguras(){
        figuras.add(new Poker());
        figuras.add(new Escalera());
        figuras.add(new Pierna());
        figuras.add(new Par());
        figuras.add(new SinFigura());
    }

    public ResultadoMano obtenerPuntaje(ArrayList<Carta> cartas) {
        ResultadoMano resultado = new ResultadoMano();
        FiguraStrategy figuraResultado = null;
        int puntaje = -1;
        for (FiguraStrategy figura : figuras) {
            resultado = figura.validar(cartas);
            int puntajeFigura = resultado.getValor();
            if(puntajeFigura > puntaje){
                puntaje = puntajeFigura;
                figuraResultado = figura;
            }
        }
        
        resultado.setGanadora(figuraResultado);
        resultado.setValor(puntaje);
        return resultado;
    }

    public void IngresarAMesa(Jugador jugador, int index) throws PokerException {
        if(index<0){
            throw new PokerException("Debe seleccionar una mesa.");
        }
        Mesa mesa = obtenerMesasAbiertas().get(index);
        for(Mesa mesaBusqueda : mesas){
            if(mesaBusqueda.tieneJugador(jugador)){
                throw new PokerException("El jugador ya se encuentra en una mesa");
            }
        }
        
        mesa.AgregarJugador(jugador);
        this.avisar(EventoMesa.ACTUALIZAR_MESAS_JUGADOR);
        this.avisar(EventoMesa.ACTUALIZAR_MESAS_ADMINISTRADOR);
        this.avisar(EventoMesa.ACTUALIZAR_PANEL);
    }

    public List<FiguraStrategy> obtenerFiguras() {
        return figuras;
    }
    
    public Mesa obtenerMesaDeJugador(Jugador jugador){
        for (Mesa mesa : mesas) {
            if(mesa.tieneJugador(jugador)) return mesa;
        }
        return null;
    }
    
    public void SalirDeMesa(Jugador jugador) throws PokerException {
        Mesa mesa = obtenerMesaDeJugador(jugador);
        if(mesa!=null){
            mesa.QuitarJugador(jugador);
            this.avisar(EventoMesa.ACTUALIZAR_MESAS_JUGADOR);
            this.avisar(EventoMesa.ACTUALIZAR_MESAS_ADMINISTRADOR);
            this.avisar(EventoMesa.ACTUALIZAR_PANEL);
        }else{
            throw new PokerException("El jugador no se encuentra en ninguna mesa.");
        }
    }
    
    public void proximaManoMesa(Mesa mesa){
        mesa.proximaMano();
        this.avisar(EventoMesa.ACTUALIZAR_PANEL);
        this.avisar(EventoMesa.ACTUALIZAR_MESAS_ADMINISTRADOR);
    }

    public void continuarJugando(Jugador jugador, boolean quiere, Mesa mesa) throws PokerException {
        mesa.continuarJugando(jugador, quiere);
        this.avisar(EventoMesa.ACTUALIZAR_PANEL);
        this.avisar(EventoMesa.ACTUALIZAR_MESAS_ADMINISTRADOR);
    }

    public Mesa obtenerMesa(int indiceMesa) throws PokerException {
        if(indiceMesa > -1){
            return mesas.get(indiceMesa);
        }
        
        throw new PokerException("No se ha encontrado la mesa");
    }
}
