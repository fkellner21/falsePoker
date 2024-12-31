package Controllers;

import Dominio.Fachada;
import Dominio.PokerException;
import Dominio.Usuarios.Usuario;
import UI.IError;

public class ControladorUsuarios {
    
    public Usuario Login(String cedula, String password, boolean esAdmin, IError origen){
        try {
            return Fachada.getInstancia().Login(cedula, password, esAdmin);
        } catch (PokerException ex) {
            origen.mostrarError(ex.getMessage());
            return null;
        }
    }
}
