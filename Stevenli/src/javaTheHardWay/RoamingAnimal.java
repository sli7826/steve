package javaTheHardWay;

public class RoamingAnimal extends Animal {
	
	protected Habitat habitat;
	private boolean sex;

	public RoamingAnimal(Habitat matingArea) {
		super();
		this.habitat=matingArea;
		sex=Math.random()>.5;
	}

	public RoamingAnimal(Habitat matingArea,String description, Trait trait1, Trait trait2) {
		super(description, trait1, trait2);
		this.habitat=matingArea;
		sex=Math.random()>.5;
	}

	public static void main(String[] args) {
		int capacity=6;
		Habitat h=new Habitat(capacity);
		for(int i=0;i<capacity;i++) {
			RoamingAnimal r=new RoamingAnimal(h);
			h.addAnimal(r);
		}
		System.out.println(h);
		int years =7;
		for(int y=0;y<years;y++) {
			for(Animal a: h.getAnimals()) {
				if(a!=null)a.act();
			}
			h.growPlants();
			System.out.println("\n"+h);
		}

	}

	public boolean getSex() {
		return sex;
	}
	
	public void mate() {
		System.out.println(this+" does not have a mating ritual.");
	}
	
	public void act() {
		increaseAge();
		if(!canEat()) {
			System.out.println(this+" died of starvation.");
			habitat.removeAnimal(this);
		}else {
			if(getAge()>5) {
				System.out.println(this+" died of old age.");
				habitat.removeAnimal(this);
			}
			if(!hasMated()) {
				mate();
			}
		}
	}

	public boolean canEat() {
		return habitat.eatPlants();
	}
	
	

}
