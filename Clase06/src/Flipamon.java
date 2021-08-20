import java.lang.Math;

public class Flipamon {
	private int vida;
	private String nombre;

	Flipamon(){
			
		}
	Flipamon(String nombre, int vida){
		setVida(vida);
		setNombre(nombre);
	}
	
	// Ataque Simple
	public int ataqueSimple() {
		return (int) Math.floor(Math.random()*4+1);
	}
	
	// Ataque Fuerte
	public int ataqueFuerte() {
		return (int) Math.floor(Math.random()*10+5);
	}
	
	// Metodo para calcular daño
	public void calcularVida(int puntos) {
		this.vida -= puntos;
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
