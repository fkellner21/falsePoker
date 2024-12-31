package Dominio;
import Dominio.Juego.Mesa;
import Dominio.Usuarios.Administrador;
import Dominio.Usuarios.Jugador;
import Dominio.Usuarios.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Precarga {
    public static void Cargar(){
        Fachada fachada = Fachada.getInstancia();
        
        try{
            Administrador admin = new Administrador("a", "a", "A 100");
            fachada.AgregarUsuario(admin, true);
            fachada.agregarMesa("2","200", "5");
            fachada.agregarMesa("3","400", "5");
            fachada.agregarMesa("4","300", "20");

            fachada.AgregarUsuario(new Administrador("100", "100", "A 100"), true);
            fachada.AgregarUsuario(new Administrador("200", "101", "A 200"), true);
            
            fachada.AgregarUsuario(new Jugador("0", "0", "J0", 0), false);
            fachada.AgregarUsuario(new Jugador("1", "1", "J1", 1000), false);
            fachada.AgregarUsuario(new Jugador("2", "2", "J2", 2000), false);
            fachada.AgregarUsuario(new Jugador("3", "3", "J3", 3000), false);
            fachada.AgregarUsuario(new Jugador("4", "4", "J4", 4000), false);
            fachada.AgregarUsuario(new Jugador("5", "5", "J5", 5000), false);
            fachada.AgregarUsuario(new Jugador("6", "6", "J6", 6000), false);
            fachada.AgregarUsuario(new Jugador("7", "7", "J7", 7000), false);
            fachada.AgregarUsuario(new Jugador("8", "8", "J8", 8000), false);
            fachada.AgregarUsuario(new Jugador("9", "9", "J9", 9000), false);
            
            fachada.cargarFiguras();
            
        }catch(PokerException ex){
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
