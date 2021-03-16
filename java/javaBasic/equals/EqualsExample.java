package dio.equals;

import java.util.Objects;

public class EqualsExample {
	public static void main(String[] args) {
		var p1 = new People("Daniel");
		var p2 = new People("Rocha");
		var p3 = new People("Daniel");

		System.out.printf("%s == %s : %b\n", p1.name, p2.name, p1.equals(p2) ) ;
		System.out.printf("%s == %s : %b\n", p1.name, p3.name, p1.equals(p3) ) ;
	}
}

public class People {

	public String name;

	public People(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {

		if(o == null) return false;
		
		// Java 17 - Preview Feature
		if(o instanceof People p) {
			return this.hashCode() == p.hashCode();
		}
		
		return false;
	
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}

