package Controllers;

import Dominio.EventoMesa;
import Dominio.Fachada;
import Dominio.PokerException;
import Dominio.Usuarios.Jugador;
import Utilidades.Observable;
import Utilidades.Observador;
import Utilidades.InformacionMenu;
import UI.IMenuJugador;

public class ControladorMenuJugador implements Observador {

    private Fachada fachada = Fachada.getInstancia();
    private Jugador jugador;
    private IMenuJugador vista;

    public ControladorMenuJugador(IMenuJugador vista, Jugador jugador) {
        this.vista = vista;
        this.jugador = jugador;
        fachada.agregarObservador(this);
        mostrarValor();
    }

    public void IngresarAMesa(int indiceMesa) {
        try {
            fachada.IngresarAMesa(jugador, indiceMesa);
            vista.proximaVista(indiceMesa);
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

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento.equals(EventoMesa.ACTUALIZAR_MESAS_JUGADOR)) {
            mostrarValor();
        }
    }

    public void mostrarValor() {
        InformacionMenu informacion = new InformacionMenu();
        informacion.setNombreJugador(jugador.getNombreCompleto());
        informacion.setSaldoJugador(jugador.getSaldo());
        informacion.setMesas(fachada.obtenerMesasAbiertas());

        vista.cargarDatos(informacion);
    }

    public Jugador obtenerJugadorLogueado() {
        return jugador;
    }

    public void desloguear() {
        fachada.desloguear(jugador);
    }
}
