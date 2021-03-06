package dio.javaStreams;

import java.util.LinkedList;
import java.util.Collections;

public  class LinkedListExample {
	public static void main(String[] args) {
		var fila = new LinkedList<String>();

		fila.add("Daniel");
		fila.add("Silva");
		fila.add("Rocha");

		// Collections.sort(fila);

		var value = fila.poll(); // remove

		System.out.println("Saiu: " + value);
		System.out.println("Fila: " + fila);

		fila.clear();
		
	}
}
