package classwork;

public class Borough {
	public static final Borough[] NY_BOROUGHS= {new Borough("Brooklyn"),new Borough("Bronx"),new Borough("Queens"),new Borough("Staten Island"),new Borough("Manhattan")};
	private String name;
	public Borough(String name) {
		this.name=name;
	}
	public String toString() {
		return name;
	}
}
