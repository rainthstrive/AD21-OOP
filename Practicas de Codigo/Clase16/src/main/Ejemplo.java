package main;

import java.util.ArrayList;

public class Ejemplo {
	Ejemplo(){
		usarArray();
	}
	void usarArray() {
		ArrayList<Integer> myNumbers = new ArrayList<Integer>();
	    myNumbers.add(10);
	    myNumbers.add(15);
	    myNumbers.add(20);
	    myNumbers.add(25);
	    for (int i : myNumbers) {
	      System.out.println(i);
	    }
	}
   
}
