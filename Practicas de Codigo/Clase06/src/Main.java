import java.util.Scanner;

/*
 * Pokemon Battle Simulator
 * v1.2
 * author: Clase POO 031
 */

public class Main {
	
	static Flipamon enemigo = new Flipamon("Charizard", 10);
	static Flipamon aliado = new Flipamon("Magikarp", 20);

	public static void main(String[] args) {
		// Nuestro método de hacer inputs
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
					atacar();
					break;
				case 2: 
					batalla = false;
					break;
				default:
					System.out.println("Acción no definida");
					break;
			}
			
			if(aliado.getVida() <=0 || enemigo.getVida()<=0) {
				if(aliado.getVida()>0) {
					System.out.println("Exceso de odio " + aliado.getNombre());
				} else {
					System.out.println("Te falta odio " + aliado.getNombre());
				}
				batalla = false;
			}
			
			seguir();
		} while(batalla);
		System.out.println("Gracias por jugar Flipamon!");
		// TODO: Evaluar si perdemos o ganamos
	}
	
	public static void seguir() {
		System.out.println("Presione ENTER para continuar...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void atacar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ataque Fuerte: 1 | Ataque Normal: 2");
		int ataque = scanner.nextInt();
		int puntos = 0;
		if(ataque == 1) {
			System.out.println("Usaste Ataque Fuerte! 💥💥💥");
			puntos = aliado.ataqueFuerte();
		} else if (ataque == 2) {
			System.out.println("Usaste Ataque Normal! 💢💢");
			puntos = aliado.ataqueSimple();
		}
		System.out.println("Atacaste con: " + puntos + " puntos.");
		enemigo.calcularVida(puntos);
		System.out.println("Vida de enemigo: " + enemigo.getVida() + " puntos.");
		
		if(enemigo.getVida()>0)
		ataqueEnemigo();
	}
	
	public static void ataqueEnemigo() {
		int ataque = (int) Math.floor(Math.random()*2+1);
		int puntos = 0;
		if(ataque == 1) {
			System.out.println(enemigo.getNombre() +  " 😈 usó Ataque Fuerte! 💥💥💥");
			puntos = enemigo.ataqueFuerte();
		} else if (ataque == 2) {
			System.out.println(enemigo.getNombre() + " 😈 usó Ataque Normal! 💢💢");
			puntos = aliado.ataqueSimple();
		}
		System.out.println(enemigo.getNombre() + " 😈 atacó con: " + puntos + " puntos.");
		aliado.calcularVida(puntos);
		System.out.println("Tu vida es: " + aliado.getVida() + " puntos.");
	}

}
