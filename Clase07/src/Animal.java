
public class Animal {
	private String name = "Animal";
	
	Animal(){
		System.out.println("Comienza el sonido del animal");
	}
	public void animalSound() {
		System.out.println("El " + getName() + " hace [sonido genérico]");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
