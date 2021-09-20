package clase10;

import java.util.Scanner;

public class CatalogoMusical extends Thread{
    private static Scanner scanner = new Scanner(System.in);
    private boolean loopMenu = true;
    private int opcion;
    private Artistas[] artistas = new Artistas[3];
    private int index = 0;

    CatalogoMusical(){
    	datosAutomaticos();
		empezar();
	};
	
	private void empezar() {
		// Menú
		do {
			System.out.println("Bienvenido ¿Qué acción deseas realizar?");
			System.out.println("Agregar Artista: 1.");
			System.out.println("Listar Artistas: 2.");
            System.out.println("Agregar Canción: 3.");
            System.out.println("Listar canciones de artista: 4.");
            System.out.println("Salir: 99");
			opcion = scanner.nextInt();
			scanner.nextLine();
			switch(opcion) {
				case 1: 
					agregarArtistas();
					break;
				case 2:
					listarArtistas();
					break;
				case 3: 
					agregarCancion();
					break;
                case 4: 
                	listarCancionesDeArtista();
					break;    
                case 99: 
					loopMenu = false;
					break;
				default:
					System.out.println("Opción no definida");
					break;
			}
		} while(loopMenu);
        // Salida del programa
		System.out.println("¡Gracias por usar el catálogo de artistas!");
	}
	private void listarArtistas() {
		if(artistas[0] != null)
		{
			System.out.println("__________________________");
	    	System.out.println("**** Artistas Disponibles ****");
			for(int i = 0; i < artistas.length; i++) {
				if(artistas[i] != null)
					System.out.println("[" + i + "] - " + artistas[i].getNombreArtista());
				else
					break;
			}
	    	System.out.println("**** Fin de la lista ****");
			System.out.println("__________________________");
		}
		else
			System.out.println("No hay artistas 😫");
	}
	private void listarCancionesDeArtista() {
		System.out.println("Ingrese el índice de artista a buscar:");
		int indice = scanner.nextInt();
		scanner.nextLine();
		artistas[indice].listarCanciones();
	}
	private void agregarCancion(){
		System.out.println("Ingrese el índice de artista a buscar:");
		int indice = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese nombre de canción para " + artistas[indice].getNombreArtista());
		String nombre = scanner.nextLine();
		System.out.println("Ingrese el tipo de canción que es " + nombre);
		String tipo = scanner.nextLine();
		System.out.print("Agregando canción.");
		for(int i = 0; i < 8; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				System.out.println("¡Ocurrió un error!");
			}
			System.out.print(".");
		}
			try {
				System.out.print("\n");
				artistas[indice].agregarCancion(new Canciones(nombre, tipo));
			}
			catch(Exception e) {
				// Qué indice quiso acceder?
				// Guardar ese indica
				// Tomar accion sobre ese indice
				// Ej. Buscar el primer indice disponible
				// Realizar un for, buscando el primer elemento nulo del arreglo
				// Guardar nueva cancion en ese indice
				System.out.println("Ocurrió un error al agregar canción: " + e);
			}
	}
	private void agregarArtistas() {
		if(index < artistas.length)
        {
			String nombre;
			System.out.println("Ingrese nombre de artista");
			nombre = scanner.nextLine();
			this.artistas[index] = new Artistas(nombre);
            aumentarIndex();
        }
    	else
            System.out.println("Límite de canciones alcanzado");
	}
	private void datosAutomaticos() {
		this.artistas[index] = new Artistas("Seal");
		Canciones[] canciones = {
				new Canciones("Fly Like an Eagle", "Funk"),
				new Canciones("Stand by Me", "Pop"),
				new Canciones("Kiss From a Rose", "R&B"),
				new Canciones("Crazy", "Soul")
		};
		this.artistas[index].agregarCancion(canciones);
        aumentarIndex();
        this.artistas[index] = new Artistas("Michael Jackson");
        aumentarIndex();
	}
	private void aumentarIndex(){
        index++;
    }
}