package Dominio.Juego;

import java.util.ArrayList;

public abstract class FiguraStrategy {
    String nombre;
    
    public FiguraStrategy(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    
    
    public abstract ResultadoMano validar(ArrayList<Carta> cartas);
}
