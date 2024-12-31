package Dominio.Usuarios;

import Dominio.Juego.Carta;
import Dominio.Juego.EstadoMano;
import Dominio.Juego.ManoJugador;
import Dominio.PokerException;
import Dominio.SituacionJugador;
import java.util.ArrayList;
import java.util.List;

public class Jugador extends Usuario{
    private double saldo;
    private ManoJugador mano;
    private boolean continuarJugando = false;

    public boolean isContinuarJugando() {
        return continuarJugando;
    }
    
    public Jugador(String Cedula, String Password, String NombreCompleto, double monto) {
        super(Cedula, Password, NombreCompleto);
        this.saldo = monto;
    }

    public Jugador(String Cedula, String Password, String NombreCompleto) {
        super(Cedula, Password, NombreCompleto);
    }
    
    public void aumentarSaldo(double monto){
        this.saldo += monto;
    }
    
    public void pagar(double monto){
        this.saldo -= monto;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double monto) {
        this.saldo = monto;
    }
    
    public void setMano(ArrayList<Carta> mano){
        this.mano = new ManoJugador(mano);
    }
    
    public ManoJugador getMano(){
        return this.mano;
    }    
    
    public void cambiarEstadoMano(EstadoMano estado) throws PokerException{
        this.mano.setEstadoManoJugador(estado);
    }
    
    public void cambiarSituacionMano(SituacionJugador situacion) throws PokerException{
        this.mano.cambiarSituacion(situacion);
    }
        
    @Override
    public boolean equals(Object o){
        return o instanceof Jugador jugador && this.getCedula() == jugador.getCedula();
    }
    
    @Override
    public String toString() {
        return  this.getNombreCompleto() + " - " + this.getMano().getSituacionString();
    }

    public void continuarJugando(boolean quiere) {
        this.continuarJugando=quiere;
    }
    
    public EstadoMano obtenerEstadoMano(){
        return this.mano.getEstadoManoJugador();
    }
    
    public ArrayList<Carta> obtenerCartasDeSuMano(){
        return this.mano.getCartas();
    }

}