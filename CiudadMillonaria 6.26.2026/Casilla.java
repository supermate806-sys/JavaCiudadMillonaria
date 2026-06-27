//Clase que representa las casillas del tablero
public class Casilla{
    //Nombre de la casiila
    private String nombre;
    //Tipo de la casilla (propiedad,carcel,salida,premio,carta)
    private String tipo;
    //Precio si es comprable
    private int precio;
    //Alquiler si aplica
    private int alquilerBase;
    //Precio de cada casa si aplica
    private int precioCasa;
    //Dueno de la casilla si aplica
    private Jugador dueno;
    //Propiedad si tiene
    private Propiedad propiedad;
    //Menu para imprimir informacion enorden
    private Menu menu;
    //Constructor recibe parametros y les asigna cada valos
    public Casilla(String nombre, String tipo, int precio, int alquilerBase, int precioCasa){
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.alquilerBase = alquilerBase;
        this.precioCasa = precioCasa;
        //Se inicializa la propiedad con la informacion de la casilla si el tipo indicado es propiedad
        if(!tipo.equalsIgnoreCase("propiedad")){
            this.propiedad = null;
        } else {
            this.propiedad = new Propiedad(this.nombre, this.precio, this.alquilerBase, this.precioCasa);

        }
        //Dueno comienza en null tenga propiedad o no
        this.dueno = null;
        //Se inicializa el menu para impresion ordenada
        this.menu = new Menu();        
          
    }
    //Getters
    //Retornar el arquiler base
    public int getAlquilerBase(){
        return alquilerBase;
    }
    //Retornar el nombre de la casilla 
    public String getNombre(){
        return nombre;
    }
    //Retornar el tipo de la casilla
    public String getTipo(){
        return tipo;
    }
    //Retornar la propiedad de la casilla
    public Propiedad getPropiedad(){
        return this.propiedad;
    }
    //Retornar el precio de la casilla
    public int getPrecio(){
        return this.precio;
    }
    //Retornar el dueno de la casilla
    public Jugador getDueno(){
        return this.dueno;
    }
    //Retornar el precio de la casilla 
    public int getPrecioCasa(){
        return this.precioCasa;    
    }
    //Retornar si la casilla fue comprada
     private boolean comprada(){
        if(dueno != null){
            return true;
        }
        return false;
    }
    
    //Setters
    //Setear el dueno de la casilla, recibe un jugador 
    public void setDueno(Jugador dueno){
        this.dueno = dueno;
        
    }
    //Mostrar la informacion ordenada con el menu
       
    public void mostrarInfo(){
    
        //Se imprime la informacion de la propiedad siempre que no sea nula
        if(this.propiedad != null) {
            this.propiedad.mostrarInfoSinNombre();
            //Si tiene dueno se imprime su nombre
            if (this.dueno != null) {
                this.menu.dibujarGeneral("Dueno " + this.dueno.getNombre());
            } else {
                //Si no tiene dueno se indica que se puede comprar
                this.menu.dibujarGeneral("Se puede comprar");
            }
            
        }
        
          
    }
    //Metodo toString de las casillas para otro tipo de impresion en pantalla, retorna String con la informacion
    @Override
    public String toString(){
        //Se almacena toda la informacion de la casilla en un String info para retornarla
        String info = "\n ║ ║ Tipo: " + this.tipo + "\n ";
        
        if(this.propiedad != null) {
            info += "║ ║ " + this.propiedad.toString() + "\n" ;
        } else {
            info += "║ ║ "+ this.nombre + "\n";
        
        }
        
        if(this.dueno != null) {
            info += " ║ ║ Dueno: " + this.dueno.getNombre() + "\n" ;
        }
        
        info += " ║ ╚═════════════════════════";
        
        return info;
    }
    
}