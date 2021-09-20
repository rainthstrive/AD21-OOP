
public class Main {

	public static void main(String[] args) {
		String[][] names = {
				{"Lic. ", "Ing. ", "Dr. ", "Nini"},
				{"Aguilar", "Espinoza", "Paz"}
		};
		System.out.println("Arreglo de arreglos: " + names.length + " elementos");
		System.out.println("Arreglo en indice [0] " + names[0].length + " elementos");
		System.out.println("Arreglo en indice [1] " + names[1].length + " elementos");
		
		for(int i=0; i< names[0].length; i++) {
			System.out.println(names[0][i]);
		}
		for(int i=0; i< names[1].length; i++) {
			System.out.println(names[1][i]);
		}

	}

}
