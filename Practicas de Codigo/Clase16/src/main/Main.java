package main;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		String[] arreglo = {"Cesar", "Adrian", "Los Gatos de David", "Ingrid"};
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(arreglo[0]);
		list.add(arreglo[1]);
		list.add(arreglo[2]);
		
		System.out.println(list.get(1)); // Adrian
		list.set(1, "Espiritus Chocarreros");
		System.out.println(list.get(1)); // Espiritus Chocarreros
		
		list.remove(1); // Cesar, Espiritus Chocarreros, Los Gatos De David
		// Cesar, Los Gatos De David
		System.out.println(list.get(1));
		
		System.out.println("___");
		
		for (String elemento : list) {
		      System.out.println(elemento);
		    }
		
		list.clear();
		System.out.println(list.size());
		
		System.out.println("___");
		
		ArrayList<Integer> myNumbers = new ArrayList<Integer>();
	    myNumbers.add(5434);
	    myNumbers.add(234);
	    myNumbers.add(67);
	    myNumbers.add(200000);
	    for (int i : myNumbers) {
	      System.out.println(i);
	    }
	    
	    ArrayList<String> list2 = new ArrayList<String>();
	    list2.addAll(list);
	    ArrayList<String> list3 = new ArrayList<String>();
	    Collections.addAll(list3, arreglo);
	    for (String i : list3) {
		      System.out.println(i);
		    }
	    
	    System.out.println("___");

	    Collections.sort(myNumbers);  // Ordena cars
	    for (int i : myNumbers) {
	      System.out.println(i);
	    }
	}

}
