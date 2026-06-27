------------------------------------------------------------------------
CIUDAD MILLONARIA
------------------------------------------------------------------------

Proposito: Este programa corresponde a la evaluacion Tarea Programada 2 del curso Programacion 1 UCR 2026

Posible tablero para usar:

Salida,salida,0,0,0
AECCI,propiedad,300,80,100
Impuesto Municipal,impuesto,0,100,0
Barrio Jardin,propiedad,250,60,100
Cartas de la Ciudad,carta,0,0,0
Parque Morazan,propiedad,220,55,90
Carcel,carcel,0,0,0
Bono Ciudadano,premio,0,150,0
Mall San Pedro,propiedad,280,70,120
Calle de la amargura,propiedad,350,90,150
Vendedor ambulante,impuesto,0,100,0
Cartas de la Ciudad,carta,0,0,0
Generales,propiedad,170,50,70
Prispan,propiedad,200,50,90
Kiosko Universitario,premio,0,150,0
FIN


Autores: Mathew Picado C5I347 & Marco Zuniga C5I240

Especificaciones:
* Solo se puede iniciar una partida si ya se creo el tablero y se registraron sus jugadores, es recomendado agregar de 15 a 20 casillas para un juego de 15 rondas
* El limite de rondas se establecio en 15 para una partida rapida
* El maximo de casas por propiedad es 3 
* Se elimina un jugador si su dinero es <= 0 y la partida termina si se llegan al maximo de rondas o si solo queda un jugador activo
* El dinero inicial varia segun la cantidad de jugadores: 2 = 1200, 3 = 1700, 4 = 1900
* Se establecio un rectangulo para la informacion del juego y sus eventos de alto = 20 y ancho = 50;
* Se creo una clase Menu adicional para imprimir facilmente la informacion en ese diseño
* Se rediseño el menu para no dejar comprar casas, propiedades ni terminar el turno de un jugador hasta que lance el dado
* La clase juego se encarga de la logica del programa, el main solo inicializa el juego
* Las cartas de la ciudad establecidas son: ganar dinero, perder dinero, avanzar, retroceder, perder turno
* Al agarrar una carta esta se mueve al final del mazo de cartas y el puntero se actualiza a la siguiente 
* Al final de cada ronda se da la opcion de ver el ranking de los jugadores hasta el momento
* Al final del juego se muestra el ranking y al ganador

Instrucciones: 
* El tablero de juego se crea con el siguiente formato para cada casilla: nombre,tipo,precio,alquiler,precioCasa
* Se indica la cantidad de jugadores y sus nombres para registrarlos
* Al lanzar el dado, el jugador avanzara de 1-6 casillas, podra comprar las propiedades si su dinero alcanza
* El jugador puede construir casas en sus propiedades
* Si un jugador cae en la propiedad del otro se le cobrara alquiler
* Las cartas de la ciudad aplican su efecto al jugador que caiga en dicha casilla






6/26/2026