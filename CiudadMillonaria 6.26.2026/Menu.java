
import java.util.Scanner;

public class Menu
{
    //esta clase es puramente estética
    private final int ALTO;
    private final int ANCHO;
    private Jugador[] jugadores;
    //constructor
    public Menu() {
        
        this.ALTO = 20;
        this.ANCHO = 50;
        this.jugadores = null;
    
    }
    //imprimir el menú
    public void mostrarMenu() {
        dibujarMarco();
        dibujarLineas(this.ALTO/5);
        dibujarOpciones();
        
    }
    
    //dibujo del marco (estos métodos se ilustran mejor en el main)
    public void dibujarMarco() {
        String titulo ="CIUDAD MILLONARIA";
        System.out.print("╔");
        for (int i = 0; i < this.ANCHO; i++) {
            System.out.print("═");
        
        }
        System.out.println("╗");
        System.out.print("║");
        for (int i = 0; i < (this.ANCHO/2) - (titulo.length()/ 2); i++) {
            System.out.print(" ");
        }
        System.out.print(titulo);
        for (int i = 0; i < (this.ANCHO/2) - (titulo.length()/2)-1; i++) {
            System.out.print(" ");
        }
        System.out.println("║");
        dibujarLineas(2);
        System.out.print("║");
        for (int i = 0; i < this.ANCHO; i++) {
            System.out.print("═");
        
        }
        System.out.print("║\n");
        
        
    }
    //dibujo de las líneas
    public void dibujarLineas(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            System.out.print("║");
            for (int j = 0; j < this.ANCHO; j++) {
                
                    System.out.print(" ");
                
                
            }
            System.out.println("║");
        }
    }
    //dibjuo de las opciones
        public void dibujarOpciones() {
            String opciones = "1) Cargar Tablero, 2) Registrar jugadores, 3) Iniciar partida, 4) Ver estado general , 5) Ver ranking (ABB), 6) Reporte general, 7) Salir";
            String listaOpciones[] = opciones.split(",");
            
            for(int i = 0; i <listaOpciones.length; i++) {
                System.out.print("║");
                for (int j = 0; j < ((this.ANCHO/2) - (listaOpciones[i].length() / 2)); j++) {
                    System.out.print(" ");
                    
                }
                
                System.out.print(listaOpciones[i]);
                
                for (int j = 0; j < ((this.ANCHO/2) - (listaOpciones[i].length() / 2) - 1); j++) {
                    System.out.print(" ");
                    
                }
                System.out.println("║");
                
            }
            dibujarLineas(2);
            String pregunta = "Introduzca una de las opciones anteriores";
            System.out.print("║");
            for (int i = 0; i < ((this.ANCHO/2) - (pregunta.length()/2)); i++){
                System.out.print(" ");
            }
            System.out.print(pregunta);
            for (int i = 0; i < ((this.ANCHO/2) - (pregunta.length()/2)-1); i++){
                System.out.print(" ");
            }
            System.out.println("║");
            
            System.out.print("╚");
            for (int i = 0; i < this.ANCHO; i++) {
                System.out.print("═");
            }
            System.out.println("╝");
            
    }
    //métodos de dibujo de opciones en general
    public void dibujarGeneral(String texto) {
        if(texto.length() % 2 != 0) {
            texto += " ";
        }
        
        
        System.out.print("║");
        for (int i = 0; i < (this.ANCHO/2) - (texto.length()/ 2); i++) {
            System.out.print(" ");
        }
        System.out.print(texto);
        for (int i = 0; i < (this.ANCHO/2) - (texto.length()/2); i++) {
            System.out.print(" ");
        }
        System.out.println("║");
    }
    
    public void dibujarLineaBase(){
        System.out.print("╔");
        for(int i = 0; i< this.ANCHO; i++) {
            System.out.print("═");
        }
        System.out.print("╗");
        System.out.println();
    }
    
    public void dibujarLineaTope(){
        System.out.print("╚");
        for(int i = 0; i< this.ANCHO; i++) {
            System.out.print("═");
        }
        System.out.print("╝");
        System.out.println();
    }
    
    
    
}