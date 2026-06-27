//Clase representa contenedor de propiedades del juego

public class NodoPropiedad
{
    //Guarda una propiedad
    private Propiedad propiedad;
    //Puntero a NodoPropiedad siguiente
    private NodoPropiedad siguiente;
    
    //Constructor Inicializa atributos, recibe una propiedad y la almacena
    public NodoPropiedad(Propiedad propiedad){
        this.propiedad = propiedad;
        this.siguiente = null;
    }
    //Getters
    //Retornar NodoPropiedad siguiente
    public NodoPropiedad getSiguiente(){
        return siguiente;   
    }
    //Retornar propiedad almacenada
    public Propiedad getPropiedad(){
        return propiedad;
    }
    
    //Setters
    //Setear nodoPropiedad siguiente
    public void setSiguiente(NodoPropiedad n) {
        this.siguiente = n;
    }
}