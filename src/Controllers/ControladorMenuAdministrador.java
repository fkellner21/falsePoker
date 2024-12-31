package Controllers;

import Dominio.EventoMesa;
import Dominio.Fachada;
import Dominio.Juego.Mesa;
import Dominio.PokerException;
import Dominio.Usuarios.Administrador;
import Utilidades.Observable;
import Utilidades.Observador;
import UI.IVista;
import Utilidades.InformacionMenu;

public class ControladorMenuAdministrador implements Observador  {
    private Fachada fachada = Fachada.getInstancia();
    private Administrador administrador;
    private IVista vista;
    
    public ControladorMenuAdministrador(IVista vista, Administrador administrador) {
        this.vista = vista; 
        this.administrador = administrador;
        fachada.agregarObservador(this);
        mostrarValor();
    }
    
    public void obtenerMasInformacionMesa(IVista vista, int indiceMesa){
        try{
            Mesa mesa = fachada.obtenerMesa(indiceMesa);
            InformacionMenu datos = new InformacionMenu();
            datos.setMesa(mesa);
            vista.cargarInformacionAdicional(datos);
        }catch(PokerException ex){
            vista.mostrarError(ex.getMessage());
        }
    } 
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento.equals(EventoMesa.ACTUALIZAR_MESAS_ADMINISTRADOR)) {
            mostrarValor();
        }
    }
    
    public boolean agregarMesa(String cantidadJugadores, String montoBase, String comision){
        try {
            fachada.agregarMesa(cantidadJugadores, montoBase, comision);
            return true;
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
            return false;
        } catch (NumberFormatException e) {
            vista.mostrarError("Datos incorrectos, deben ser numeros.");
            return false;
        }
    }
    
    public void mostrarValor() {
        InformacionMenu informacion = new InformacionMenu();
        informacion.setMesas(fachada.getMesas());
        informacion.setMesa(null);

        vista.cargarDatos(informacion);
    }  

    public void desloguear() {
        fachada.desloguear(administrador);
    }
}
