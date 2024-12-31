
package Dominio.Juego;

import java.util.ArrayList;
import java.util.Collections;

public class SinFigura extends FiguraStrategy{
    
    public SinFigura() {
        super("sin figura");
    }
    
    @Override
    public ResultadoMano validar(ArrayList<Carta> mano){
        Collections.sort(mano);
        ResultadoMano resultado = new ResultadoMano();
        resultado.setGanadora(this);
        
        for (int i = 0; i < mano.size(); i++) {
            if(mano.get(i).getValorCartaReal() > resultado.getValor() && mano.get(i).getValorPalo() > resultado.getValorPalo()){
                resultado.setValor(mano.get(i).getValorCartaReal()*mano.get(i).getValorPalo());
                resultado.setValorMasAlto(mano.get(i).getValorCartaReal());
                resultado.setValorPalo(mano.get(i).getValorPalo());
            }
        }

        return resultado;
    }

}
