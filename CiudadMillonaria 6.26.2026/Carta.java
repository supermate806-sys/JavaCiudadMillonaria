//Clase representa cada Carta del juego

public class Carta
{
    //Descripcion de la carta
    private String descripcion;
    //Accion que realiza la carta al jugador
    private String accion;
    //Valor de la carta segun aplique
    private int valor;
    //Constructor recibe los atributos y los inicializa
    public Carta(String descripcion, String accion, int valor){
        this.descripcion = descripcion;
        this.accion = accion;
        this.valor = valor;
    }
    
    
    //Getters
    //Retornar la descripcion de la carta
    public String getDescripcion() {
        return this.descripcion;
    }
    //Retortnar la accion de la carta
    public String getAccion() {
        return this.accion;
    }
    //retornar el valor de la carta
    public int getValor() {
        return this.valor;
    }
    
    //Mostrar informacion de la carta en pantalla, retorna un String con la informacion
    @Override
    public String toString() {
        String info = this.descripcion + " | " + this.accion;
        
        if (this.valor < 0) {
            info += " | " + this.valor;
        }
        return info;
    }
    
}