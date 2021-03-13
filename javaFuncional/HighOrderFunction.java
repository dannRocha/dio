package dio.javaFuncional;

import java.util.function.Consumer;

public class HighOrderFunction {

	public static void main(String[] args) {
		exemplo1();
		exemplo2();

	}

	// Funcao de alta ordem : passagem de um comportamento por parametro;
	static int aplicar(Calculo calc, int a , int b) {
		return calc.operacao(a, b);
	}

	static void exemplo1() {

		println("Exemplo 1 - Lambada e Funções de alta ordem");

		Calculo calc;

		calc = (a, b) -> a + b;
		println("2 + 3 : " + aplicar(calc, 2, 3));

		calc = (a, b) -> a - b;
		println("2 - 3 :" + aplicar(calc, 2, 3));

		calc = (a, b) -> a * b;
		println("2 * 3 : " + aplicar(calc, 2, 3));

		calc = (a, b) ->  {
			if(b == 0D) throw new IllegalArgumentException("Divisão por zero");
			return a / b;
		};
		println("2 / 3 : " + aplicar(calc, 2, 3));

		try {
			println("2 / 0 : " + aplicar(calc, 2, 0));
		}
		catch(Exception e) {
			println("2 / 0 : " + e);
		}
	}

	static void exemplo2() {
		println("\nExemplo 2");

		Consumer<String> print = System.out::println;

		print.accept("Ola Mundo - Exemplo 2");
	}

	static void println(Object o) {
		System.out.println(o);
	}
}

@FunctionalInterface
interface Calculo {
	int operacao(int a, int b);
}

