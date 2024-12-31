package Utilidades;

import Dominio.Juego.Carta;
import Dominio.Juego.EstadoMano;
import Dominio.Juego.EstadoMesa;
import Dominio.Juego.FiguraStrategy;
import Dominio.Usuarios.Jugador;
import java.util.List;

public class InformacionPanel {
    private String nombreJugador;
    private double saldoJugador;
    private String manoJugador;
    private int numeroMesa;
    private double pozo;
    private int numeroManoActual;
    private String estadoString;
    private double apuesta;
    private List<FiguraStrategy> figuras;
    private List<Jugador> jugadores;
    private Jugador jugadorGanador;
    private FiguraStrategy figuraGanadoraMano;
    private int cantidadCartasCambiadas;
    private String estadoManoJugadorString;
    private FiguraStrategy figuraMasAltaJugador;
    private List<Carta> cartasJugador;
    private EstadoMesa estadoMesa;
    private EstadoMano estadoManoJugador;
    private EstadoMano estadoManoActual;
    
    public InformacionPanel(String nombreJugador, double saldoJugador, int numeroMesa, double pozo, int numeroManoActual, String estadoString, 
            double apuesta, List<FiguraStrategy> figuras, List<Jugador> jugadores, Jugador jugadorGanador, FiguraStrategy figuraGanadoraMano, 
            int cantidadCartasCambiadas, String estadoManoJugadorString, FiguraStrategy figuraMasAltaJugador, List<Carta> cartasJugador, EstadoMesa estadoMesa, EstadoMano estadoManoJugador,
            EstadoMano estadoManoActual) {
        this.nombreJugador = nombreJugador;
        this.saldoJugador = saldoJugador;
        this.numeroMesa = numeroMesa;
        this.pozo = pozo;
        this.numeroManoActual = numeroManoActual;
        this.estadoString = estadoString;
        this.apuesta = apuesta;
        this.figuras = figuras;
        this.jugadores = jugadores;
        this.jugadorGanador = jugadorGanador;
        this.figuraGanadoraMano = figuraGanadoraMano;
        this.cantidadCartasCambiadas = cantidadCartasCambiadas;
        this.estadoManoJugadorString = estadoManoJugadorString;
        this.figuraMasAltaJugador = figuraMasAltaJugador;
        this.cartasJugador = cartasJugador;
        this.estadoMesa = estadoMesa;
        this.estadoManoJugador = estadoManoJugador;
        this.estadoManoActual = estadoManoActual;
    }

    public EstadoMano getEstadoManoJugador() {
        return estadoManoJugador;
    }

    public EstadoMesa getEstadoMesa() {
        return estadoMesa;
    }

    public String getManoJugador() {
        return manoJugador;
    }
    
    public String getNombreJugador() {
        return nombreJugador;
    }

    public EstadoMano getEstadoManoActual() {
        return estadoManoActual;
    }

    public double getSaldoJugador() {
        return saldoJugador;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public double getPozo() {
        return pozo;
    }

    public int getNumeroManoActual() {
        return numeroManoActual;
    }

    public String getEstadoString() {
        return estadoString;
    }
    
    public double getApuesta() {
        return apuesta;
    }

    public List<FiguraStrategy> getFiguras() {
        return figuras;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public FiguraStrategy getFiguraGanadoraMano() {
        return figuraGanadoraMano;
    }

    public int getCantidadCartasCambiadas() {
        return cantidadCartasCambiadas;
    }

    public String getEstadoManoJugadorString() {
        return estadoManoJugadorString;
    }

    public FiguraStrategy getFiguraMasAltaJugador() {
        return figuraMasAltaJugador;
    }

    public List<Carta> getCartasJugador() {
        return cartasJugador;
    }
    
    
}
