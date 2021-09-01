import java.util.Scanner;

public class GameManager {
	
	GameManager(Player player, Enemigo enemigo){
		empezarJuego(player, enemigo);
	};
	
	private void empezarJuego(Player player, Enemigo enemigo) {
		// Nuestro método de hacer inputs
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		// Booleano para definir si la batalla sigue en curso
		boolean batalla = true;
		// Menu de batalla
		do {
			System.out.println("Qué acción deseas realizar");
			System.out.println("Atacar: 1. Huir: 2");
			int action = scanner.nextInt();
			
			switch(action) {
				case 1: 
					player.atacar(enemigo);
					enemigo.atacar(player);
					break;
				case 2: 
					batalla = false;
					break;
				default:
					System.out.println("Acción no definida");
					break;
			}
			
			if(player.getVida() <=0 || enemigo.getVida()<=0) {
				if(player.getVida()>0) {
					System.out.println("Exceso de odio " + player.getNombre());
				} else {
					System.out.println("Te falta odio " + player.getNombre());
				}
				batalla = false;
			}
			seguir();
		} while(batalla);
		System.out.println("Gracias por jugar Flipamon!");
	}
	
	private static void seguir() {
		System.out.println("Presione ENTER para continuar...");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
}
