//Clase contenedora de Casas

public class NodoCasa
{
    //Casa que guarda
    private Casa casa;
    //Puntero a NodoCasa siguiente
    private NodoCasa siguiente;
    
    //Constructor recibe una casa y la almacena
    public NodoCasa(Casa casa){
        this.casa = casa;
        //NodoCasa siguiente inicia en nulo
        this.siguiente = null;
    }
    //getters
    //Retornar el NodoCasa siguiente
    public NodoCasa getSiguiente(){
        return siguiente;
    }
    //Retornar casa almacenada
    public Casa getCasa(){
        return casa;
    }
    //setters
    //Setear el NodoCasa siguiente, recibe un NOdoCasa
    public void setSiguiente(NodoCasa nodoC){
        this.siguiente = nodoC;
    }
}