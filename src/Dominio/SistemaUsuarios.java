package Dominio;
import Dominio.Usuarios.Usuario;
import java.util.ArrayList;

public class SistemaUsuarios {
private ArrayList<Usuario> usuariosAdministrador = new ArrayList<Usuario>();
    private ArrayList<Usuario> usuariosJugador = new ArrayList<Usuario>();

    
    public Usuario Login(String cedula, String password, boolean esAdmin) throws PokerException {
        String cedulaLimpia = cedula.trim().replace(".", "").replace("-", "");
        ArrayList<Usuario> usuarios = usuariosJugador;

        if(esAdmin){
            usuarios = usuariosAdministrador;
        }
        
        for(Usuario u:usuarios){
            if(u.getCedula().equals(cedulaLimpia) && u.getPassword().equals(password)){
                if(u.isEstaLogueado()){
                    throw new PokerException("Acceso denegado: El usuario ya esta logueado.");
                }
                
                u.setEstaLogueado(true);
                return u;
            }
        }
        
        throw new PokerException("Credenciales incorrectas.");
    }
    
    public void AgregarUsuario(Usuario usuario, boolean esAdmin) throws PokerException{
        usuario.validar();
        ArrayList<Usuario> usuarios = usuariosJugador;
        if(esAdmin){
            usuarios = usuariosAdministrador;
        }
       
        if(usuarios.contains(usuario)){
            throw new PokerException("Ya existe un usuario de ese tipo con esa cedula");
        }
        
        usuarios.add(usuario);
    }

    void desloguear(Usuario usuario) {
        usuario.desloguear();
    }
}
