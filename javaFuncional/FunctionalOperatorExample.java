package dio.javaFuncional;

import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalOperatorExample {

	static Random rand = new Random();

	public static void main(String[] args) {

		UnaryOperator <Integer> multiplicarPorTres = numero -> numero * 3;
		BinaryOperator<Integer> mult = (a, b) -> a * b;
		Function<Integer, String> IntParaString = a ->  "String::type(" + a + ")";
		Predicate<Integer> ehPar = valor -> valor % 2 == 0;
		BiPredicate<Integer, Integer> maiorQue = (a, b) -> a > b;
		Supplier<Integer> random = () -> rand.nextInt(10);
		Supplier<Pessoa> instancia = Pessoa::new;

		println("UnaryOperator  | Resultado de 5 * 3 = " + multiplicarPorTres.apply(5));
		println("BinaryOperator | Resultado de 5 * 3 = " + mult.apply(5, 3));
		println("Function       | 5 para String = " + IntParaString.apply(5));
		println("Predicate      | 5 eh par : " + ehPar.test(5));
		println("Predicate      | 2 eh par : " + ehPar.test(2));
		println("BiPredicate    | Booleano 5 > 3 =  " + maiorQue.test(5, 3));
		println("Supplier       | Numero randomico : " + random.get());
		println("Supplier       | Instancia de Objeto : " + instancia.get());

	}

	static void println(Object o) {
		System.out.println(o);
	}
}


class Pessoa {
}
