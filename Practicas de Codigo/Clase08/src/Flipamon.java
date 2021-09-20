public class Flipamon{
	private int vida;
	private String nombre;

	Flipamon(String nombre, int vida){
		setVida(vida);
		setNombre(nombre);
	}
	
	// Ataque Simple
	public int ataqueNormal() {
		return (int) Math.floor(Math.random()*4+1);
	}
	
	// Ataque Fuerte
	public int ataqueFuerte() {
		return (int) Math.floor(Math.random()*8+4);
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
