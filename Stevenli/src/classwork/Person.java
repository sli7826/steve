package classwork;

public class Person {
	private String firstName;
	private String lastName;
	private Borough home;
	public static final String[] FIRST_START= {"Chr","M","L","Gr","Ph","B","Th"};
	public static final String[] FIRST_MIDDLE= {"isti","icha","er","et","ere","era","ina"};
	public static final String[] FIRST_END= {"","na","n","r","tian","s","rs"};
	public static final String[] LAST_START= {"Chr","M","L","Gr","Ph","B","Th"};
	public static final String[] LAST_MIDDLE= {"om","o","a","e","i","u","is"};
	public static final String[] LAST_END= {"","son","ne","er","a","ing","ton"};
	public Person(String first,String last,Borough home) {
		firstName=first;
		lastName=last;
		this.home=home;
	}
	
	public String toString() {
		return "My name is "+firstName+" "+lastName+" and I live in "+home.toString()+".";
	}
	
}
