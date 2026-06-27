
import java.util.Scanner;

public class Juego
{
    private Menu menu;
    private Tablero tablero = new Tablero();
    private Scanner in;
    private Jugador[] jugadores;
    private boolean activo;
    private boolean tableroCreado;
    private boolean jugadoresAgregados;
    private boolean juegoActivo;
    private RankingABB arbol;
    private MazoCartas mazoDeCartas;
    
    
    public Juego(){
        this.menu = new Menu();
        this.in = new Scanner(System.in);
        this.activo = true;
        this.tableroCreado = false;
        this.jugadoresAgregados = false;
        this.juegoActivo = false;
        this.mazoDeCartas = new MazoCartas();
        Carta c1 = new Carta("Gana $50","premio", 50);
        Carta c2 = new Carta("Pierde $100","impuesto", 100);
        Carta c3 = new Carta("Avanzar 2 casillas","avanzar", 2);
        Carta c4 = new Carta("retroceder 4 casillas","retroceder", 4);
        Carta c5 = new Carta("Pierde 1 turno","pierdeTurno", 1);
        this.mazoDeCartas.agregarCarta(c1);
        this.mazoDeCartas.agregarCarta(c2);
        this.mazoDeCartas.agregarCarta(c3);
        this.mazoDeCartas.agregarCarta(c4);
        this.mazoDeCartas.agregarCarta(c5);
    }
    
    public void iniciar() {
        mostrarMenu();
    }
    
    public void mostrarMenu(){
        while (this.activo) {
            this.menu.mostrarMenu();
            String entrada = in.nextLine();
            recibirInput(entrada);
        }
    }
    
    public void recibirInput(String input) {
        switch(input) {
            case "1":
                cargarTablero(); 
                break;
                
            case "2": 
                registrarJugadores();
                break;
                
            case "3":
                iniciarPartida();
                break;
                
            case "4":
                //Metodo pare ver estado general
                break;
            case "5":
               mostrarRanking();
                break;
            case "6": 
                //Metodo para ver reporte general
                break;
            case "7":
                this.activo = false;
                this.menu.dibujarLineaBase();
                this.menu.dibujarGeneral("Hasta pronto");
                this.menu.dibujarLineaTope();
                
                System.out.println("");
                break;
            default:
                System.out.println("Opcion invalida");
        
        }
    }
    
    //Cargar el tablero
    public void cargarTablero(){
        if(!this.tableroCreado) {
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral("Introduzca cada casilla con:");
            this.menu.dibujarGeneral("Nombre,tipo,precio,alquiler,precio de casa");
            this.menu.dibujarGeneral("Separado por comas");
            this.menu.dibujarGeneral(("Debe agregar al menos 15 casillas"));
            this.menu.dibujarGeneral("Para finalizar el tablero escriba \"FIN\"");
            this.menu.dibujarLineaTope();
    
            String[] entrada;
            boolean creado = false;
            Casilla casillaNueva = null;
             
            while(!this.tableroCreado) {
                
                entrada = in.nextLine().split(",");
                if (entrada.length > 0) { 
                    if(entrada[0].equalsIgnoreCase("FIN")){
                        tableroCreado = true;
                        this.menu.dibujarLineaBase();
                        this.menu.dibujarGeneral("Tablero creado exitosamente");
                        this.menu.dibujarLineaTope();                
                    } else if(entrada.length == 5){
                        String nombre = entrada[0];
                        String tipo = entrada[1];
                        int precio = Integer.parseInt(entrada[2]);
                        int alquiler = Integer.parseInt(entrada[3]);
                        int precioCasa = Integer.parseInt(entrada[4]);
                        casillaNueva = new Casilla(nombre,tipo,precio,alquiler,precioCasa);
                        this.tablero.agregarAlFinal(casillaNueva);
                    } else {
                        this.menu.dibujarLineaBase();
                        this.menu.dibujarGeneral("Casilla invalida, debe seguir formato:");
                        this.menu.dibujarGeneral("Nombre,tipo,precio,alquiler,precio de casa");
                        this.menu.dibujarLineaTope();
                    }
                }
            }
            
        } else {
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral("El tablero ya ha sido creado");
            this.menu.dibujarLineaTope();
        
        }   
    }
    
