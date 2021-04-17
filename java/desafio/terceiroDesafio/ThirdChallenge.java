import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.io.FileInputStream;


public class ThirdChallenge {

  static String tokenEndLine = ".";

  public static void main(String[] args) throws IOException {
    
    var file = new FileInputStream("inputThirdChallenge.txt");
    var lineInput = new BufferedReader(new InputStreamReader(file));
    

    BiFunction<String, String, Integer> checkLongerLengthSubstring = (first, second) -> {
      
      if(first.equals(second)) {
        return first.length();
      }
      
      var longerLengthSubstring = 0;
      var currentLengthSubstring = 0;
      var substring = new StringBuilder();

      for(var i = 0; i < first.length(); i++) {
        for(var j = i; j < first.length(); j++) {
          substring.append(first.charAt(j));

          if(second.contains(substring)) {
            currentLengthSubstring++;
            continue;
          }
          
          substring.setLength(0);
          longerLengthSubstring = Math.max(currentLengthSubstring, longerLengthSubstring);
          currentLengthSubstring = 0;

          break;
    
        }
      }
      
      return Math.max(currentLengthSubstring, longerLengthSubstring);
    };

    BiPredicate<String, String> checkInputStringValid = (first, second) -> {
      
      final int MAX_LENGTH_CHAR = 50;

      return (second.isEmpty() || second.length() > MAX_LENGTH_CHAR ||
      first.isEmpty() || first.length() > MAX_LENGTH_CHAR);
      
    };

    String firstString;
    String secondString;
    
    while((firstString = lineInput.readLine()) != null 
    && (secondString = lineInput.readLine()) != null) {
      
      if(checkInputStringValid.test(firstString, secondString)) {
        continue;
      }

      System.out.println(checkLongerLengthSubstring.apply(firstString, secondString));
    }

    lineInput.close();
  }
}
