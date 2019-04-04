package examen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import modelo.Equipo;
import modelo.Jugador;

// 2 de abril de 2019
public class Ejercicios {
	
	// implementar y llamar desde AQUI los ejercicios
    // ¡IMPORTANTE!: NO DEJAR AQUI CÓDIGO IRRELEVANTE, LEER ENUNCIADO.
	
	public static void main(String[] args) {
		
		Ejercicios ejercicio = new Ejercicios();
		String rutaJugadores = "ficheros/jugadores.txt";
		String rutaEquipos = "ficheros/equipos.txt";
		String idEquipo = "1";
		
		//ejercicio 1
		ArrayList<Jugador> listaJugadores = ejercicio.ejercicio1(rutaJugadores, idEquipo);
		//ejercicio 2
		HashMap<String, ArrayList<Jugador>> mapaJugadoresPorEqupos = ejercicio.ejercicio2(rutaJugadores);
		//ejercicio 3_1
		ArrayList<Equipo> listaEquiposOrdenada = ejercicio.ejercicio3_1(rutaEquipos);
		//ejercicio 3_2
		ejercicio.ejercicio3_2(listaEquiposOrdenada);
		
		System.out.println("FIN DEL PROGRAMA");
		
	}
	
	public ArrayList<Jugador> ejercicio1 (String rutaJugadores , String equipo) {
		
		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
		
		try {
			BufferedReader ficheroJugadores = new BufferedReader(new FileReader(rutaJugadores));
			String jugador;
			
			while ((jugador = ficheroJugadores.readLine()) != null) {
				
				String[] datosJugador = jugador.split("#");
				
				if (datosJugador[7].compareTo(equipo) == 0) 
					listaJugadores.add(introducirJugador(datosJugador));	

			}
			
			ficheroJugadores.close();
			System.out.println("Fin de la lectura del fichero");

		} catch (FileNotFoundException excepcion) {
			System.out.println("fichero no encontrado");
			return null;

		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		
		return listaJugadores;
	}

	public HashMap<String, ArrayList<Jugador>> ejercicio2 (String rutaJugadores) {
		
		int numEquipos = 20;
		HashMap<String, ArrayList<Jugador>> mapaJugadoresPorEqupos = new HashMap<String, ArrayList<Jugador>>();
		
		for (int i = 0; i < numEquipos; i++) {
			mapaJugadoresPorEqupos.put(Integer.toString(i + 1), ejercicio1(rutaJugadores, Integer.toString(i + 1)));
		}
		
		return mapaJugadoresPorEqupos;
	}

	public ArrayList<Equipo> ejercicio3_1 (String rutaEquipos) {
		
		ArrayList<Equipo> listaEquipos = crearListaEquipos(rutaEquipos);
		listaEquipos.sort(null);
		 
		return listaEquipos;
	}
	
	public void ejercicio3_2 (ArrayList<Equipo> listaEquipos) {
		for (Equipo equipo : listaEquipos) {
			
			System.out.println("id: " + equipo.getId() + 
							   " nombre corto: " + equipo.getNombreCorto() + 
							   " nombre: " + equipo.getNombre());
		}
	}

	public Jugador introducirJugador (String[] datosJugador) {
		
		Jugador jugador = new Jugador();
		
		jugador.setId(Integer.parseInt(datosJugador[0]));
		jugador.setNif(datosJugador[1]);
		jugador.setNombre(datosJugador[2]);
		jugador.setLongitudPaso(Integer.parseInt(datosJugador[3]));
		jugador.setFecha_nac(datosJugador[4]);
		jugador.setSexo(datosJugador[5].charAt(0));
		jugador.setDorsal(Integer.parseInt(datosJugador[6]));
		jugador.setIdEquipo(Integer.parseInt(datosJugador[7]));

		return jugador;
	}
	
	public Equipo introducirEquipo (String[] datosEquipo) {
		
		Equipo equipo = new Equipo();
		
		equipo.setId(Integer.parseInt(datosEquipo[0]));
		equipo.setNombreCorto(datosEquipo[1]);
		equipo.setNombre(datosEquipo[2]);

		return equipo;
	}
	
public ArrayList<Equipo> crearListaEquipos (String rutaEquipos) {
		
		ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
		
		try {
			BufferedReader ficheroEquipos = new BufferedReader(new FileReader(rutaEquipos));
			String equipo;
			
			while ((equipo = ficheroEquipos.readLine()) != null) {
				
				String[] datosEquipo = equipo.split("#");
				listaEquipos.add(introducirEquipo(datosEquipo));

			}
			
			ficheroEquipos.close();
			System.out.println("Fin de la lectura del fichero");

		} catch (FileNotFoundException excepcion) {
			System.out.println("fichero no encontrado");
			return null;

		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		
		return listaEquipos;
	}
}
