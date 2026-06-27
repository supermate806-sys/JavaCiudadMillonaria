//Clase Nodo sirve como contenedor de Casillas 

public class NodoCasilla
{
    //Puntero a nodo anterior 
    private NodoCasilla anterior;
    //Puntero a nodo siguiente
    private NodoCasilla siguiente;
    //Casilla que guarda
    private Casilla casilla;
    
    //Constructor recibe casilla y la asigna a la clase
    public NodoCasilla(Casilla casilla){
        this.casilla = casilla;
        
        //El nodo anterior y siguiente se inicializan nulos
        this.anterior = null;
        this.siguiente = null;
    }
    
    //Gettes
    //Retornar el Nodo anterior
    public NodoCasilla getAnterior(){
        return this.anterior;
    }
    //Retornar el Nodo siguiente
    public NodoCasilla getSiguiente(){
        return this.siguiente;
    }
    //Retornar la casilla contenida
    public Casilla getCasilla(){
        return this.casilla;
    }
    
    //Setters
    //Setear Nodo anterior, recibe NodoCasilla
    public void setAnterior(NodoCasilla nodo){
        anterior = nodo;
    }
    //Setear Nodo siguiente, recibe NodoCasilla
    public void setSiguiente(NodoCasilla nodo){
        siguiente = nodo;
    }
}