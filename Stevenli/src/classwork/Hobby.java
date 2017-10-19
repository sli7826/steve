package classwork;

public class Hobby extends Thing{

	public Hobby(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public static Hobby randomHobby() {
		Hobby[] someHobbies= {new Hobby("Programming"),new Hobby("Dancing"),new Hobby("playing video games")};
		return someHobbies[(int)(Math.random()*someHobbies.length)];
	}
}
