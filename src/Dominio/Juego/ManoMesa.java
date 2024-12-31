
package Dominio.Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import panelCartasPoker.CartaPoker;


public class ManoMesa {
    private List<Carta> mazo = new ArrayList();
    private EstadoMano estadoMano = EstadoMano.EsperandoApuesta;
    private double pozo = 0;
    private double apuesta = 0;
    
    public ManoMesa(){
        estadoMano = EstadoMano.EsperandoApuesta;
        crearMazo();
    }
    public ManoMesa(double pozo){
        estadoMano = EstadoMano.EsperandoApuesta;
        this.pozo=pozo;
        crearMazo();
    }
    public EstadoMano getEstadoMano() {
        return estadoMano;
    }
    
    public String getEstadoManoString() {
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

    public double getApuesta() {
        return apuesta;
    }

    public void setApuesta(double apuesta) {
        this.apuesta = apuesta;
    }
    
    public void modificarPozo(double valor){
        this.pozo += valor;
    }

    public double getPozo() {
        return pozo;
    }
    
    private void crearMazo(){
        mazo.add(new Carta(CartaPoker.AS,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.AS,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.AS,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.AS,CartaPoker.PIQUE));
        
        mazo.add(new Carta(CartaPoker.DOS,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.DOS,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.DOS,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.DOS,CartaPoker.PIQUE));
        
        mazo.add(new Carta(CartaPoker.TRES,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.TRES,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.TRES,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.TRES,CartaPoker.PIQUE));
        
        mazo.add(new Carta(CartaPoker.CUATRO,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.CUATRO,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.CUATRO,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.CUATRO,CartaPoker.PIQUE));
        
        mazo.add(new Carta(CartaPoker.CINCO,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.CINCO,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.CINCO,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.CINCO,CartaPoker.PIQUE));
        
        mazo.add(new Carta(CartaPoker.SEIS,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.SEIS,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.SEIS,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.SEIS,CartaPoker.PIQUE));
        
                
        mazo.add(new Carta(CartaPoker.SIETE,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.SIETE,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.SIETE,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.SIETE,CartaPoker.PIQUE));
        
                
        mazo.add(new Carta(CartaPoker.OCHO,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.OCHO,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.OCHO,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.OCHO,CartaPoker.PIQUE));
        
                
        mazo.add(new Carta(CartaPoker.NUEVE,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.NUEVE,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.NUEVE,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.NUEVE,CartaPoker.PIQUE));
        
                
        mazo.add(new Carta(CartaPoker.DIEZ,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.DIEZ,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.DIEZ,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.DIEZ,CartaPoker.PIQUE));
        
        mazo.add(new Carta(CartaPoker.J,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.J,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.J,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.J,CartaPoker.PIQUE));
        
        mazo.add(new Carta(CartaPoker.Q,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.Q,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.Q,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.Q,CartaPoker.PIQUE));
        
        mazo.add(new Carta(CartaPoker.K,CartaPoker.CORAZON));
        mazo.add(new Carta(CartaPoker.K,CartaPoker.DIAMANTE));
        mazo.add(new Carta(CartaPoker.K,CartaPoker.TREBOL));
        mazo.add(new Carta(CartaPoker.K,CartaPoker.PIQUE));
    }
    
    public void setEstadoMano(EstadoMano estadoMano) {
        this.estadoMano = estadoMano;
    }
    
    public ArrayList<Carta> obtenerManoCartas(){
        ArrayList<Carta> mano = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<5;i++){
            int indiceAleatorio = random.nextInt(mazo.size());
            Carta carta = mazo.get(indiceAleatorio);
            mano.add(carta);
            mazo.remove(carta);
        }
        
        return mano;
    }
    
    public ArrayList<Carta> cambiarCartas(ArrayList<Carta> cartas){
        ArrayList<Carta> nuevo = new ArrayList();
        
        for(Carta c:cartas){
            
            if(c.estaVisible()){
                nuevo.add(c);
            }
        }
        
        Random random = new Random();
        for(int i=nuevo.size(); i<5; i++){
            int indiceAleatorio = random.nextInt(mazo.size());
            Carta carta = mazo.get(indiceAleatorio);
            nuevo.add(carta);
            mazo.remove(carta);
        }
        
        return nuevo;
    }
}
