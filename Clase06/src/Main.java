/*
 * Pokemon Battle Simulator
 * v1.0
 * author: Clase POO 031
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Crear Pokemon
		Pokemon enemigo = new Pokemon("Charizard", 100);
		Pokemon aliado = new Pokemon("Magikarp", 100);
		Scanner scan = new Scanner(System.in);
		int action = 0;
		
		// TODO: Menu
		do {
			System.out.println("Qué acción deseas realizar");
			System.out.println("Atacar: 1. Huir: 2");
			action = scan.nextInt();
			if(action==1) {
				// TODO: Acceder a nuestros ataques
			} else if (action==2) {
				// TODO: Salir del ciclo
			}
			
		} while(enemigo.getVida()!=0 || aliado.getVida()!=0);
		
		// TODO: Evaluar si perdemos o ganamos
	}

}
