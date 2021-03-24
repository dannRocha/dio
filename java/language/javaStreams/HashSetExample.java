package dio.javaStreams;


import java.util.HashSet; // Mais usada
import java.util.TreeSet; 
import java.util.LinkedHashSet; 
import java.util.Iterator;

public class HashSetExample {
	public static void main(String[] args) {
		var set = new HashSet<String>(); // Não mantem a ordem de inserçao e nao ordernação
		// var set = new TreeSet<String>(); // Permiti ordenação
		// var set = new LinkedHashSet<String>();  // Mantem a ordem de inserçao

		set.add("Daniel");
		set.add("Rocha");
		System.out.println(" - Interator : ");
		Iterator<String> interador = set.iterator();

		while(interador.hasNext()) {
			System.out.println(interador.next());
		}

		set.remove("Daniel");


		System.out.println(" - for : ");
		for(var value : set) {
			System.out.println(value);
		}

		set.clear();
	}
}
