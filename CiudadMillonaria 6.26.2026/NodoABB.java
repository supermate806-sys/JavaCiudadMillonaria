//Clase que contiene un jugador para el ranking

public class NodoABB
{
    //jugador almacenado
    private Jugador jugador;
    //Puntero a NodoABB derecho
    private NodoABB derecho;
    //Puntero a NodoABB izquierdo
    private NodoABB izquierdo;
    
    //Constructor recibe jugador e inicializa atributos
    public NodoABB(Jugador jugador){
        this.jugador = jugador;
        this.derecho = null;
        this.izquierdo = null;
    }
    //Getters
    //Retornar jugador almacenado
    public Jugador getJugador(){
        return this.jugador;
    }
    //Retornar NodoABB derecho
    public NodoABB getDerecho(){
        return this.derecho;
    }
    //Retornar NodoABB izquierdo
    public NodoABB getIzquierdo(){
        return this.izquierdo;
    }
    //Setear NodoABB izquierdo, recibe el NodoABB
    public void setIzquierdo(NodoABB izquierdo){
        this.izquierdo = izquierdo;
    }
    //Setear NodoABB derecho, recibe el NodoABB
    public void setDerecho(NodoABB derecho){
        this.derecho = derecho;
    }
    
}