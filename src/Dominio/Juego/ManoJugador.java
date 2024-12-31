
package Dominio.Juego;

import Dominio.Fachada;
import Dominio.PokerException;
import Dominio.SituacionJugador;
import java.util.ArrayList;

public class ManoJugador {
    private ArrayList<Carta> cartas=new ArrayList();
    private ResultadoMano resultado = new ResultadoMano();
    private EstadoMano estadoMano = EstadoMano.EsperandoApuesta;
    private SituacionJugador situacion = SituacionJugador.AccionPendiente;
    private int CantidadCartasCambiadas = 0;

    public int getCantidadCartasCambiadas() {
        return CantidadCartasCambiadas;
    }

    public void setCantidadCartasCambiadas(int CantidadCartasCambiadas) {
        this.CantidadCartasCambiadas = CantidadCartasCambiadas;
    }
    
    public String getSituacionString() {
        switch(situacion){
            case situacion.AccionPendiente:
                return "Accion pendiente";
            case situacion.ApuestaIniciada:
                return "Apuesta iniciada";
            case situacion.ApuestaPagada:
                return "Apuesta pagada";
            case situacion.NoPagoLaApuesta:
                return "No pago la apuesta";
        }
        return "";
    }
    
    
    public SituacionJugador getSituacion() {
        return situacion;
    }

    public void setSituacion(SituacionJugador situacion) {
        this.situacion = situacion;
    }
    
    public EstadoMano getEstadoManoJugador() {
        return estadoMano;
    }
    
    public String getEstadoManoJugadorString() {
        switch(estadoMano){
            case estadoMano.ApuestaIniciada:
                return "Apuesta iniciada";
            case estadoMano.EsperandoApuesta:
                return "Esperando apuesta";
            case estadoMano.PidiendoCartas:
                return "Pidiendo cartas";
            case estadoMano.Terminada:
                return "Terminada";
        }
        return "";
    }

    public void setEstadoManoJugador(EstadoMano estado) throws PokerException {
        switch(estado){
            case EstadoMano.ApuestaIniciada: 
                if(!SituacionJugador.AccionPendiente.equals(situacion)){
                    throw new PokerException("Ya no puedes apostar");
                }
                situacion = SituacionJugador.ApuestaIniciada;
                estadoMano = estado;
                break;
            case EstadoMano.PidiendoCartas:
                if(SituacionJugador.AccionPendiente.equals(situacion) || SituacionJugador.NoPagoLaApuesta.equals(situacion)){
                    throw new PokerException("No es posible pedir cartas en este momento");
                }
                estadoMano = estado;
                break;
            case EstadoMano.Terminada:
                estadoMano = estado;
                break;
            default:
                estadoMano = EstadoMano.EsperandoApuesta;
                break;
        }    
    }
    
    public FiguraStrategy getFiguraGanadora(){
        return resultado.getGanadora();
    }
    
    public ResultadoMano obtenePuntaje(){
        resultado = Fachada.getInstancia().obtenerPuntaje(cartas);
        return resultado;
    }
    
    public ManoJugador(ArrayList<Carta> mano){
        this.setCartas(mano);
        obtenePuntaje();
    }

    public ArrayList<Carta> getCartas() {
        ArrayList<Carta> cartasPoker = new ArrayList();
        for(Carta carta : cartas){
            cartasPoker.add(carta);
        }
        
        return cartasPoker;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        ArrayList<Carta> cartasResultado = new ArrayList<Carta>();
        for(Carta c:cartas){
            c.setVisible(false);
            cartasResultado.add(c);
        }
        this.cartas = cartasResultado;
    }

    public void cambiarSituacion(SituacionJugador situacionNueva) throws PokerException {
        if(situacionNueva==SituacionJugador.NoPagoLaApuesta){
            if(!this.situacion.equals(SituacionJugador.AccionPendiente)){ 
                throw new PokerException("Ya has realizado una accion en esta mano");
            }    
            situacion=situacionNueva;
        }
        if(situacionNueva==SituacionJugador.ApuestaIniciada){
            situacion=situacionNueva;
        }

    }
}
