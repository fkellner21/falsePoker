package Dominio.Juego;

import java.util.ArrayList;
import java.util.Collections;

public class Pierna extends FiguraStrategy {
    
    public Pierna() {
        super("pierna");
    }
    
    @Override
    public ResultadoMano validar(ArrayList<Carta> mano){
        Collections.sort(mano);
        int valorCarta = mano.get(0).getValorCartaReal();
        int contador = 1;
        ResultadoMano resultado = new ResultadoMano();
        resultado.setValor(-1);
        
        for (int i = 1; i < mano.size() && contador < 3; i++) {
            if(mano.get(i).getValorCartaReal() == mano.get(i-1).getValorCartaReal()){
                contador ++;
            }else{
                contador = 1;
                valorCarta = mano.get(i).getValorCartaReal();
            }
        }
        if(contador == 3){
            resultado.setValor(400 + valorCarta*3 + (mano.getFirst().getValorCartaReal()*mano.getFirst().getValorPalo()/10)/100);
            resultado.setValorMasAlto(mano.getFirst().getValorCartaReal());            resultado.setValorMasAlto(valorCarta);
        }
        return resultado;
    }

}
