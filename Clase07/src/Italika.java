
public class Italika extends Bike {
	
	Italika(){
		run();
	}

	@Override
	void run() {
		System.out.println("Andando a todo gas");
		System.out.println(name());
	}
	
	String name() {
		return "Vamonos recio";
	}

}
