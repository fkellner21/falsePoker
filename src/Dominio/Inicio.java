package Dominio;

import UI.Login;

public class Inicio {

    public static void main(String[] args) {
        Precarga.Cargar();
        
        Login login = new Login();
        login.setVisible(true);
    }   
}
