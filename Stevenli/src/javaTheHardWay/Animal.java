package javaTheHardWay;

public class Animal {
	
	private String description;
	private Trait trait1;
	private Trait trait2;
	private int age;
	private boolean mated;
	
	public Animal() {
		chooseTraits();
		description=getName();
		age=0;
	}
	
	public Animal(String description, Trait trait1, Trait trait2) {
		this.trait1=trait1;
		this.trait2=trait2;
		while(trait2.equals(trait1)) {
			trait2=new Trait();
		}
		this.description=description;
		
	}
	
	
	public static void main(String[] args) {
		for (int i=0;i<10;i++) {
			Animal someAnimal =new Animal();
			System.out.println(someAnimal);
		}

	}
	
	public String getName() {
		return "animal";
	}
	
	public void chooseTraits() {
		trait1=new Trait();
		trait2=new Trait();
		while(trait1.equals(trait2)) {
			trait2=new Trait();
		}
	}
	
	public String toString() {
		return "a "+age+" year old, "+trait1+", "+trait2+" "+description;
	}
	
	public void increaseAge() {
		age++;
	}
	
	public void reset() {
		mated=false;
	}

	public boolean hasMated() {
		return mated;
	}

	public void setMated(boolean mated) {
		this.mated = mated;
	}

	public String getDescription() {
		return description;
	}

	public Trait getTrait1() {
		return trait1;
	}

	public Trait getTrait2() {
		return trait2;
	}

	public int getAge() {
		return age;
	}
	
	public void act() {
		System.out.println(this+" is sleeping");
		mated=true;
	}

}
