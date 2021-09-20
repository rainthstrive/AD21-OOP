
public class Enemigo extends Flipamon {

	Enemigo(String nombre, int vida) {
		super(nombre, vida);
	}
	
	public void atacar(Flipamon player) {
		if(super.getVida()>0) {
			ataqueEnemigo(player);
		}
	}
	
	private void ataqueEnemigo(Flipamon player) {
		int ataque = (int) Math.floor(Math.random()*2+1);
		int puntos = 0;
		if(ataque == 1) {
			System.out.println(super.getNombre() +  " 😈 usó Ataque Fuerte! 💥💥💥");
			puntos = super.ataqueFuerte();
		} else if (ataque == 2) {
			System.out.println(super.getNombre() + " 😈 usó Ataque Normal! 💢💢");
			puntos = super.ataqueNormal();
		}
		System.out.println(super.getNombre() + " 😈 atacó con: " + puntos + " puntos.");
		player.calcularVida(puntos);
		System.out.println("Tu vida es: " + player.getVida() + " puntos.");
	}

}