    //Cargar los jugadores
    public void registrarJugadores(){
        boolean jugadoresContados = false;
        if(!this.jugadoresAgregados) {
            while(!jugadoresContados) {
                this.menu.dibujarLineaBase();
                this.menu.dibujarGeneral("Introduzca cantidad de jugadores(2-4)");
                this.menu.dibujarLineaTope();
                int cantJugadores = 0;
                if(in.hasNextInt()) {
                    cantJugadores += in.nextInt();
                    in.nextLine();
                    
                    if(cantJugadores < 2 || cantJugadores > 4){
                    System.out.println("La cantidad ingresada es invalida");
                
                    } else{
                        this.jugadores = new Jugador[cantJugadores];
                        int dineroInicial = 1500;
                            if(cantJugadores == 3) {
                                dineroInicial = 1700;
                            } else if (cantJugadores == 4){
                                dineroInicial = 1900;
                            }
                        
                        
                        System.out.println();
                        
                        
                        for (int i = 0; i < cantJugadores; i++) {
                            System.out.println("Introduzca el nombre del Jugador " + (i + 1));
                            String nom = in.nextLine();
                            this.jugadores[i] = new Jugador(nom,dineroInicial, tablero.getSalida());
                            this.menu.dibujarLineaBase();
                            this.menu.dibujarGeneral("Jugador agregado exitosamente");
                            this.menu.dibujarLineaTope();
                        }
                        this.menu.dibujarLineaBase();
                        this.menu.dibujarGeneral("Todos los jugadores han sido agregados");
                        this.menu.dibujarLineaTope();
                        jugadoresContados = true;
                    }
                    
                    
                } else {
                    System.out.println("Error: Se introdujo un valor no numerico");
                    in.nextLine();
                }
            }
            this.jugadoresAgregados = true;
        } else {
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral("Ya se agregaron los jugadores");
            this.menu.dibujarLineaTope();
        }
    }
   
    
    public void iniciarPartida(){
        if(!this.tableroCreado && !this.jugadoresAgregados) {
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral("Debe ingresar el tablero y jugadores para comenzar");
            this.menu.dibujarLineaTope();
        } else if (!this.tableroCreado) {
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral("Debe ingresar el tablero para comenzar");
            this.menu.dibujarLineaTope();
        } else if (!this.jugadoresAgregados) {
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral("Debe ingresar los jugadores para comenzar");
            this.menu.dibujarLineaTope();
        } else {
            juegoActivo = true;
            int contadorDeRondas = 1;
            int rondaMaxima = 15;
            int jugadorEnTurno = 0;
            boolean jugando = true;
                
                
                
            while(jugando && rondaMaxima >= contadorDeRondas){
                    
                    this.menu.dibujarLineaBase();
                    this.menu.dibujarGeneral(" ===== Ronda " + contadorDeRondas + " =====");
                    this.menu.dibujarLineas(1);
                    this.menu.dibujarLineaTope();
                    boolean rondaTerminada = false;
                    
                    
                    
    
                    while(!rondaTerminada) {
                        Jugador actual = jugadores[jugadorEnTurno];
                        rankingABB();
                        if(contarJugadoresActivos() == 1) {
                            this.menu.dibujarLineaBase();
                            this.menu.dibujarGeneral("Solo queda 1 jugador activo");                
                            this.menu.dibujarGeneral("La partida termino");
                            this.menu.dibujarLineaTope();
                            rondaTerminada = true;
                            jugando = false;
                            reporteABB();
                        } else {
                            if (!actual.getEstado()) {
                                this.menu.dibujarGeneral("ESTO NO DEBERIA PASAR");
                                if (jugadorEnTurno == this.jugadores.length - 1) {
                                    rondaTerminada = true;
                                    contadorDeRondas++;
                                    jugadorEnTurno = 0;
                                } else {
                                    jugadorEnTurno++;
                                    
                                }
                            } else if (actual.getTurnosPerdidos() > 0) {
                                this.menu.dibujarLineaBase();
                                this.menu.dibujarGeneral(actual.getNombre() + " pierde este turno.");
                                this.menu.dibujarLineaTope();
                                
                                actual.agregarTurnosPerdidos(actual.getTurnosPerdidos() - 1); 
                                
                                if (jugadorEnTurno == this.jugadores.length - 1) {
                                    rondaTerminada = true;
                                    contadorDeRondas++;
                                    jugadorEnTurno = 0;
                                } else {
                                    jugadorEnTurno++;
                                }
                            } else{
                                
                                
                                if(!actual.getDadoLanzado()) {
                                        this.menu.dibujarLineaBase();
                                        this.menu.dibujarGeneral("Turno de " + actual.getNombre() + " | " + actual.getDinero());
                                    
                                        
                                        this.menu.dibujarGeneral("1. Lanzar dado | 2. Ver propiedades ");
                                        this.menu.dibujarLineas(1);
                                        this.menu.dibujarGeneral("3. Ver ranking");
                                        this.menu.dibujarLineas(1);
                                        this.menu.dibujarGeneral("Seleccione una opcion");
                                        this.menu.dibujarLineaTope();
                                        
                                        String entrada = in.nextLine();
                                        
                                        
                                        switch(entrada) {
                                            //Lanzar dado
                                            case "1":
                                                
                                                lanzarDado(actual);
                                                actual.setDadoLanzado("t");
                                                
                                                break;
                                                
                                            //Ver propiedades
                                            case "2":
                                                this.menu.dibujarLineaBase();
                                                actual.getPropiedades().mostrarPropiedades();
                                                this.menu.dibujarLineaTope();
                                                break;
                                           
                                            case "3":
                                                mostrarRanking();
                                                break;
                                            default:
                                                this.menu.dibujarLineaBase();
                                                this.menu.dibujarGeneral("Opcion invalida");
                                                this.menu.dibujarLineaTope();
                                                break;
                                        }
                                        
                                        
                                } else {
                                        if(actual.getTurnosPerdidos() <= 0 && actual.getEstado() != false) {
                                            this.menu.dibujarLineaBase();
                                            this.menu.dibujarGeneral("Turno de " + actual.getNombre() + " | " + actual.getDinero());
                                    
                                            this.menu.dibujarGeneral("1. Ver propiedades | 2. Comprar propiedad");
                                            this.menu.dibujarGeneral("3. Construir casa | 4. Terminar turno");
                                            this.menu.dibujarLineas(1);
                                            this.menu.dibujarGeneral("Seleccione una opcion");
                                            this.menu.dibujarLineaTope();
                                            
                                            String entrada2 = "";
                                            if(actual.getPosicion().getCasilla().getTipo().equalsIgnoreCase("carcel")){
                                                entrada2 = "4";
                                            }else{
                                                entrada2 = in.nextLine();
                                            }
                                            
                                            switch(entrada2) {
                                                //Ver propiedades
                                                case "1":
                                                    
                                                    this.menu.dibujarLineaBase();
                                                    actual.getPropiedades().mostrarPropiedades();
                                                    this.menu.dibujarLineaTope();
                                                    
                                                    break;
                                                    
                                                //Comprar propiedad
                                                case "2":
                                                    if(!actual.getPosicion().getCasilla().getTipo().equalsIgnoreCase("propiedad")){
                                                        this.menu.dibujarLineaBase();
                                                        this.menu.dibujarGeneral("Esta casilla no se puede comprar");
                                                        this.menu.dibujarLineaTope();
                                                    } else if(this.tablero.buscarCasilla(actual.getPosicion()).getCasilla().getDueno() != null) {
                                                        if(this.tablero.buscarCasilla(actual.getPosicion()).getCasilla().getDueno().getNombre().equalsIgnoreCase(actual.getNombre())){
                                                            this.menu.dibujarLineaBase();
                                                            this.menu.dibujarGeneral(actual.getNombre() + " ya compro esta casilla");
                                                            this.menu.dibujarLineaTope(); 
                                                        } else {
                                                            this.menu.dibujarLineaBase();
                                                            this.menu.dibujarGeneral(this.tablero.buscarCasilla(actual.getPosicion()).getCasilla().getDueno().getNombre() + " ya compro esta casilla");
                                                            this.menu.dibujarLineaTope(); 
                                                            
                                                        }
                                                    
                                                    }else if(actual.getDinero() >= actual.getPosicion().getCasilla().getPrecio()) {
                                                        actual.cobrarDinero(actual.getPosicion().getCasilla().getPrecio());
                                                        actual.agregarPropiedades(actual.getPosicion().getCasilla().getPropiedad());
                                                        this.tablero.buscarCasilla(actual.getPosicion()).getCasilla().setDueno(actual);
                                                        
                                                        this.menu.dibujarLineaBase();
                                                        this.menu.dibujarGeneral(actual.getNombre() + " compro " + actual.getPosicion().getCasilla().getNombre());
                                                        this.menu.dibujarLineaTope();
                                                    } else {
                                                        this.menu.dibujarLineaBase();
                                                        this.menu.dibujarGeneral(actual.getNombre() + " no tiene dinero suficiente");
                                                        this.menu.dibujarGeneral("para comprar la propiedad");
                                                        this.menu.dibujarLineaTope();
                                                    }
                                                    break;
                                                
                                                //Construir casa
                                                case "3":
                                                    if(!actual.getPosicion().getCasilla().getTipo().equalsIgnoreCase("propiedad")){
                                                        this.menu.dibujarLineaBase();
                                                        this.menu.dibujarGeneral("No se puede construir en esta casilla");
                                                        this.menu.dibujarLineaTope();
                                                    } else if (actual.getDinero() < actual.getPosicion().getCasilla().getPrecioCasa()) {
                                                        
                                                        this.menu.dibujarLineaBase();
                                                        this.menu.dibujarGeneral(actual.getNombre() + " no tiene dinero suficiente");
                                                        this.menu.dibujarLineaTope();              
                                                    
                                                    }else if(actual.getPropiedades().buscarPropiedad(actual.getPosicion().getCasilla().getNombre())) {
                                                        if(actual.getPosicion().getCasilla().getPropiedad().getListaDeCasas().getContador()<3){
                                                        actual.cobrarDinero(actual.getPosicion().getCasilla().getPrecioCasa());
                                                        actual.construirCasa(actual.getPosicion());
                                                        this.menu.dibujarLineaBase();
                                                        this.menu.dibujarGeneral(actual.getNombre() + " construyo casa en " + actual.getPosicion().getCasilla().getNombre());
                                                        this.menu.dibujarLineaTope();
                                                        }else{
                                                        this.menu.dibujarLineaBase();
                                                        this.menu.dibujarGeneral("Máximo de casas acanzado");
                                                        this.menu.dibujarLineaTope();
                                                        }
                                                    } else {
                                                        this.menu.dibujarLineaBase();
                                                        this.menu.dibujarGeneral("Debe ser el propietario");
                                                        this.menu.dibujarGeneral("Para construir casas");
                                                        this.menu.dibujarLineaTope();
                                                    }
                                                    
                                                    
                                                    break;
                                                    
                                                //Terminar turno
                                                case "4":
                                                    actual.setDadoLanzado("f");
                                                    if (jugadorEnTurno == this.jugadores.length - 1) {
                                                            rondaTerminada = true;
                                                    }
                                                        
                                                     if (jugadorEnTurno >= this.jugadores.length - 1) {
                                                        jugadorEnTurno = 0;
                                                    } else {
                                                        jugadorEnTurno++;
                                                    }
                                                    this.menu.dibujarLineaBase();
                                                    this.menu.dibujarGeneral(actual.getNombre() + " termino su turno");
                                                    this.menu.dibujarLineaTope();
                                                    
                                                    break;
                                            
                                                default:
                                                    this.menu.dibujarLineaBase();
                                                    this.menu.dibujarGeneral("Opcion invalida");
                                                    this.menu.dibujarLineaTope();
                                                    break;
                                            
                                            
                                            
                                            }
                                    } else {
                                    
                                        if (jugadorEnTurno == this.jugadores.length - 1) {
                                            rondaTerminada = true;
                                        }   
                                        
                                        if (jugadorEnTurno >= this.jugadores.length - 1) {
                                            jugadorEnTurno = 0;
                                        } else {
                                            jugadorEnTurno++;
                                        }
                                        this.menu.dibujarLineaBase();
                                        this.menu.dibujarGeneral(actual.getNombre() + " termino su turno");
                                        this.menu.dibujarLineaTope();
                                        actual.setDadoLanzado("f");
                                        
                                    }
                                }
                            
                                if( actual.getDinero() <= 0) {
                                    actual.cambiarEstado();
                                    this.menu.dibujarLineaBase();
                                    this.menu.dibujarGeneral(actual.getNombre() + " ha quedado en banca rota");
                                    this.menu.dibujarGeneral("Ha perdido el juego");
                                    this.menu.dibujarLineaTope();
                                }
                            }
                        }
                }
                
                
                if(contadorDeRondas > rondaMaxima && jugando == true) {
                    this.menu.dibujarLineaBase();
                    this.menu.dibujarGeneral("Limite de rondas alcanzado");
                    this.menu.dibujarGeneral("La partida termino");
                    jugando = false;
                    this.menu.dibujarLineaTope();
                    
                }
                this.menu.dibujarLineaBase();
                this.menu.dibujarGeneral(" ==== Fin de la ronda  " + contadorDeRondas +  " ====");
                this.menu.dibujarLineaTope();
                mostrarRanking();
                contadorDeRondas++;
                jugadorEnTurno = 0;
            }
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral(" ==== Fin del juego  " + contadorDeRondas +  " ====");
            this.menu.dibujarLineaTope();
            reporteABB();
            
        
        }
    }
    
