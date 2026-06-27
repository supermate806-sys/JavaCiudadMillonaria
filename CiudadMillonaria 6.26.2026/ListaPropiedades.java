//Clase representa lista de propiedades de un jugador, es una lista enlazada simple

public class ListaPropiedades
{
    //Almacena un NodoPropeidad como cabeza
    private NodoPropiedad cabeza;
    //menu para imprimir informacion ordenadamente
    Menu menu;
    
    //Constructor inicializa atributos
    public ListaPropiedades(){
        this.cabeza = null;
        this.menu = new Menu();
    }

    //Agregar una propiedad al final de la lista, recibe propiedad como parametro
    public void agregarPropiedad(Propiedad p) {
        NodoPropiedad nuevo = new NodoPropiedad(p);
        //Indica si al propiedad ya fue comprada y forma parte de la lista
        if(buscarPropiedad(p.getNombre())) {
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral("Propiedad ya comprada");
            
        } else {
            //Se agrega a la cabeza si la lista esta vacia
            if (this.cabeza == null) {
                this.cabeza = nuevo;
            } else {
                NodoPropiedad temp = this.cabeza;
                //Se agrega al final si la lista tiene al menos un Nodopropiedad
                while (temp.getSiguiente() != null) {
                    temp = temp.getSiguiente();
                }
                temp.setSiguiente(nuevo);
            }
        }
    }
    
    //Se agrega una casa solo si se encuentra dentro de la lista de propiedades
    public void agregarCasa(NodoCasilla actual) {
        NodoPropiedad temp = this.cabeza;
        NodoPropiedad propiedadEncontrada = null;
        Boolean propiedadAlmacenada = false;
        
        while (temp != null) {
            if (temp.getPropiedad() == actual.getCasilla().getPropiedad()){
                propiedadAlmacenada = true;
                propiedadEncontrada = temp;
            }
            temp = temp.getSiguiente();
        }
        
        if(propiedadAlmacenada) {
            int casasActuales = propiedadEncontrada.getPropiedad().getListaDeCasas().contarCasas();
            int alquilerBase = propiedadEncontrada.getPropiedad().getAlquilerBase();
            propiedadEncontrada.getPropiedad().agregarCasa(new Casa(casasActuales+1, (alquilerBase * (1+casasActuales / 10))));           
            
        } else {
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral("Construccion cancelada");
            this.menu.dibujarLineaTope();
        }
        
    }
    
    
    //Busca una propiedad a partir de su nombre
    public boolean buscarPropiedad(String nombre) {
        NodoPropiedad temp = this.cabeza;
        boolean propiedadEncontrada = false;
        if (this.cabeza == null) {
            return propiedadEncontrada;
        } else {
            while (temp != null && !propiedadEncontrada) {
                if (temp.getPropiedad().getNombre().equalsIgnoreCase(nombre)) {
                    propiedadEncontrada = true;
                    
                }
                temp = temp.getSiguiente();
            }
        }
        return propiedadEncontrada;
    }
    
    //Ordernar las propiedades de la lsita con ordenamiento de burbuja    
    public void ordenarPropiedadesBurbuja(){
        
        
        for (int i = 0; i < contarPropiedades() - 1; i++) {
            NodoPropiedad anterior = null;
            NodoPropiedad temp = this.cabeza;
            
            for (int j = 0; j < contarPropiedades() - 1 - i; j++) {
                NodoPropiedad actual = temp.getSiguiente();
                
                if(temp.getPropiedad().getValorTotal() > actual.getPropiedad().getValorTotal()) {
                    temp.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(temp);
                    
                    if (anterior == null) {
                        this.cabeza = actual;
                    } else {
                        anterior.setSiguiente(actual);
                    }
                
                    anterior = actual;
                } else {
                    anterior = temp;
                    temp = temp.getSiguiente();
                }
                
                
            }
            
        }
    }
    
    
    //Mostrar propiedades llama a bubblesort y despues las muestra en orden
    public void mostrarPropiedades(){
        //Indica si la lista esta vacia
        if (this.cabeza == null) {
            this.menu.dibujarGeneral("No hay propiedades");
        } else {
            int cantPropiedades = 1;

            ordenarPropiedadesBurbuja(); 
            
            NodoPropiedad temp = this.cabeza;
            
            while (temp != null) {
                this.menu.dibujarGeneral("Propiedad " + cantPropiedades + ":");
                temp.getPropiedad().mostrarInfo();
                if (temp.getSiguiente() != null) {
                    this.menu.dibujarGeneral("--------------------------");
                }
                temp = temp.getSiguiente();
                cantPropiedades++;
                this.menu.dibujarGeneral("══════════════════════════");
            }
        }
        
    }
    
    
    //Contar la cantidad de propiedades de la lista, retorna cantidad en entero
    public int contarPropiedades() {
        int cantPropiedades = 0;
        NodoPropiedad temp = this.cabeza;
        
        while (temp != null) {
            cantPropiedades++;
            temp = temp.getSiguiente();
        }
        
        return cantPropiedades;
    }
    
    //calcula y retonra el valor total de todas las propiedades sumadas
    public int calcValorTotal() {
        int valorTotal = 0;
        NodoPropiedad temp = this.cabeza;
        
        while (temp != null) {
            valorTotal += temp.getPropiedad().getValorTotal();
            temp = temp.getSiguiente();
        }
        
        return valorTotal;
    }
    
    //Retornar informacion de todas las propiedades en un String
    public String mostrarPropiedadesR(){
        if (this.cabeza == null) {
            return  "No hay propiedades";
        } else {
            
            ordenarPropiedadesBurbuja(); 
            
            NodoPropiedad temp = this.cabeza;
            String p = "";
            while (temp != null) {
                System.out.println();
                p += temp.getPropiedad().toString() + "\n";
                if (temp.getSiguiente() != null) {
                    p += " ║ ║--------------------------\n";
                }
                temp = temp.getSiguiente();
            }
            p += " ║ ╚══════════════════════════";
            return p;
        }
        
    }
}