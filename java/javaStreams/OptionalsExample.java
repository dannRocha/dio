package dio.javaStreams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.util.OptionalLong;

public class OptionalsExample {
	public static void main(String[] args) {

		Optional<String> optionalString = Optional.of("Valor presente\n");
		
		print("1 - Valor do Optional - Com valor:\n");
		optionalString.ifPresentOrElse(OptionalsExample::print, () -> print(" Não há valor\n"));

		print("2 - Valor do Optional  - Com null:\n");
		Optional<String> optionalNull = Optional.ofNullable(null);
		optionalNull.ifPresentOrElse(OptionalsExample::print, () -> print(" Não há valor\n"));

		print("3 - Valor do Optional  - Vazio:\n");
		Optional<String> optionalEmpty = Optional.empty();
		optionalEmpty.ifPresentOrElse(OptionalsExample::print, () -> print("Valor empty\n"));

		print("4 - Valor do Optional  - Retorno:\n");
		var data = returnValue(18);

		if(data.isPresent()) {
			print("Valor:" + data.get() + "\n");
		}
		else {
			print("Sem valor\n");
		}

		
		print("\n\n");

		print("OptinalInt: ");
		OptionalInt.of(12).ifPresent(System.out::println);

		print("OptinalDouble: ");
		OptionalDouble.of(12D).ifPresent(System.out::println);

		print("OptinalLong: ");
		OptionalLong.of(12L).ifPresent(System.out::println);


		// var throwable = Optional.ofNullable(null);
		var throwable = Optional.ofNullable(10);
		print(
			throwable.orElseThrow(IllegalStateException::new)
		);
	}	

	static void print(Object o) {
		System.out.print(o);
	}

	static Optional returnValue(int n) {
		if(n > 18) return Optional.ofNullable(n);
		return Optional.ofNullable(null);
	}

}

class NaoHaValor extends Exception {
	public NaoHaValor(String msg) { 
		super(msg);
	}
	
	public NaoHaValor(String msg, Throwable cause) {
		super(msg, cause);
	}
}
