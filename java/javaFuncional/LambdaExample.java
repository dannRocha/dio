package dio.javaFuncional;

// import java.util.function.Function;

public class LambdaExample {
	public static void main(String[] args) {

		Funcao<String> preFixo = valor -> " >>> " + valor;

		println(preFixo.formatar("Lambda"));
		println("Booleano: 1: " + preFixo.trueOrFalse(1));
		println("Booleano: 0: " + preFixo.trueOrFalse(0));
		println("Par ou Impar: 2 " + preFixo.ParOuImpar(2));
		println("Par ou Impar: 3 " + preFixo.ParOuImpar(3));

		VetorOperator operator = a -> {
			return "Vetor {" + a.x +  ", " + a.y + "}";
		};

		Vetor a = new Vetor(10D, 5D);
		Vetor b = new Vetor(15D, 3D);

		println(" a --- : " + operator.formatar(a));
		println(" b --- : " + operator.formatar(b));
		println(" a + b : " + operator.formatar(operator.sum(a, b)));

	
 	}

	static void println(Object o) {
		System.out.println(o);
	}
}

@FunctionalInterface
interface Funcao<T> {
	T formatar(String a);

	default Boolean trueOrFalse(Integer a) {
		return (a == 0)? false : true ;
	}

	default String ParOuImpar(Integer a) {
		return (a % 2 == 0)? "Par": "Impar";
	}
}

class Vetor {
	public Double x;
	public Double y;

	public Vetor() {}
	public Vetor(Double x, Double y) {
		this.x = x;
		this.y = y;
	}
}

@FunctionalInterface
interface VetorOperator {
	String formatar(Vetor a);
	default Vetor sum(Vetor a, Vetor b) {
		var c = new Vetor();
		c.x = a.x + b.x;
		c.y = a.y + b.y;
		
		return c;
	}
}
