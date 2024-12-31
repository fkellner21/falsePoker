
package Dominio.Juego;

import java.util.ArrayList;
import java.util.Collections;

public class Escalera extends FiguraStrategy{
    
    public Escalera() {
        super("escalera");
    }
    
    @Override
    public ResultadoMano validar(ArrayList<Carta> mano){
        Collections.sort(mano);
        int valorTotal = mano.get(0).getValorCartaReal();
        ResultadoMano resultado = new ResultadoMano();
        resultado.setValor(-1);
        
        for (int i = 1; i < mano.size(); i++) {
            if(mano.get(i).getValorCartaReal()-mano.get(i-1).getValorCartaReal()==1){
                valorTotal += mano.get(i).getValorCartaReal();
            }else{
                return resultado;
            }
        }
        resultado.setValor(300 + valorTotal + (mano.getFirst().getValorCartaReal()*mano.getFirst().getValorPalo()/10)/100);
        resultado.setValorMasAlto(mano.getFirst().getValorCartaReal());
        return resultado;
    }

}
