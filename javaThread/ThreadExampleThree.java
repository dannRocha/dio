package dio.javaThread;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class ThreadExampleThree {
  public static void main(String[] args) {

    System.out.println("For Each Seria x Paralelo");
    long inicio = System.currentTimeMillis();
    IntStream.range(0, 100_000).forEach(num -> fatorial(num));
    long fim = System.currentTimeMillis();
    System.out.println(" Tempo Serial: " + (fim - inicio) + "ms");
    inicio = System.currentTimeMillis();
    IntStream.range(0, 100_000).parallel().forEach(num -> fatorial(num));
    fim = System.currentTimeMillis();

    System.out.println(" Tempo Paralelo: " + (fim - inicio) + "ms");

    var list = new ArrayList<String>();

    list.add("daniel");
    list.add("rocha");
    list.add("silva");
    
    System.out.println("Processamento paralelo");
    list.parallelStream().forEach(System.out::println);


  }
  
  static long fatorial(long n) {
    long fat = 1;
    
    for(long i = 2 ; i < n; i++) {
      fat *= i;
    }

    return fat;
  }
}
