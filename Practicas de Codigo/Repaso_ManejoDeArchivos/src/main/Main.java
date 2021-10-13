package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {
        // DONE: Crear personaje
        Personaje personaje = new Personaje();
        personaje.setNombre("Ultra Carlo ©");
        personaje.setNivel(26);
        personaje.setAtaque(8);
        personaje.setDefensa(11);
        personaje.setVitalidad(1000);
        personaje.setFrase("¡Aquí vamos señores! ©");
		
        // DONE: Crear archivo con el objeto.
        CrearArchivo(personaje);
		// DONE: Leer archivo generado.
        LeerArchivo();
        // DONE: Asignar lectura de archivo a un nuevo objeto.
        Personaje nuevoPersonaje = new Personaje();
        CargarPersonaje(nuevoPersonaje);
        PrintPersonaje(nuevoPersonaje);
        // DONE: Crear copia de archivo generado previamente.
        CrearCopia();

        // TODO: Crear arreglo de objetos de Personaje.
		// TODO: Guardar arreglo de objetos como nuevo archivo.
        // TODO: Leer archivo y asignaro a un arreglo.
	}

    static void PrintPersonaje(Personaje p){
        System.out.println(p.getNombre());
        System.out.println(p.getNivel());
        System.out.println(p.getAtaque());
        System.out.println(p.getDefensa());
        System.out.println(p.getVitalidad());
        System.out.println(p.getFrase());
    }

    static void CrearArchivo(Personaje personaje){
        try{
            BufferedWriter bw = new BufferedWriter(
            new FileWriter("personajes.txt")
            );
            bw.write(personaje.getNombre() + "\n");
            bw.write(personaje.getNivel() + "\n");
            bw.write(personaje.getAtaque() + "\n");
            bw.write(personaje.getDefensa() + "\n");
            bw.write(personaje.getVitalidad() + "\n");
            bw.write(personaje.getFrase() + "\n");
            // IMPORTANTE: SIEMPRE CERRAR EL ARCHIVO AL TERMINAR DE USARLO
            bw.close();
            System.out.println("¡Archivo creado con éxito!");
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    static void LeerArchivo(){
        try{
        BufferedReader br = new BufferedReader(
                new FileReader("personajes.txt")
            );
        String s;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
            br.close();
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    static void CargarPersonaje(Personaje p){
        try{
        BufferedReader br = new BufferedReader(
            new FileReader("personajes.txt")
        );
        String s;
            for(int i= 0; (s = br.readLine()) != null; i++){
                switch(i){
                    case 0:
                        p.setNombre(s);
                        break;
                    case 1:
                        int nivel = Integer.parseInt(s);
                        p.setNivel(nivel);
                        break;
                    case 2:
                        int ataque = Integer.parseInt(s);
                        p.setAtaque(ataque);
                        break;
                    case 3:
                        int defensa = Integer.parseInt(s);
                        p.setDefensa(defensa);
                        break;
                    case 4:
                        int vitalidad = Integer.parseInt(s);
                        p.setVitalidad(vitalidad);
                        break;
                    case 5:
                        p.setFrase(s);
                        break;
                    default:
                        System.out.println("Se terminó el archivo.");
                        break;
                }
            }
            br.close();
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    static void CrearCopia(){
        try{
            BufferedWriter bw = new BufferedWriter(
            new FileWriter("personajes_copia.txt")
            );
            BufferedReader br = new BufferedReader(
                new FileReader("personajes.txt")
            );
            String s;
            while((s = br.readLine()) != null){
                bw.write(s + "\n");
            }
            br.close();
            bw.close();
            System.out.println("¡Archivo copiado con éxito!");
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

}
