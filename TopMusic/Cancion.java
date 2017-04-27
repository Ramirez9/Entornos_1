package TopMusic;

import java.util.Calendar;

public class Cancion {
	
	private static Calendar fecha = Calendar.getInstance();
	private static int anioActual = fecha.get(Calendar.YEAR);

	private String titulo;
	private String artista;
	private String anio;

	private Cancion(String titulo, String artista, String anio) {
		this.titulo = titulo;
		this.artista = artista;
		this.anio = anio;
	}
	
	static Cancion getInstance(String titulo, String artista, int anioNuevo) {
		String anio = Integer.toString(anioNuevo);
		if (!(titulo.matches("(\\w+[\\s\\.]?)+\\w*$") && artista.matches("(\\w+[\\s\\.]?)+\\w*$") && anio.matches("19\\d{2}|2\\d{3}")
				&& anioNuevo <= anioActual))
			return null;

		return new Cancion(titulo, artista, anio);
	}
	@Override
	public String toString() {
		return "\n"+titulo+" De "+artista+" Lanzado en el año "+anio;
	}
	
}
