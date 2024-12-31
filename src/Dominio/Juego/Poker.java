package Dominio.Juego;

import java.util.ArrayList;
import java.util.Collections;

public class Poker extends FiguraStrategy {

    public Poker() {
        super("poker");
    }
    
    @Override
    public ResultadoMano validar(ArrayList<Carta> mano){
        Collections.sort(mano);
        int valorCarta = mano.get(0).getValorCartaReal();
        int contador = 1;
        ResultadoMano resultado = new ResultadoMano();
        resultado.setValor(-1);
        
        for (int i = 1; i < mano.size() && contador < 4; i++) {
            if(mano.get(i).getValorCartaReal() == mano.get(i-1).getValorCartaReal()){
                contador ++;
            }else{
                contador = 1;
                valorCarta = mano.get(i).getValorCartaReal();
            }
        }
        if(contador == 4){
            resultado.setValor(500 + valorCarta*4 + (mano.getFirst().getValorCartaReal()*mano.getFirst().getValorPalo()/10)/100);
            resultado.setValorMasAlto(mano.getFirst().getValorCartaReal());
        }
        return resultado;
    }
}
