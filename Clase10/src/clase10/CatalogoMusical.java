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
		// Men�
		do {
			System.out.println("Bienvenido �Qu� acci�n deseas realizar?");
			System.out.println("Agregar Artista: 1.");
            System.out.println("Agregar Canci�n: 2.");
            System.out.println("Listar canciones de artista: 3.");
            System.out.println("Salir: 4");
			opcion = scanner.nextInt();
			
			switch(opcion) {
				case 1: 
					// TODO: Agregar Artista
					break;
				case 2: 
					// TODO: Agregar Canci�n a un Artista
					break;
                case 3: 
					// TODO: Listar las canciones de un artista
					break;    
                case 4: 
					loopMenu = false;
					break;
				default:
					System.out.println("Opci�n no definida");
					break;
			}
		} while(loopMenu);
        // Salida del programa
		System.out.println("�Gracias por usar el cat�logo de artistas!");
	}
}