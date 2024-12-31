/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Juego;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author pc
 */
public class Par extends FiguraStrategy {
    
    public Par() {
        super("par");
    }
    
    @Override
    public ResultadoMano validar(ArrayList<Carta> mano){
        Collections.sort(mano);
        int valorCarta = mano.get(mano.size()-1).getValorCartaReal();
        int contador = 1;
        ResultadoMano resultado = new ResultadoMano();
        resultado.setValor(-1);
        for (int i = mano.size()-1; i >= 1 && contador == 1; i--) {
            if(mano.get(i).getValorCartaReal() == mano.get(i-1).getValorCartaReal()){
                contador ++;
            }else{
                contador = 1;
                valorCarta = mano.get(i).getValorCartaReal();
            }
        }
        
        if(contador == 2){
            resultado.setValor(300 + valorCarta*2 + (mano.getFirst().getValorCartaReal()*mano.getFirst().getValorPalo()/10)/100);
            resultado.setValorMasAlto(mano.getFirst().getValorCartaReal());
        }
        return resultado;
    }
}
