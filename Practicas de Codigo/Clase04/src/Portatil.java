public class Portatil extends Consola{
	private int porcentajeBateria = 0;
	private int tamanoPantalla = 0;
	
	Portatil(String name, int year, int porcentajeBateria, int tamanoPantalla){
		super.setName(name);
		super.setYear(year);
		setPorcentajeBateria(porcentajeBateria);
		setTamanoPantalla(tamanoPantalla);
		showDetails();
	}

	public int getPorcentajeBateria() {
		return porcentajeBateria;
	}
	public void setPorcentajeBateria(int porcentajeBateria) {
		this.porcentajeBateria = porcentajeBateria;
	}

	public int getTamanoPantalla() {
		return tamanoPantalla;
	}
	public void setTamanoPantalla(int tamanoPantalla) {
		this.tamanoPantalla = tamanoPantalla;
	}
	public void showDetails() {
		super.showDetails();
		System.out.println("Porcentaje de bateria: " + getPorcentajeBateria() + "%");
		System.out.println("Tamaño de pantalla: " + getTamanoPantalla() + "p");
	}
}
