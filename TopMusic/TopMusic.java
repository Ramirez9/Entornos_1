package TopMusic;

import java.util.ArrayList;

public class TopMusic {

	 private ArrayList<Cancion> lista = new ArrayList<Cancion>();


	/**
	 * a�ade una cancion
	 * @param posicion
	 * @param cancion
	 * @return
	 */
	String anadirCancion(int posicion, Cancion cancion) {

		if (cancion == null || fueraDeRango(posicion)) {
			return "Error al introducir canci�n";
		}
		lista.add(posicion, cancion);
		return "\nCanci�n introducida.";
	}

	/**
	 * Borra la cancion
	 * @param posicion
	 * @return
	 */
	Cancion borrarCancion(int posicion){

		if (lista.isEmpty()){
			return null;
		}
		return lista.remove(posicion - 1);

	}
	/**
	 * Sube el puesto de la cancion
	 * @param posicion
	 * @return
	 */
	String subirPuesto(int posicion) {

		if (lista.isEmpty()||fueraDeRango(posicion)||esPrimero(posicion)) {
			return "Error al subir la canci�n";
		}
		lista.add(posicion - 2, lista.remove(posicion - 1));
		return "Se ha subido un puesto";
	}

	/**
	 * Baja el puesto de la canci�n
	 * @param posicion
	 * @return
	 */
	String bajarPuesto(int posicion) {

		if (lista.isEmpty()||fueraDeRango(posicion)||esUltimo(posicion)) {
			return "Error al bajar la canci�n";
		}
		Cancion aux = lista.get(posicion);
		lista.set(posicion, lista.get(posicion - 1));
		lista.set(posicion - 1, aux);
		return "Se ha bajado un puesto";
	}
	
	/**
	 * Muestra la lista
	 * @return
	 */
	String mostrarLista() {

		if (lista.isEmpty()) {
			return "La lista est� vacia, introduzca elementos.";
		}
		StringBuilder cadena = new StringBuilder();

		for (Cancion cancion : lista) {
			cadena.append(cancion);
		}
		return cadena.toString();
	}

	/**
	 * Controla la canci�n m�s escuchada
	 * @param cancion
	 * @return
	 */
	Cancion masEscuchada() {
		if (lista.isEmpty()) {
			return null;
		}
		return lista.get(0);

	}

	boolean isEmpty() {

		return lista.isEmpty();
	}

	int size() {
		return lista.size();
	}
	
	/**
	 * Controla si es el ultimo elemento
	 * @param posicion
	 * @return
	 */
	private boolean esUltimo(int posicion) {
		if(posicion == size())
			return true;
		return false;
	}
	/**
	 * Controla si est� el primero
	 * @param posicion
	 * @return
	 */
	private boolean esPrimero(int posicion){
		if(posicion == 1)
			return true;
		return false;
			
	}
	
	Cancion get(int posicion){
		return lista.get(posicion);
	}
	/**
	 * Fuera de rango
	 * @param posicion
	 * @return
	 */
	private boolean fueraDeRango(int posicion) {
		return posicion < 0 || posicion > size();
	}
	
}
