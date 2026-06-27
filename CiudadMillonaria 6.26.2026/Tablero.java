//Clase que representa el tablero del juego, es una lista doblemente enlazada circular

public class Tablero
{
    //Puntero a la casila que es un NodoCasilla
    private NodoCasilla salida;
    //Puntero al ultimo NodoCasilla del tablero
    private NodoCasilla ultimo;
    //Constructor inicializa salida y ultimo en nulo
    public Tablero(){
        this.salida = null;
        this.ultimo = null;
    }
    
    //Agregar casillas al final del tablero
    public void agregarAlFinal(Casilla c){
        
        NodoCasilla nuevo = new NodoCasilla(c);
        //Se agrega el NodoCasilla como salida y ultimo si el tablero esta vacio
        if (this.salida == null) {
            this.salida = nuevo;
            this.ultimo = this.salida;
            this.salida.setSiguiente(this.ultimo);
            this.salida.setAnterior(this.ultimo);
            this.ultimo.setSiguiente(this.salida);
            this.ultimo.setAnterior(this.salida);
        } else {
            //Si el tablero no esta vacio se agrega el nuevo NodoCasillaal final del tablero 
            this.ultimo.setSiguiente(nuevo);
            this.salida.setAnterior(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(salida);
            //Se actualiza el puntero de Ultimo hacia el nuevo NodoCasilla
            this.ultimo = nuevo;
        }
    }
    
    //Getters
    //Retornar salida
    public NodoCasilla getSalida(){
        return this.salida;
    }
    //Retornar ultimo NodoCasilla del tablero
    public NodoCasilla getUltima(){
        return this.ultimo;
    }
    
    //Avanzar n casillas a partir de un NodoCasilla actual, retorna el NodoCasilla destino
    public NodoCasilla avanzar(NodoCasilla actual, int posiciones) {
        
        NodoCasilla destino = null;
        
        for(int i = 0; i < posiciones; i++) {
            actual = actual.getSiguiente();
            
        }
        
        destino = actual;
        
        return destino;
    }
    
    //Retronecer n casillas a partir de un NodoCasilla actual, retorna el NodoCasilla destino
    public NodoCasilla retroceder(NodoCasilla actual, int posiciones) {
        
        NodoCasilla destino = null;
        
        for(int i = 0; i < posiciones; i++) {
            actual = actual.getAnterior();
            
            
        }
        destino = actual;
        return destino;
    }
    
    
    //Buscar una casilla a partir de su nombre, imprime la casilla encontrada
    public void buscarCasilla(String nombre){
        NodoCasilla temp = this.salida;
        boolean encontrada = false;     
        System.out.println("Buscando casilla " + nombre);
        
        do {
            if (temp.getCasilla().getNombre().equalsIgnoreCase(nombre)){
                encontrada = true;
                System.out.println("Casilla encontrada:");
                System.out.println(temp.getCasilla().toString());
            }
            
            temp = temp.getSiguiente();
                    
        } while (temp != this.salida && !encontrada);
        
        if (encontrada == false) {
            System.out.println("No se encontro una casilla con ese nombre");
        }
        
    }
    
     //Buscar una casilla a partir de su nombre hasta encontrarla
    public NodoCasilla buscarCasilla(NodoCasilla n){
    
        NodoCasilla temp = this.salida;
        boolean encontrada = false;     
        
        do {
            if (temp.getCasilla().getNombre().equalsIgnoreCase(n.getCasilla().getNombre())){
                encontrada = true;
                
            }
            
            temp = temp.getSiguiente();
                    
            if(encontrada) {
                temp = temp.getAnterior();
            }
            
        } while (temp != this.salida && !encontrada);
        
        return temp;
    }
    
    //Mostrar el tablero en pantalla con cada Casilla
    public void mostrarTablero(){
        NodoCasilla temp = this.salida;
        System.out.println("\t <<<< Tablero >>>>");
        do {
            System.out.println(temp.getCasilla().toString());
            System.out.println();
            temp = temp.getSiguiente();
        
        } while(temp != this.salida);
        
    }
    
}