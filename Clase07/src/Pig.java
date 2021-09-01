
public class Pig extends Animal{
	Pig(){
		super.setName("CERDO");
		animalSound();
	}
	public void animalSound() {
		System.out.println("El " + getName() + " hace OINK");
	}
}
