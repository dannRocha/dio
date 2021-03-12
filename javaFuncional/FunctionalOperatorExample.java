package dio.javaFuncional;

import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.BiPredicate;
import java.util.function.Function;


public class FunctionalOperatorExample {
	public static void main(String[] args) {

		UnaryOperator <Integer> multiplicarPorTres = numero -> numero * 3;
		BinaryOperator<Integer> mult = (a, b) -> a * b;
		BiPredicate<Integer, Integer> maiorQue = (a, b) -> a > b;
		Function<Integer, String> IntParaString = a ->  "String::type(" + a + ")";


		println("Resultado de 5 * 3 = " + multiplicarPorTres.apply(5));
		println("Resultado de 5 * 3 = " + mult.apply(5, 3));
		println("Booleano 5 > 3 =  " + maiorQue.test(5, 3));
		println("5 para String = " + IntParaString.apply(5));

	}

	static void println(Object o) {
		System.out.println(o);
	}
}
