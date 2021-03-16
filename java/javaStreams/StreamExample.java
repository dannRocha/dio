package dio.javaStreams;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args) {
		
		var lista = List.of("Daniel Rocha da Silva".split(" "));
	
		println("Data: " + lista);
		
		println("Stream.count: " + lista.stream().count());
		println("Stream.max: " + lista.stream().max(Comparator.comparingInt(String::length)));
		println("Stream.min: " + lista.stream().min((a, b) -> a.length() - b.length() ));
		println("Stream.map: " + 
			lista
				.stream()
				.map(nome -> " * ".concat(nome.toUpperCase()))
				.collect(Collectors.toList())
		);

		println("Stream.filter: " + 
			List.of(1, 2, 3, 4)
				.stream()
				.filter(numero -> numero % 2 == 0)
				.collect(Collectors.toList())
		);

		println("Stream.limit: " + 
			lista
				.stream()
				.limit(2)
				.collect(Collectors.toList())
		);

		lista
			.stream()
			.forEach(nome -> {
				println(" * Stream.forEach - " + nome);
			});

		lista
			.stream()
			.peek(nome -> {
				println(" * Stream.peek - " + nome);
			})
			.collect(Collectors.toList());

		println("Stream.findFirst: " + lista.stream().findFirst().orElseThrow(IllegalStateException::new));

		println("All Methods");

		// lista;

		// Essa operação não eh sincrona
		println("\nEND: " + 
			lista
			.stream()
			.filter(nome -> nome.length() > 2)
			.peek(System.out::println)
			.map(nome -> " * ".concat(nome.toUpperCase()))
			.peek(System.out::println)
			.limit(2)
			.collect(Collectors.joining(" ")) 
		);

		 List.of(1, 2, 3, 4)
		 	.stream()
		 	.map(String::valueOf)
		 	.collect(Collectors.joining(""));
		
	}

	static void println(Object o) {
		System.out.println(o);
	}
}
