//Clase representa cada Casa del juego

public class Casa
{
    //Numero de casa
    private int numero;
    //Aumento del alquiler de la casa
    private int aumentoAlquiler;
    //Menu para imprimir ordemandamente 
    Menu menu;
    
    //Constructor recibe parametros y los inicializa
    public Casa(int numero, int aumentoAlquiler){
        this.numero = numero;
        this.aumentoAlquiler = aumentoAlquiler;
        //Inicializa el menu
        this.menu = new Menu();
    }
    
    //Getters
    //Retornar numero de casa
    public int getNumero(){
        return this.numero;
    }
    //Retornar aumento de alquiler
    public int getAumentoAlquiler() {
        return this.aumentoAlquiler;
    }
    //Mostrar informacion de la casa ordemandamente
    public void mostrarInfo(){
        this.menu.dibujarGeneral("Casa numero " + this.numero);
        this.menu.dibujarGeneral("Aumento de alquiler: $" + this.aumentoAlquiler);
 
    }
    
    
    //ToString para imprimir la informacion en otro formato
     @Override
     public String toString() {
         String info = "║ ║ ║ Casa numero " + this.numero + "║ ║ ║ Aumento de alquiler: $" + this.aumentoAlquiler + "\n";
        
        
        
         return info;
     }
}