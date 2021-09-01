
public class Dog extends Animal{
	Dog(){
		super.setName("SHIBA INU");
		animalSound();
	}
	public void animalSound() {
		System.out.println("El " + getName() + " hace WOOF");
	}
}
