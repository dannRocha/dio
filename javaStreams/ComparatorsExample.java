package dio.javaStreams;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import java.util.Collections;
// import java.util.Comparable;

public class ComparatorsExample {
	public static void main(String[] args) {
	
		var list = new ArrayList<Estudante>();
		var rand = new Random();

		for(int i = 0; i < 10; i++) {
			list.add(new Estudante(rand.nextInt(30)));
		}

		System.out.println(" Order ");
		// Sort with Stream and Lambda a > b
		list.sort((a, b) -> a.getIdade() - b.getIdade());

		for(var estudante : list)
			System.out.println(estudante);

		System.out.println(" Order Reverse ");
		// Sort with Stream and Lambda a < b
		list.sort((a, b) -> b.getIdade() - a.getIdade());
		for(var estudante : list)
			System.out.println(estudante);

		// Other
		list.sort(Comparator.comparingInt(Estudante::getIdade));
		list.sort(Comparator.comparingInt(Estudante::getIdade).reversed());

		// Se Estudantes implementasse Comparable
		// Collections.sort(list);
		// Aplicar em regra de negocio mais complexa
		Collections.sort(list, new EstudanteCompare());
	}
}

class Estudante {
	
	private int idade;

	public Estudante(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return " >>> " + this.idade;
	}
	
	public int getIdade() {
		return this.idade;
	}
}

class EstudanteCompare implements Comparator<Estudante> {
	@Override
	public int compare(Estudante a, Estudante b) {
		return a.getIdade() - a.getIdade();
	}
}
/*
class Estudande implements Comparable<Estudante>{
	private int idade;
	public Estudande(int idade) {
		this.idade = idade;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	@Override
	public int compareTo(Estudante o) {
		return this.getIdade() - o.getIdade();
		
       // if(this.getIdade() > o.getIdade())
       // 	return 1;
       // if(this.getIdade() < o.getIdade())
       // 	return -1;
       // return 0;
		
	}
}
*/
