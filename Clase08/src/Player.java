import java.util.Scanner;

public class Player extends Flipamon{
	Player(String nombre, int vida){
		super(nombre, vida);
	}
	
	public void atacar(Flipamon enemigo) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ataque Fuerte: 1 | Ataque Normal: 2");
		int ataque = scanner.nextInt();
		int puntos = 0;
		if(ataque == 1) {
			System.out.println("Usaste Ataque Fuerte! 💥💥💥");
			puntos = super.ataqueFuerte();
		} else if (ataque == 2) {
			System.out.println("Usaste Ataque Normal! 💢💢");
			puntos = super.ataqueNormal();
		}
		System.out.println("Atacaste con: " + puntos + " puntos.");
		enemigo.calcularVida(puntos);
		System.out.println("Vida de enemigo: " + enemigo.getVida() + " puntos.");
	}
}
