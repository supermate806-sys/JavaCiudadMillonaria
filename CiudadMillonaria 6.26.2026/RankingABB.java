public class RankingABB
{
    private NodoABB raiz;
    private int rank;
    Menu menu;
    //Constructor
    public RankingABB(){
        this.raiz = null;
        this.rank = 1;
        this.menu = new Menu();
    }
    
    //Agregar jugador al arbol que se crea
    public void agregarAlArbol(Jugador jugador){
        this.raiz = agregar(raiz, jugador);
    }
    //método recursivo para agregar a un árbol arbitrario
    private NodoABB agregar(NodoABB raiz, Jugador jugador){
        //método para agregar comparando con las propiedades
        NodoABB nodoNuevo = new NodoABB(jugador);
        if(raiz == null){
            return nodoNuevo; //caso base: insertar en la raíz
        }
        if(jugador.getPropiedades().calcValorTotal()< raiz.getJugador().getPropiedades().calcValorTotal()){
            raiz.setIzquierdo(agregar(raiz.getIzquierdo(), jugador)); //busca dónde agregar si a la izquierda
        }else if (jugador.getPropiedades().calcValorTotal()>= raiz.getJugador().getPropiedades().calcValorTotal()){
            raiz.setDerecho(agregar(raiz.getDerecho(), jugador)); //o a la derecha
        }
        return raiz; //devuelve el árbol reconstruido con el nodo nuevo
    }
    //método recursivo de búsqueda
    private boolean buscar(NodoABB raiz, Jugador jugador){
        if(raiz == null){
            return false; //si no hay jugadores devuelve false
        }
        if(raiz.getJugador().getPropiedades().calcValorTotal()== jugador.getPropiedades().calcValorTotal()){
            return true; ////si coincide con la raíz  devuelve verdadero
        }
        if(raiz.getJugador().getPropiedades().calcValorTotal()<jugador.getPropiedades().calcValorTotal()){
            return buscar(raiz.getIzquierdo(), jugador); // si no coincide con la raíz y es menor (patrimonio), devuelve el método evaluado en el izquierdo
        }
        return buscar(raiz.getDerecho(), jugador); //similarmente, si no coincide con la raíz y es mayor (patrimonio) devuelve el método evaluado en la derecha
            
        
    }
     //busca en el árbol "fijo"
    public void buscarArbol(Jugador jugador){
        System.out.println("Buscando jugador: ");
        if(buscar(raiz,jugador)){
            System.out.println("Jugador encontrado: \n" + jugador.toString());
        }else{
            System.out.println("Jugador no encontrado");
        }
    }
    //método de búsqueda para del mayor patrimonio
    private NodoABB mayorPatrimonio(NodoABB raiz){
        if(raiz == null){
            return null; //si está vacío devuelve null
        }

        NodoABB temp = raiz;
        while(temp.getDerecho()!=null){
            temp = temp.getDerecho(); //recorre el árbol por la derecha
        }
        return temp; // devuelve el último

    }
    //método del árbol fijo
    public void mayorPatrimonioArbol(){
        this.menu.dibujarGeneral("Jugador con mayor patrimonio: \n " + mayorPatrimonio(raiz).getJugador().getNombre() + " | (" + mayorPatrimonio(raiz).getJugador().calcPatrimonio() + ")");
    }
    //método de búsqueda del menor (análogo al mayor)
    private NodoABB menorPatrimonio(NodoABB raiz){
        if(raiz== null){
            return null;
        }
        if(raiz.getIzquierdo()==null){
            return raiz;
        }
        NodoABB temp = raiz;
        while(temp.getIzquierdo()!=null){
            temp = temp.getIzquierdo();
        }
        return temp;

    }
    public void menorPatrimonioArbol(){
        this.menu.dibujarGeneral("Jugador con menor patrimonio: " + menorPatrimonio(raiz).getJugador().getNombre() + " | (" + menorPatrimonio(raiz).getJugador().calcPatrimonio() + ")");
    }
    //recorrido inOrden (ascendiente):
    private void inOrden(NodoABB raiz){
        if(raiz == null){
            return;
        }
        inOrden(raiz.getIzquierdo()); //baja por la izquierda
        
        this.menu.dibujarGeneral("Posición " + rank + " | " + raiz.getJugador().getNombre() + " | (" + raiz.getJugador().calcPatrimonio() + ")"); //imprime la info que va en la posición del ranking correspondiente 
        rank++;
        inOrden(raiz.getDerecho()); //recorre por la der
        
    }
    public void mostrarInOrden(){
        if(raiz==null){
            System.out.println("No hay lista.");
        }
        
        this.menu.dibujarGeneral("Ascendente (inorden)");
        inOrden(raiz);
        
    }
    //método de recorrido descendiente  (análogo al inOrden)
    private void descendente(NodoABB raiz){
        int rankInv = cuentaNodos(raiz);
        if(raiz==null){
            return;
        }
        descendente(raiz.getIzquierdo());
        
        
        descendente(raiz.getDerecho());
        this.menu.dibujarGeneral("Posición " + rankInv + " | " + raiz.getJugador().getNombre() + " | (" + raiz.getJugador().calcPatrimonio() + ")");
        }
    public void descendente(){
        if(raiz==null){
            System.out.println("La lista está vacía.");
        }
        
        this.menu.dibujarGeneral("Descendente");
        descendente(raiz);
        
    }
    private void preOrden(NodoABB raiz){
        if(raiz==null){
            return;
        }
        System.out.println(raiz.getJugador().toString());
        preOrden(raiz.getIzquierdo());
        preOrden(raiz.getDerecho());
    }
    public void preOrdenArbol(){
        if(raiz == null){
            System.out.println("La lista está vacía");
        }
        preOrden(raiz);
    }
    //recorrido preOrden
    private void postOrden(NodoABB raiz){
        if(raiz==null){
            return;
        }
        postOrden(raiz.getIzquierdo());
        postOrden(raiz.getDerecho());
        this.menu.dibujarGeneral("Post orden: " + raiz.getJugador().getNombre() + " (" + raiz.getJugador().calcPatrimonio()+")");
    }
    //recorrido postOrden
    public void postOrdenArbol(){
        if(raiz==null){
            System.out.println("La lista está vacía.");
            return;
        }
        postOrden(raiz);
    }
    private int altura(NodoABB raiz){
        if(raiz == null){
            return 0;
        }
        return 1+Math.max(altura(raiz.getDerecho()), altura(raiz.getIzquierdo()));
    }
    //cáculo de la altura;
    public void alturaArbol(){
        System.out.println("Altura del ranking: " + altura(raiz));
    }
    //cálculo del conteo de nodos
    private int cuentaNodos(NodoABB raiz){
        if(raiz == null){
            return 0;
        }
        return 1+cuentaNodos(raiz.getDerecho())+cuentaNodos(raiz.getIzquierdo());
    }
    
    public void cuentaNodosArbol(){
        this.menu.dibujarGeneral("Cantidad de nodos: " + cuentaNodos(raiz));
    }
    //método que llama a los demás para mostrar el ranking
    public void ranking(){
        this.menu.dibujarLineaBase();
        this.menu.dibujarGeneral("==== RANKING (ABB por patrimonio) ====");
        if(this.raiz==null){
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral("No hay jugadores");
            this.menu.dibujarLineaTope();
            return;
        }
        this.menu.dibujarGeneral("Cantidad de jugadores " + altura(raiz));
        cuentaNodosArbol();
        mostrarInOrden();
        this.menu.dibujarLineas(1);
        descendente();
        this.menu.dibujarLineaTope();
    }
    //método del reporte llama a otros métodos del árbol
    public void reporte(){
        this.menu.dibujarLineaBase();
        this.menu.dibujarGeneral("==== Reporte ====");
        if(this.raiz==null){
            this.menu.dibujarGeneral("No hay jugadores");
            return;
        }
        this.menu.dibujarGeneral("Recorrido ascendente: ");
        mostrarInOrden();
        this.menu.dibujarLineas(1);
        descendente();
        this.menu.dibujarLineas(1);
        menorPatrimonioArbol();
        this.menu.dibujarLineas(1);
        this.menu.dibujarGeneral("Ganador: ");
        mayorPatrimonioArbol();
        this.menu.dibujarLineaTope();
    }
}