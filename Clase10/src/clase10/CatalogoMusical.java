package clase10;

import java.util.Scanner;

public class CatalogoMusical {
    private static Scanner scanner = new Scanner(System.in);
    private boolean loopMenu = true;
    private int opcion;
    // TODO: Definir variable para artistas

    CatalogoMusical(){
		empezar();
	};
	
	private void empezar() {
		// Menú
		do {
			System.out.println("Bienvenido ¿Qué acción deseas realizar?");
			System.out.println("Agregar Artista: 1.");
            System.out.println("Agregar Canción: 2.");
            System.out.println("Listar canciones de artista: 3.");
            System.out.println("Salir: 4");
			opcion = scanner.nextInt();
			
			switch(opcion) {
				case 1: 
					// TODO: Agregar Artista
					break;
				case 2: 
					// TODO: Agregar Canción a un Artista
					break;
                case 3: 
					// TODO: Listar las canciones de un artista
					break;    
                case 4: 
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
}