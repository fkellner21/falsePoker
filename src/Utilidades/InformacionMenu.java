package Utilidades;

import Dominio.Juego.Mesa;
import Dominio.Usuarios.Jugador;
import java.util.List;


public class InformacionMenu {
    private List<Mesa> mesas;
    private double saldoJugador;
    private String nombreJugador;
    private Mesa mesa;
    private Jugador jugadorGanador;
    
    public InformacionMenu() {
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public void setSaldoJugador(double saldoJugador) {
        this.saldoJugador = saldoJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    
    public List<Mesa> getMesas() {
        return mesas;
    }

    public double getSaldoJugador() {
        return saldoJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }
}
