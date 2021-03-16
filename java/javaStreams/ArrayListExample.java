package dio.javaStreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class ArrayListExample {
  public static void main(String[] args) {
    
    var nameList = new ArrayList<String>();

    nameList.add("Rocha");
    nameList.add("Daniel");


    for(var name : nameList) {
      System.out.println("With 'for :' Name: " + name);
    }


    Iterator<String> iterator = nameList.iterator();
    while(iterator.hasNext()) {
      System.out.println("With 'Iterator' Name: " + iterator.next());
    }


    nameList.set(0, "Silva");

    Collections.sort(nameList);
    System.out.println(nameList);

    var firstName = nameList.get(0);
    
    nameList.remove(1);
    nameList.remove("Daniel");
 
    System.out.println("First Name: " + firstName);
    System.out.println(nameList);
    
  }
}