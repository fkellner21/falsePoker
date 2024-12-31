package Dominio.Juego;

import java.util.Objects;
import panelCartasPoker.CartaPoker;

public class Carta implements CartaPoker, Comparable<Carta>{
    private int numero;
    private String palo;
    private boolean visible = true;

    public Carta(int num, String palo) {
        this.numero = num;
        this.palo = palo;
    }
    
    public int getValorPalo(){
        switch(palo){
            case "C":
                return 4;
            case "D":
                return 3;
            case "T":
                return 2;
            case "P":
                return 1;
        }
        return 0;
    }
    
    public int getValorCartaReal(){
        if(numero == 1){
            return 14;
        }
        
        return numero;
    }
    
    @Override
    public int getValorCarta() {
        return numero;
    }

    @Override
    public String getPaloCarta() {
        return palo;
    }

    @Override
    public boolean estaVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean b) {
        visible = b;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return Objects.equals(this.palo, other.palo);
    }

    @Override
    public int compareTo(Carta o) {
        return Integer.compare(this.getValorCartaReal(), o.getValorCartaReal()); 
    }
}
