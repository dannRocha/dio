package dio.javaStreams;

import java.util.Vector;
import java.util.Collections;


public class VectorExample {
  public static void main(String[] args) {
    System.out.println("Vector");

    var nameList = new Vector<String>();
    
    nameList.add("Rocha");
    nameList.add("Daniel");

    Collections.sort(nameList);
    System.out.println(nameList);
  }
}