//Clase representa cada propiedad del juego

public class Propiedad
{
    //Nombre de la propeidad
    private String nombre;
    //precio de la propiedad 
    private int precio;
    //Alquiler base de la propiedad
    private int alquilerBase;
    //precio de cada casa de la propiedad 
    private int precioCasa;
    //Lista de casas de la propiedad
    private ListaCasa listaDeCasas;
    //Dueno de la propeidad
    private Jugador dueno;
    //menu para imprimir en orden al informacion en pantalla
    private Menu menu;
    
    //Constructor recibe los atributos y los inicializa
    public Propiedad(String nombre, int precio, int alquilerBase, int precioCasa){
        this.nombre = nombre;
        this.precio = precio;
        this.alquilerBase = alquilerBase;
        this.precioCasa = precioCasa;
        this.listaDeCasas = new ListaCasa();
        this.menu = new Menu();
    }
    
    //Getters
    //Retornar nombre de la propiedad
    public String getNombre(){
        return this.nombre;
    }
    //Retornar precio de la propiedad
    public int getPrecio(){
        return this.precio;
    }
    //Retornar alquiler base de la propiedad
    public int getAlquilerBase() {
        return this.alquilerBase;
    }
    //retornar precio de construir casas en la propiedad
    public int getPrecioCasa() {
        return this.precioCasa;
    }
    
    //Retornar lista de casas de la propiedad
    public ListaCasa getListaDeCasas() {
        return this.listaDeCasas;
    }       
        
    //Agregar una casa a la lista de casas de la propiedad
    public void agregarCasa(Casa casa){
        listaDeCasas.construirCasa(casa);
    }
    //Contar cantidad de casas cosntruidas en la propiedad, retorna cantidad
    public int contarCasas(){
        return listaDeCasas.contarCasas();
    }
    
    //Retornar valor total de la propiedad, retorna valor entero
    public int getValorTotal() {
    
        int valorTotal = this.precio + (this.precioCasa * this.listaDeCasas.contarCasas());
        return valorTotal;
    
    }
    
    //Mostrar informacion de la propiedad ordenadamente en pantalla
    public void mostrarInfo(){
    
        this.menu.dibujarGeneral("Nombre: " + this.nombre);
        this.menu.dibujarGeneral("Precio: $" + this.precio);
        this.menu.dibujarGeneral("Alquier base: $" + this.alquilerBase);
        this.menu.dibujarGeneral("Precio de casa: $" + this.precioCasa);
        this.listaDeCasas.mostrarCasas();
    }
    
    //Mostrar informacion de la propiedad sin el nombre ordenadamente
    public void mostrarInfoSinNombre(){
    
        this.menu.dibujarGeneral("Precio: " + this.precio);
        this.menu.dibujarGeneral("Alquier base: " + this.alquilerBase);
        this.menu.dibujarGeneral("Precio de casa: " + this.precioCasa);
        this.listaDeCasas.mostrarCasas();
    }
    
    
    //Metodo toString para imprimir de forma distinta en pantalla
     @Override
     public String toString(){
         String info = "\n ║ ║ Nombre: " + this.nombre + "\n ║ ║ Precio: $" + this.precio + "\n ║ ║ Alquiler base: $" + this.alquilerBase + "\n ║ ║ Precio de casa: $" + this.precioCasa + "\n " + listaDeCasas.retornarCasas() + "\n ║ ║ Valor total: " + getValorTotal();
        
         return info;
    }
    
    }