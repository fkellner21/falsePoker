
package Dominio.Juego;

public class ResultadoMano {
    private int valor;
    private int valorMasAlto;
    private int valorPalo;
    private FiguraStrategy ganadora;

    public ResultadoMano() {
        
    }

    public int getValorPalo() {
        return valorPalo;
    }

    public void setValorPalo(int valorPalo) {
        this.valorPalo = valorPalo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValorMasAlto() {
        return valorMasAlto;
    }

    public void setValorMasAlto(int valorMasAlto) {
        this.valorMasAlto = valorMasAlto;
    }

    public FiguraStrategy getGanadora() {
        return ganadora;
    }

    public void setGanadora(FiguraStrategy ganadora) {
        this.ganadora = ganadora;
    }
    
    
}
