//Clase que representa el mazo de cartas del juego, es una lista enlazaada simple circular

public class MazoCartas
{
    //Puntero al primer Nodocarta del mazo
    private NodoCarta primera;
    //Puntero al NodoCarta ultimo
    private NodoCarta ultima;
    //Puntero al actual NodoCarta en el mazo
    private NodoCarta actual;
    //Menu para imprimir con orden
    Menu menu;
    
    
    //Constructor inicializa el menu completamente y los NodoCarta en nulo
    public MazoCartas() {
        this.primera = null;
        this.ultima = null;
        this.actual = null;
        this.menu = new Menu();
    }
    
    //Agregar una carta al final del mazo, recibe la carta a agregar
    public void agregarCarta(Carta c) {
        //Se agrega la carta como primera y ultima si el mazo esta vacio
        if (this.primera == null) {
            NodoCarta nuevo = new NodoCarta(c);
            this.primera = nuevo;
            this.primera.setSiguiente(this.ultima);
            this.ultima = nuevo;
            this.ultima.setSiguiente(this.primera);
            this.actual = this.primera;
        } else {
            
            NodoCarta temp = this.primera;
            //Se recorre toda la lista temporal hasta llegar a la ultima carta
            do {
                temp = temp.getSiguiente();
            
            } while (temp != this.ultima);
            
            NodoCarta nuevo = new NodoCarta(c);
            temp.setSiguiente(nuevo);
            this.ultima = nuevo;
            nuevo.setSiguiente(this.primera);
            //Se agrega la carta al final de la lista circular
        }
    }
    
    //Tomar una acarta del mazo, retorna la carta tomada
    public Carta tomarCarta(){
        NodoCarta temp = this.actual;
        //Muestra la carta tomada
        mostrarCarta();
        this.actual = this.actual.getSiguiente();
        return temp.getCarta();
    }
    
    //Mostrar la carta actual
    public void mostrarCarta(){
        //Se imprime en pantalla la informacion ordenada
        this.menu.dibujarGeneral("Carta tomada: " + actual.getCarta().toString());
    }
    
    //Mostrar el mazo completo
    public void mostrarMazo(){
        NodoCarta temp = this.primera;
        if (this.primera == null) {
            System.out.println("La lista esta vacia");
        } else {
            System.out.println("Cartas en el mazo: ");
            do {
                System.out.println(temp.getCarta().toString());
                System.out.println();
                temp = temp.getSiguiente();
            } while (temp != this.primera);
        }
    }
}