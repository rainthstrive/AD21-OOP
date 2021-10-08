package clase15;

public class Overloads {
	public void printArray(Integer[] array) {
		for(Integer el: array)
			System.out.printf("%s", el);
		System.out.println();
	}
	public void printArray(Character[] array) {
		for(Character el: array)
			System.out.printf("%s", el);
		System.out.println();
	}
}
