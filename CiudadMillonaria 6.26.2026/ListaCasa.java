//Clase que representa la lista de casas de una propiedad

public class ListaCasa
{
    //Cabeza de la lista enlazada de NodoCasa
    private NodoCasa cabeza;
    //Contador de casas
    private int contador;
    //Menu para imprimir en orden
    private Menu menu;
    
    //Constructor inicializa la cabeza en nulo, el contador de casas en cero y el menu para imprimir en orden
    public ListaCasa(){
        this.cabeza = null;
        this.contador = 0; 
        this.menu = new Menu();
    }
    
    //Metodo para agregar casa a la lista, recibe la casa a agregar
    public void construirCasa(Casa casa){
       
        //Agrega la nueva casa a la cabeza si la lsita esta vacia
        if(this.cabeza == null){
             NodoCasa nuevo = new NodoCasa(casa);
            cabeza = nuevo;
            this.contador++;
            return;
        }
        
        //Agrega la casa al final de la lista si la lista no contiene 3 casa ya almacenadas
        if(contador < 3){
        
            NodoCasa actual = this.cabeza;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            this.contador++;
            Casa nueva = new Casa(contador, casa.getAumentoAlquiler());
            NodoCasa nuevo = new NodoCasa(nueva);
            actual.setSiguiente(nuevo);
            
            return;
        }else {
            //Se indica si la lista esta llena
            this.menu.dibujarGeneral("Máximo de casas de esta propiedad alcanzado");
            return;
        }
        
    }
    
    //contar las casas de la lsita, retorna entero con la cantidad contada
    public int contarCasas(){
        int contador = 0;
        //Retorna cero si la lista esta vacia
        if(cabeza==null){
            return 0;
        }else if (cabeza.getSiguiente()==null){
            //Retorna 1 si el siguiente a la cabeza es nulo
            return 1;
        }
        NodoCasa actual = cabeza;
        //Cuenta cuantos NodoCabeza hay que no sean nulos
        while(actual.getSiguiente()!=null){
            actual = actual.getSiguiente();
            contador++;
        }
        //Retorna el contador
        return contador;
        
    }
    
    //Calcular aumento del alquiler, retorna entero con el aumento
    public int calcAumentoAlquiler() {
        //Entero para retornar la cantidad
        int aumentoAlquiler = 0;
        //Retonra cero si la lista esta vacia
        if(this.cabeza == null) {
            return aumentoAlquiler;
        } else {
            //Suma al entero el aumento de alquiler de casa casa meintras no sean nulas
            NodoCasa temp = this.cabeza;
            while (temp != null) {
                aumentoAlquiler += temp.getCasa().getAumentoAlquiler();
                temp = temp.getSiguiente();
            }
        
        
        }
        
        
        //Retorna el entero
        return aumentoAlquiler;
    }
    
    //Mostrar las casas de la lista
    public void mostrarCasas(){
        
        ///Se indica si la lista esta vacia
        if (this.cabeza == null) {
            this.menu.dibujarGeneral("No tiene casas construidas");
            
        } else {
            //Se recorre la lista de casas imprimiendo la informacion de las casas encontradas que no son nulas de manera ordenada 
            int alquilerAuxiliar = 0;
            this.menu.dibujarGeneral("Casas construidas:");
            NodoCasa temp = this.cabeza;
            while (temp != null) {
                
                this.menu.dibujarGeneral("--------------------------");
                temp.getCasa().mostrarInfo();
                this.menu.dibujarGeneral("--------------------------");
                
                temp = temp.getSiguiente();
            }
            
        }
    }
    
    //Retornar casas en String para otro tipo de impresion
    public String retornarCasas(){
        String mostrar = "";
        if (this.cabeza == null) {
            return mostrar;
            
        } else {
            
            
            NodoCasa temp = this.cabeza;
            while (temp != null) {
                
                mostrar += temp.getCasa().toString();
                
                
                temp = temp.getSiguiente();
            }
            return mostrar;
        }
    }
    //Retonrar contador de casas
    public int getContador(){
        return this.contador;
    }
}