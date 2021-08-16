import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese matricula: ");
	    int matricula = scanner.nextInt();
	    boolean alumnoEncontrado = false;
	    switch(matricula) {
		    case 1599992:
		    	System.out.println("Alumno: Arturo García");
		    	alumnoEncontrado = true;
		    	break;
		    case 1899321:
		    	System.out.println("Alumno: Juan Carlos B.");
		    	alumnoEncontrado = true;
		    	break;
		    // N cantidad de cases
		    default:
		    	System.out.println("Alumno no encontrado");
		    	break;
	    }	
	    if(alumnoEncontrado) {
	    	evaluaAlumno();
	    } else {
	    	System.out.println("Fin");
	    }
	}
	
	public static void evaluaAlumno() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese calificación: ");
	    int input = scanner.nextInt();
	    
	    if(input < 70 )
	    {
	    	System.out.println("Usted ha reprobado");
	    } else {
	    	System.out.println("Usted está pendiente de calificación");
	    }
	}

}