    public void lanzarDado(Jugador j){
        
        if (j.getTurnosPerdidos() == 0) {
            
            int dado = (int) ((Math.random() * 6)+1);
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral(j.getNombre() + " lanzo el dado:  --> " + dado);
            NodoCasilla posicionActual = j.getPosicion();
            NodoCasilla destino = this.tablero.avanzar(posicionActual, dado);
            
            
            j.setPosicionNueva(destino);
            this.menu.dibujarGeneral("Avanza a ---> " + j.getPosicion().getCasilla().getNombre());
            this.tablero.buscarCasilla(j.getPosicion()).getCasilla().mostrarInfo();
            
            for(int avance = 0; avance < dado; avance++) {
                posicionActual = posicionActual.getSiguiente();
                if(posicionActual.getCasilla().getNombre().equalsIgnoreCase("salida")){
                    j.agregarDinero(200);
                    this.menu.dibujarGeneral("El jugador paso por la salida");
                    this.menu.dibujarGeneral("Recibe $200");
                
                }
            }
            
            analizarDestino(destino, j);
            
            
            this.menu.dibujarLineaTope();
            
        }else {
            this.menu.dibujarLineaBase();
            this.menu.dibujarGeneral(j.getNombre() + " tiene que esperar " + (j.getTurnosPerdidos()) + " turnos para jugar");
            this.menu.dibujarLineaTope();
            j.agregarTurnosPerdidos(-1);
            
        }
    }
    
