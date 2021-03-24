package dio.javaStreams;

import java.util.HashMap;
import java.util.TreeMap;
// import java.util.HashTable;

public class HashMapExample {
	public static void main(String[] args) {
		var hashMap = new HashMap<String, String>();
		var idades = new HashMap<String, Integer>();
		// var idades = new TreeMap<String, Integer>();

		idades.put("daniel", 22);
		idades.put("rocha", 21);
		idades.put("silva", 20);
		idades.set("silva", 20);
		idades.put("any", null);
		System.out.println("->" + idades.get(0));

		// return null
		System.out.println("Value of key 'sampaio': " + idades.get("sampaio"));
		
		// put sobrescreve valor da sabe se existir
		hashMap.put("nome", "Daniel");
		hashMap.put("idade", "Daniel");

		System.out.println("contains key 'daniel': " + idades.containsKey("daniel"));
		System.out.println("contains key 'niel': " + idades.containsKey("niel"));

		System.out.println("Idade de Daniel: " + idades.get("daniel"));
		idades.remove("daniel");
		
		idades.clear();
		hashMap.clear();
	}
}
