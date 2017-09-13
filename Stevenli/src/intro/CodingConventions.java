package intro;

public class CodingConventions {
	private String name;
	private String description;
	public CodingConventions(String name, int index) {
		 this.name=name;
		 description=IntroMain.DESCRIPTIONS[index];
	}
	public void doStuff() {
		System.out.println(name + description);
		System.out.println("the square root of 12 is " + Math.sqrt(12));
	}
}
