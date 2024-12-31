package Controllers;

import Dominio.EventoMesa;
import Dominio.Fachada;
import Dominio.Juego.FiguraStrategy;
import Dominio.Juego.Mesa;
import Dominio.PokerException;
import Dominio.Usuarios.Jugador;
import UI.IVista;
import Utilidades.InformacionPanel;
import Utilidades.Observable;
import Utilidades.Observador;
import java.util.List;

public class ControladorPanelJugador implements Observador {
    private Fachada fachada = Fachada.getInstancia();
    private Jugador jugador;
    private IVista vista;
    int indiceMesa;
    
    public ControladorPanelJugador(IVista vista, Jugador jugador, int indiceMesa) {
        this.vista = vista; 
        this.jugador = jugador;
        this.indiceMesa = indiceMesa;
        fachada.agregarObservador(this);
        cargarDatos();
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento.equals(EventoMesa.ACTUALIZAR_PANEL)){
            cargarDatos();
        }
    }
    
    public void cargarDatos(){
        try {
            Mesa mesa = fachada.obtenerMesa(indiceMesa);

            InformacionPanel informacion = new InformacionPanel(jugador.getNombreCompleto(), jugador.getSaldo(), mesa.getNumero(), mesa.getManoMesaActual().getPozo(),
                mesa.getNumeroManoActual(), mesa.getManoMesaActual().getEstadoManoString(), mesa.getManoMesaActual().getApuesta(), fachada.obtenerFiguras(), mesa.getJugadores(),
                mesa.getJugadorGanador(), mesa.getFiguraGanadora(), jugador.getMano().getCantidadCartasCambiadas(), jugador.getMano().getEstadoManoJugadorString(),
                jugador.getMano().getFiguraGanadora(), jugador.getMano().getCartas(), mesa.getEstadoMesa(), jugador.getMano().getEstadoManoJugador(),
                mesa.getManoMesaActual().getEstadoMano());
            
            vista.cargarDatos(informacion);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
   
    public void SalirDeMesa() {
        try {
            fachada.SalirDeMesa(jugador);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
        
    public void proximaManoMesa(){
        try {
            Mesa mesa = fachada.obtenerMesa(indiceMesa);
            fachada.proximaManoMesa(mesa);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void continuarJugando() {
        try {
            Mesa mesa = fachada.obtenerMesa(indiceMesa);
            fachada.continuarJugando(jugador, true, mesa);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public List<FiguraStrategy> obtenerFiguras(){
        return fachada.obtenerFiguras();
    }
    
    public void pasarMano(){
        try {
            Mesa mesa = fachada.obtenerMesa(indiceMesa);
            fachada.pasarMano(mesa, jugador);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public void pedirCartas(){
        try {
            Mesa mesa = fachada.obtenerMesa(indiceMesa);
            fachada.pedirCartas(mesa, jugador);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public void RealizarApuesta(String apuesta){
        try {
            double apuestaParseada = Double.parseDouble(apuesta);
            Mesa mesa = fachada.obtenerMesa(indiceMesa);
            fachada.realizarApuesta(mesa, apuestaParseada, jugador);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        } catch (NumberFormatException ex){
            vista.mostrarError("Hubo un error, contacte al administrador.");
        }
    }
    
    public void igualarApuesta(){
        try {
            Mesa mesa = fachada.obtenerMesa(indiceMesa);
            fachada.igualarApuesta(mesa, jugador);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
}
