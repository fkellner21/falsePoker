package Dominio.Usuarios;

import Dominio.PokerException;
import Dominio.PokerException;

public abstract class Usuario {
    private String Cedula;
    private String Password;
    private boolean EstaLogueado;
    private String NombreCompleto;
    
    public Usuario(String Cedula, String Password, String NombreCompleto) {
        this.Cedula = Cedula;
        this.Password = Password;
        this.NombreCompleto = NombreCompleto;
        this.EstaLogueado = false;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    protected Usuario() {
    }

    public String getCedula() {
        return Cedula;
    }

    public String getPassword() {
        return Password;
    }

    public boolean isEstaLogueado() {
        return EstaLogueado;
    }

    public void setEstaLogueado(boolean EstaLogueado) {
        this.EstaLogueado = EstaLogueado;
    }

    public void validar() throws PokerException {
       String cedulaLimpia = this.Cedula.trim().replace(".", "").replace("-", "");

        if(cedulaLimpia.isBlank() || this.Password.isBlank() || this.NombreCompleto.isBlank()){
            throw new PokerException("Debe ingresar todos los datos.");
        }
    }
    @Override
    public String toString() {
        return  NombreCompleto;
    }

    public void desloguear() {
        EstaLogueado = false;
    }
    
}