    public void analizarDestino(NodoCasilla destino, Jugador j) {
        if(destino.getCasilla().getTipo().equalsIgnoreCase("impuesto")){
                j.cobrarDinero(100);
                this.menu.dibujarGeneral(j.getNombre() + " pierde $100");
                
            }else if (destino.getCasilla().getTipo().equalsIgnoreCase("carcel")){
                j.agregarTurnosPerdidos(1);
                this.menu.dibujarGeneral(j.getNombre() + " pierde 1 turno");
                
            } else if(destino.getCasilla().getTipo().equalsIgnoreCase("premio")){
                j.agregarDinero(50);
                this.menu.dibujarGeneral(j.getNombre() + " recibe $50");
                
            } else if (destino.getCasilla().getTipo().equalsIgnoreCase("carta")) {
                Carta cartaTomada = this.mazoDeCartas.tomarCarta();
                
                if(cartaTomada.getAccion().equalsIgnoreCase("impuesto")){
                    j.cobrarDinero(cartaTomada.getValor());
                    this.menu.dibujarGeneral(j.getNombre() + " pierde $" + cartaTomada.getValor());
                } else if(cartaTomada.getAccion().equalsIgnoreCase("premio")){
                    j.agregarDinero(cartaTomada.getValor());
                    this.menu.dibujarGeneral(j.getNombre() + " gana $" + cartaTomada.getValor());
                } else if(cartaTomada.getAccion().equalsIgnoreCase("avanzar")){
                    NodoCasilla posActual = j.getPosicion();
                    j.setPosicionNueva(this.tablero.avanzar(j.getPosicion(), cartaTomada.getValor()));
                    this.menu.dibujarGeneral(j.getNombre() + " avanza " + cartaTomada.getValor() + " casillas");
                    this.menu.dibujarGeneral(posActual.getCasilla().getNombre() + " ---> " + j.getPosicion().getCasilla().getNombre());
                    analizarDestino(j.getPosicion(), j);
                    if(j.getPosicion().getCasilla().getTipo().equalsIgnoreCase("propiedad")){
                        this.menu.dibujarLineas(1);
                        j.getPosicion().getCasilla().mostrarInfo();
                    }
                    
                }
                
                else if(cartaTomada.getAccion().equalsIgnoreCase("retroceder")){
                    NodoCasilla posActual = j.getPosicion();
                    j.setPosicionNueva(this.tablero.retroceder(j.getPosicion(), cartaTomada.getValor()));
                    this.menu.dibujarGeneral(j.getNombre() + " retrocede " + cartaTomada.getValor() + " casillas");
                    this.menu.dibujarGeneral(j.getPosicion().getCasilla().getNombre() + " <--- " + posActual.getCasilla().getNombre());
                    analizarDestino(j.getPosicion(), j);
                } else if(cartaTomada.getAccion().equalsIgnoreCase("pierdeTurno")){
                    j.agregarTurnosPerdidos(1);
                    this.menu.dibujarGeneral(j.getNombre() + " pierde " + cartaTomada.getValor() + " turnos");
                
                }
        }
        if(destino.getCasilla().getDueno() != null && !destino.getCasilla().getDueno().getNombre().equals(j.getNombre()) && destino.getCasilla().getDueno().getEstado() != false){
                    int alquiler = 0;
                    alquiler += destino.getCasilla().getAlquilerBase()+destino.getCasilla().getPropiedad().getListaDeCasas().calcAumentoAlquiler();
                    
                    if(destino.getCasilla().getPropiedad() != null && destino.getCasilla().getPropiedad().getListaDeCasas().contarCasas() > 0) {
                       destino.getCasilla().getPropiedad().getListaDeCasas().calcAumentoAlquiler(); 
                    }
                    j.cobrarDinero(alquiler);
                    destino.getCasilla().getDueno().agregarDinero(alquiler);
                    
                    this.menu.dibujarGeneral(j.getNombre() + " paga $" + alquiler + " de alquiler a " +  destino.getCasilla().getDueno().getNombre());
                    
                }
    }
    
