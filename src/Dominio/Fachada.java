package Dominio;

import Dominio.Juego.Carta;
import Dominio.Juego.FiguraStrategy;
import Dominio.Juego.Mesa;
import Dominio.Juego.ResultadoMano;
import Dominio.Usuarios.Administrador;
import Dominio.Usuarios.Jugador;
import Dominio.Usuarios.Usuario;
import Utilidades.Observador;
import java.util.ArrayList;
import java.util.List;

public class Fachada {
    private SistemaUsuarios sistemaUsuarios = new SistemaUsuarios();
    private SistemaJuego sistemaJuego = new SistemaJuego();
    private static Fachada instancia = new Fachada();
    
    public static Fachada getInstancia(){
        return instancia;
    }
    
    private Fachada(){    
    }
    
    public void pasarMano(Mesa mesa, Jugador jugador) throws PokerException{
            sistemaJuego.pasarMano(mesa, jugador);
    }    
   
    public void agregarObservador (Observador ob){
        sistemaJuego.agregarObservador(ob);
    }
    
    public SistemaJuego ObtenerSistemaJuego(){
        return sistemaJuego;
    }
    public Usuario Login(String cedula, String password, boolean esAdmin) throws PokerException{
        return sistemaUsuarios.Login(cedula, password, esAdmin);
    }
    
    public void AgregarUsuario(Usuario usuario, boolean esAdmin) throws PokerException{
        sistemaUsuarios.AgregarUsuario(usuario, esAdmin);
    }
    public ArrayList<Mesa> obtenerMesasAbiertas(){
        return sistemaJuego.obtenerMesasAbiertas();
    }
    
    public void agregarMesa (String cantidadJugadores, String montoBase, String comision) throws PokerException{
        sistemaJuego.agregarMesa(cantidadJugadores, montoBase, comision);
    }
    
    public ArrayList<Mesa> getMesas(){
        return sistemaJuego.getMesas();
    }
    
    public void cargarFiguras(){
        sistemaJuego.cargarFiguras();
    }

    public ResultadoMano obtenerPuntaje(ArrayList<Carta> cartas) {
        return sistemaJuego.obtenerPuntaje(cartas);
    }

    public void IngresarAMesa(Jugador jugador, int indice) throws PokerException {
        sistemaJuego.IngresarAMesa(jugador, indice);
    }
    public List<FiguraStrategy> obtenerFiguras(){
        return sistemaJuego.obtenerFiguras();
    }
    
    public void SalirDeMesa(Jugador jugador) throws PokerException {
        sistemaJuego.SalirDeMesa(jugador);
    }

    public void pedirCartas(Mesa mesa, Jugador jugador) throws PokerException {
        sistemaJuego.pedirCartas(mesa, jugador); 
    }

    public void realizarApuesta(Mesa mesa, double apuesta, Jugador jugador) throws PokerException {
        sistemaJuego.realizarApuesta(mesa, apuesta, jugador);
    }

    public void igualarApuesta(Mesa mesa, Jugador jugador) throws PokerException {
        sistemaJuego.igualarApuesta(mesa, jugador);
    }

    public void proximaManoMesa(Mesa mesa) {
        sistemaJuego.proximaManoMesa(mesa);
    }

    public void continuarJugando(Jugador jugador, boolean quiere, Mesa mesa) throws PokerException {
        sistemaJuego.continuarJugando(jugador, quiere, mesa);
    }

    public Mesa obtenerMesa(int indiceMesa) throws PokerException {
        return sistemaJuego.obtenerMesa(indiceMesa);
    }

    public void desloguear(Usuario usuario) {
        sistemaUsuarios.desloguear(usuario);
    }
}
