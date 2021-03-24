import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileInputStream;
import java.util.concurrent.CopyOnWriteArrayList;


public class SecondChallenge {

  public static void main(String[] args) throws IOException {
    var file = new FileInputStream("inputSecondChallenge.txt");
    var lineInput = new BufferedReader(new InputStreamReader(file));

    List<CopyOnWriteArrayList<String>> list = new ArrayList<>();
    String line = "";
    boolean toogle = false;
    var sublist = new CopyOnWriteArrayList<String>();


    while ((line = lineInput.readLine()) != null) {

      do {
        if (isNumeric(line))
          continue;
        sublist.add(line);
      } while (((line = lineInput.readLine()) != null) && !isNumeric(line));

      if (!sublist.isEmpty()) {
        list.add(new CopyOnWriteArrayList<String>(sublist));
      }
      sublist.clear();
    }

    
    for (var conjunto : list) {
      
      boolean isConjunto = false;

      for(var item : conjunto) {
        conjunto.remove(item);

        for(var string : conjunto) {
          if(string.indexOf(item) == 0) {
            isConjunto = true;
            break;
          }
        }
        
        if(isConjunto) {
          conjunto.add(item);
          break;
        }

        conjunto.add(item);
      }

      if(isConjunto) {
        System.out.println("Conjunto Ruim");
      }
      else {
        System.out.println("Conjunto Bom");
      }
    }

    System.out.println("");

    lineInput.close();
  }


  public static boolean isNumeric(String string) {
    return string != null && string.matches("[-+]?\\d*\\.?\\d+");
  }
}