    public void rankingABB(){
        Jugador[] jugadoresOrdenados = ordenarSeleccion();
        RankingABB arbol = new RankingABB();
        for(int i = 0; i<jugadores.length; i++){
            arbol.agregarAlArbol(jugadoresOrdenados[i]);
        }
        
    }
    
    public void mostrarRanking(){
        Jugador[] jugadoresOrdenados = ordenarSeleccion();
        RankingABB arbol = new RankingABB();
        for(int i = 0; i<jugadores.length; i++){
            arbol.agregarAlArbol(jugadoresOrdenados[i]);
        }
        arbol.ranking();
    }
    
    public void reporteABB(){
        Jugador[] jugadoresOrdenados = ordenarSeleccion();
        RankingABB arbol = new RankingABB();
        for(int i =0; i<jugadores.length; i++){
            arbol.agregarAlArbol(jugadoresOrdenados[i]);
        }
        arbol.reporte();
    }
    public Jugador[] ordenarSeleccion(){
        Jugador[] jugadoresOrdenados = this.jugadores;
        for(int i = 0; i<jugadores.length; i++){
            
            int posMenor = i;
            for(int j=i+1; j<jugadores.length;j++){
                if(jugadoresOrdenados[j].calcPatrimonio()<jugadoresOrdenados[posMenor].calcPatrimonio()){
                    posMenor = j;
                }
            }
            Jugador temp = jugadoresOrdenados[i];
            jugadoresOrdenados[i] = jugadoresOrdenados[posMenor];
            jugadoresOrdenados[posMenor] = temp;
        }
        return jugadoresOrdenados;
    }
    
    public int contarJugadoresActivos() {
        int jugadoresActivos = 0;
        
        
        for (int i = 0; i < this.jugadores.length; i++) {
            if(this.jugadores[i].getEstado() == true) {
                jugadoresActivos++;
            }
        } 
        
        return jugadoresActivos;
    
    }
    
    
    
}