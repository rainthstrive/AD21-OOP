import java.io.File;  // Importamos la clase File
import java.io.IOException;  // Importamos la clase IOException para manejar errores

public class Archivos {

    Archivos(){
        crear();
    }

    public void crear() {
        try {
        File myObj = new File("E:\\Mass Storage\\Escritorio\\2021\\Teaching\\lcc\\2021_agosto\\poo\\prueba\\filename_20210920.txt");
        if (myObj.createNewFile()) {
            System.out.println("Archivo creado: " + myObj.getName());
        } else {
            System.out.println("El archivo ya existe.");
        }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
}
