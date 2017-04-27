package TopMusic;

import utiles.Menu;
import utiles.Teclado;

/**
 * <p>
 * TopMusic. Implementa un programa que gestione una lista de las canciones más
 * escuchadas. El usuario podrá:
 * <li>a. Añadir una canción (en una posición) al TopMusic.
 * <li>b. Sacar un elemento del TopMusic.
 * <li>c. Subir un puesto en el TopMusic.
 * <li>d. Bajar un puesto en el TopMusic.
 * <li>e. Mostrar la lista TopMusic.
 * <li>f. Mostrar la canción más escuchada.
 * <p>
 * Sobre la canción se almacenará el título, artista o grupo y año de grabación.
 * 
 * @author Francisco Ramirez Ruiz
 *
 */
public class TestTopMusic {
	
	private static TopMusic lista = new TopMusic();
	
	public static void main(String[] args) {
		
		String[] opciones = { "Enseñar lista", "Borrar canción", "Subir canción", "Bajar canción",
				"Canción más escuchada", "Añadir canción a la lista", "SALIR" };
		Menu menu = new Menu("\n-------------TOP MUSIC-----------", opciones);
			
		//Lista de las canciones
        //cancionesLista();

		int opcion;
		do {
			opcion = menu.gestionar();
			switch (opcion) {
			case 1:
				mostrar(); //Enseña la lista al usuario
				break;
			case 2:
				eliminar(); //Elimina una cancion
				break;
			case 3:
				sube();  //Sube una cancion
				break;
			case 4:
				baja();	//Baja una cancion			
				break;
			case 5:
				escuchada(); //Muestra la mas escuchada		 		
				break;
			case 6:
				anadir(); //Añade una canción
				break;
			default:
				System.out.println("Hasta luego!");
			}
		} while (opcion != 7);

	}

//	private static void cancionesLista() {
//		lista.anadirCancion(0, Cancion.getInstance("La Casa No Es Igual", "Melendi", 2017));
//		lista.anadirCancion(1, Cancion.getInstance("Yo Más Te Adoro", "Morat", 2016));
//		lista.anadirCancion(2, Cancion.getInstance("Coincidir", "Macaco", 2015));
//		lista.anadirCancion(3, Cancion.getInstance("Pan y Mantequilla", "Efecto Pasillo", 2012));
//		lista.anadirCancion(4, Cancion.getInstance("Traidora", "Gente de Zona", 2016));
//		lista.anadirCancion(5, Cancion.getInstance("Me Voy Enamorando", "Chino & Nacho", 2015));
//		lista.anadirCancion(6, Cancion.getInstance("Por Fin Te Encontré", "Cali Y El Dandee", 2015));
//		lista.anadirCancion(7, Cancion.getInstance("Vacaciones", "Wisin", 2016));
//		lista.anadirCancion(8, Cancion.getInstance("Chantaje", "Shakira", 2016));
//		lista.anadirCancion(9, Cancion.getInstance("Despacito", "Luis Fonsi ", 2017));
//	}

	private static void mostrar() {
		System.out.println(lista.mostrarLista());
	}

	private static void eliminar() {
		if(lista.isEmpty()) {
			System.out.println("La lista está vacía, introduzca antes una canción");
		}else System.out.println(lista.borrarCancion(mostrarCancion()));
	}

	private static void sube() {
		if(lista.isEmpty()) {
			System.out.println("La lista está vacía, introduzca antes una canción");
		}else System.out.println(lista.subirPuesto(mostrarCancion()));
	}

	private static void baja() {
		if(lista.isEmpty()) {
			System.out.println("La lista está vacía, introduzca antes una canción");
		}else System.out.println(lista.bajarPuesto(mostrarCancion()));
	}

	private static void escuchada() {
		
		if(lista.isEmpty()) {
			System.out.println("La lista está vacía, introduzca antes una canción");
		}else System.out.println(lista.masEscuchada());
	}

	private static void anadir() {
		
		int posicion = Teclado.leerEntero("Introduce una posicion entre 1 y "+(lista.size()+1) + ": ");
		
		if(posicion == 1 || posicion == lista.size()+1)
		System.out.println(lista.anadirCancion(posicion-1, crearCancion()));	
	}
	
	private static Cancion crearCancion(){
		
		String titulo = Teclado.leerCadena("Introduce un titulo: ");
		String artista = Teclado.leerCadena("Introduce el artista: ");
		int anio = Teclado.leerEntero("Introduce el año: ");
		
		Cancion cancion = Cancion.getInstance(titulo, artista, anio);
		
		return cancion;						
	}
	
	private static int mostrarCancion() {

		if (lista.isEmpty()) {
			return -1; //Devuelve -1, por que es una posición que no puede estar.
		}
		String[] opciones = new String[lista.size()];
		
		for (int i=0;i<lista.size();i++  ) {
			opciones[i] = lista.get(i).toString();
		}
		Menu menu = new Menu("----------TOP MUSIC---------", opciones);

		return menu.gestionar();
	}
}
