public class Consola {
	private String name = "Mi Consola";
	private int year = 2000;
	
	Consola(){
		//showDetails();
	}
	Consola(String name, int year){
		setName(name);
		setYear(year);
		showDetails();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getname() {
		return name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void showDetails() {
		System.out.println("Nombre de consola: " + getname());
		System.out.println("Año: " + getYear());
	}
}
