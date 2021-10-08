package clase15;

public class Generics {
	public <T> void printArray(T[] array) {
		for(T el: array)
			System.out.printf("%s", el);
		System.out.println();
	}
}
