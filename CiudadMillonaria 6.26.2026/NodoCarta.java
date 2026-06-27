//Clase Nodo contenedor de una Carta

public class NodoCarta
{
    //Llena una carta 
    private Carta carta;
    //Puntero a un NodoCarta siguiente
    private NodoCarta siguiente;
    
    //Constructor recibe carta para almacenar
    public NodoCarta(Carta c) {
        this.carta = c;
        //Puntero a siguiente NodoCarta inicia nulo
        this.siguiente = null;
    }
    
    
    //setters
    //Setear NodoCarta siguiente
    public void setSiguiente(NodoCarta n) {
        this.siguiente = n;
    }
    
    //Getters
    //Retornar carta almacenada
    public Carta getCarta(){
        return this.carta;
    }
    //Retornar NodoCarta siguiente
    public NodoCarta getSiguiente() {
        return this.siguiente;
    }
    
    
    
    
    
}