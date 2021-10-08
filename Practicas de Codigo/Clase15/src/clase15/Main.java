package clase15;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		/*
		Integer[] intArray = {5, 7, 3};
		Character[] charArray = {'b', 'e', 'm', 'a', 'n', 'i'};
		
		Overloads overloads = new Overloads();
		overloads.printArray(intArray);
		overloads.printArray(charArray);
		
		System.out.println();
		
		Object[] intArray2 = {5, 7, 3};
		Object[] charArray2 = {'b', 'e', 'm', 'a', 'n', 'i'};
		
		Generics generics = new Generics();
		generics.printArray(intArray2);
		generics.printArray(charArray2);
		
		System.out.println();
		*/
		
		Wildcards<Integer> integerW = new Wildcards<Integer>(5);
		Wildcards<Double> doubleW = new Wildcards<Double>(-5.0);
		
		System.out.println(integerW.absoluteEqual(doubleW));
		
	}
}
