package clase11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
	// Crea un arreglo que contiene 10 elementos Integer con valores secuenciales
	// del 0 al 9.
	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(i);
		}
		writeList();
	}

	// La clase también define un método llamado WriteList,
	// que escribe la lista de números a un archivo de texto llamado OutFile.txt.
	public void writeList() {
		PrintWriter out = null;

		try {
			// Capturamos un IOException
			out = new PrintWriter(new FileWriter("OutFile.txt"));
			for (int i = 0; i < SIZE; i++) {
				// Capturamos un IndexOutOfBoundsException
				out.println("Value at: " + i + " = " + list.get(i));
			}
		} catch (IOException ioe) {
			System.out.println("Error al crear el archivo");
			ioe.printStackTrace();
			/*
			 * TODO: Crear un método que recupere al programa y le permita al usuario volver
			 * a intentar escribir el archivo
			 */
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("¡El índice no existe!");
			iobe.printStackTrace();
		} finally {
			if (out != null) {
				System.out.println("Cerrando PrintWriter...");
				out.close();
			}
		}
	}
}
