import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import java.io.FileInputStream;


public class FifthChallenge {

  public static void main(String[] args) throws IOException {
    
    var file = new FileInputStream("inputFifthChallenge.txt");
    var lineInput = new BufferedReader(new InputStreamReader(file));
    
 
    String password;
    while((password = lineInput.readLine()) != null) {
      System.out.println(passwordValidator(password));
    }

  }
  
  static String passwordValidator(String password) {
	  
	  if(password == null) {
	    return "Senha invalida.";
	  }
	  
	  final int MIN_PASSWORD_LENGTH = 6;
		final int MAX_PASSWORD_LENGTH = 32;
		
    Predicate <String>hasAlphabetUpperCase = 
      (string) -> Pattern.compile("[A-Z]").matcher(string).find();
    
    Predicate <String>hasAlphabetLowerCase = 
      (string) -> Pattern.compile("[a-z]").matcher(string).find();
    
    Predicate <String>hasNumber = 
      (string) -> Pattern.compile("\\d").matcher(string).find();
    
    Predicate <String>hasNoInvalidCharacter = 
      (string) -> !Pattern.compile("[\u00C0-\u00FF|\u0020-\u002F|\u003A-\u0040]").matcher(string).find();
    
    Predicate <String>validLength = 
      (string) -> string.length() >= MIN_PASSWORD_LENGTH && string.length() <= MAX_PASSWORD_LENGTH;
      
  
    String passwordValid = Stream.of(password)
      .filter(hasNumber::test)
      .filter(hasAlphabetLowerCase::test)
      .filter(hasAlphabetUpperCase::test)
      .filter(hasNoInvalidCharacter::test)
      .filter(validLength::test)
      .collect(Collectors.joining());
    
    return (passwordValid.equals(""))
      ? "Senha invalida."
      : "Senha valida.";
	}
  
}
