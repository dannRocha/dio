import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;


public class FourthChallenge {

  public static void main(String[] args) throws IOException {
    var file = new FileInputStream("inputFourthChallenge.txt");
    var lineInput = new BufferedReader(new InputStreamReader(file));
    
 
    String word;
    while((word = lineInput.readLine()) != null) {
      handleSubStringRepeat(word);
    }

  }
  
  static void handleSubStringRepeat(String word) {

	var sufix = false;

    for (var index = 0; index < word.length(); index++) {
      
      var firstSubString  = word.substring(0, index);
      var secondSubString = word.substring(index);
    
      if (firstSubString.endsWith(secondSubString)) {
        sufix = true;
        System.out.println(firstSubString);
      }
    }

    if (!sufix)
      System.out.println(word);
    
  }
  
}
