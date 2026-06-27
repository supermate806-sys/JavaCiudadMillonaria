//Clase que representa a cada jugador de Ciudad Millonaria
public class Jugador
{
    //Nombre del jugador
    private String nombre;
    //Dinero del jugador
    private int dinero;
    //Posicion del jugador se indica con un NodoCasilla del tablero
    private NodoCasilla posicion;
    //Lista de propiedades compradas por el jugador
    private ListaPropiedades propiedades;
    //turnos perdidos 
    private int turnosPerdidos;
    //Si el jugador esta activo
    private boolean activo;
    //Booleano de si ya lanzo el dado o no en cada ronda
    boolean dadoLanzado;
    //Menu para irmpirmir informacion ordenadamente
    Menu menu;
    
    //Constructor recibie e inicializa atributos
    public Jugador(String nombre, int dinero, NodoCasilla posicion){
        this.nombre = nombre;
        this.posicion = posicion;
        this.dinero = dinero;
        this.turnosPerdidos = 0;
        this.propiedades = new ListaPropiedades();
        this.activo = true;
        this.menu = new Menu();
    }
    
    //Getters
    //Retornar nomrbe del jugador
    public String getNombre(){
        return this.nombre;
    }
    //Retornar dinero del jugador
    public int getDinero(){
        return this.dinero;
    }
    //Retornar posicion del jugador (NodoCasilla)
    public NodoCasilla getPosicion(){
        return this.posicion;
    }
    //Retornar lista de propiedades del jugador
    public ListaPropiedades getPropiedades(){
        return this.propiedades;
    }
    //Retornar turnos perdidos del jugador
    public int getTurnosPerdidos(){
        return this.turnosPerdidos;
    }
    //Retornar si el jugador ya lanzo el dado 
    public boolean getDadoLanzado() {
        return this.dadoLanzado;
    }
    //Retornar estado del jugadorr
    public boolean getEstado() {
        return this.activo;
    }
    
    //Setter
    //Agregar dinero al jugador
    public void agregarDinero(int d){
        this.dinero += d;
    }

    //Cobrar dinero al jugador
    public void cobrarDinero(int d){
        this.dinero -= d;
    }
    //Agregar propiedad al jguador, recibe una rpopiedad
    public void agregarPropiedades(Propiedad propiedad){
        if(this.dinero >= propiedad.getPrecio()) {
            this.propiedades.agregarPropiedad(propiedad);
        } else {
            //Se agrega solo si tiene dinero suficiente para comprar la propeidad
            this.menu.dibujarGeneral("El jugador no tiene suficiente dinero para comprar la propiedad");
        }
    }
    //Cambiar al posicion del jugador
    public void setPosicionNueva(NodoCasilla posNueva){
        this.posicion = posNueva;
    
    }
    
    //Agregar turnos perdidos del jugador
    public void agregarTurnosPerdidos(int t){
        this.turnosPerdidos += t;
    }
    //Cambiar estado del jugador a inactivo
    public void cambiarEstado(){
            this.activo = false;
    }
    //Construir una casa en una propiedad del jugador 
    public void construirCasa(NodoCasilla actual) {
        this.propiedades.agregarCasa(actual);
    }
    
    //Calcular el patrimonio del jugador
    public int calcPatrimonio(){
        int patrimonioTotal = this.dinero;
        
        if(this.propiedades != null) {
            patrimonioTotal += propiedades.calcValorTotal();
        }
        
        return patrimonioTotal;
    }
    
    //Setear dado lanzado por el jugador
    public void setDadoLanzado(String s) {
        if (s.equalsIgnoreCase("t")){
            this.dadoLanzado = true;
        } else if (s.equalsIgnoreCase("f")) {
            this.dadoLanzado = false;
        }
        
        
        
    }
    
    
    
    //metodo toString para imprimir de otra manera la informacion
     @Override
     public String toString(){
         String informacion = "Nombre: " + nombre + " | dinero: " + this.dinero + "\n ║\n ║ Posicion actual:  " + this.posicion.getCasilla().toString();
         informacion += "\n ║ Propiedades(" + propiedades.contarPropiedades() + "):" + propiedades.mostrarPropiedadesR();  
    
        
         informacion += "\n ║ Estado: ";
        
         if(this.activo) {
             informacion += "Activo";
         } else {
             informacion += "Inactivo";
         }
        
         informacion += "\n ║ Patrimonio: $" + calcPatrimonio() + "\n";
         informacion += " ╚════════════════════════════";
         return informacion;
     }
}