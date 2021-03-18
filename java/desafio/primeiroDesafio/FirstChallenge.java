import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileInputStream;


public class FirstChallenge {

  static String tokenEndLine = ".";

  public static void main(String[] args) throws IOException {
    var file = new FileInputStream("inputFirstChallenge.txt");
    var lineInput = new BufferedReader(new InputStreamReader(file));
  
    List<String> list = new ArrayList<>();
    var line = "";
    
    while(!tokenEndLine.equals(line = lineInput.readLine())) {
      if(line == null) 
        return;
      
      list.add(line);
    }

    lineInput.close();
    
    for(var text : list) {
      printAbbreviations(text);
    }

    System.out.println("");

  }

  static void printAbbreviations(String text) {
    
    var wordRepeat = new HashMap<String, Integer>();
    var abbreviations = new TreeMap<String, String>();
    var rawText = new StringBuilder();
    var phrase = new StringTokenizer(text);

    while(phrase.hasMoreTokens()) {
      var word = phrase.nextToken();
      rawText.append(word + " ");

      if(!wordRepeat.containsKey(word)) {
        wordRepeat.put(word, 1);
      }
      else {
        wordRepeat.put(word, wordRepeat.get(word) + 1);
      }
    }

    if(tokenEndLine.equals(text) && wordRepeat.isEmpty()) {
      return;
    }

    final Integer MAX_ABBREVIATION_LENGTH = 2;
    wordRepeat.keySet().removeIf(word -> word.length() <= MAX_ABBREVIATION_LENGTH);
    
    var weights = new HashMap<String, String>();
    wordRepeat.entrySet()
      .stream()
      .forEach((value) -> {
        var word = value.getKey();
        var abbr = word.substring(0, 1);
        
        if(!abbreviations.containsValue(abbr)) {
          abbreviations.put(word, abbr);
          weights.put(abbr, word);
        }
        else {
          
          var wordStoreged = weights.get(abbr);
          var storedWordWeight = (wordStoreged.length()  - MAX_ABBREVIATION_LENGTH) * wordRepeat.get(wordStoreged);
          var newWordWeight = (word.length()  - MAX_ABBREVIATION_LENGTH) * wordRepeat.get(word);
          
          if(newWordWeight > storedWordWeight ) {
            abbreviations.remove(wordStoreged);
            abbreviations.put(word, abbr);
            weights.put(abbr, word);
          }
        }
      });
      
    weights.clear();
    
    var output = Stream.of(rawText.toString().split(" "))
      .map(word -> abbreviations.containsKey(word)? abbreviations.get(word) + "." : word) 
      .collect(Collectors.joining(" "))
      .replaceAll("[.+]{2,}", ".")
      .trim();

    System.out.println(output);
    
    System.out.println(abbreviations.size());
    
    abbreviations.forEach((word, abbr) -> {
      System.out.println(abbr + ". = " + word);
    });
  }
}