
public class Main {
	public static void main(String[] args) {
		Player player = new Player("Juan 🐴", 1);	
		Enemigo enemigo = new Enemigo("Benjamin", 20);
		
		new GameManager(player, enemigo);
	}
}
