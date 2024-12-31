package Dominio.Usuarios;

import java.util.ArrayList;

public class Administrador extends Usuario{
    
  
    public Administrador(String Cedula, String Password, String NombreCompleto) {
        super(Cedula, Password, NombreCompleto);
    }
       
    @Override
    public boolean equals(Object o){
        return o instanceof Administrador admin && this.getCedula() == admin.getCedula();
    }

}
