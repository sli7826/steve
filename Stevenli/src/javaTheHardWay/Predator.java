package javaTheHardWay;

public class Predator extends ReproductionAnimal {

	public Predator(Habitat matingArea) {
		super(matingArea);
		setMaxLitterSize(3);
	}
	
	public Predator(Habitat matingArea,String description, Trait trait1, Trait trait2) {
		super(matingArea,description,trait1,trait2);
		setMaxLitterSize(3);
	}
	
	public static final String[] PREDATORS= {"wolf","bear","lion","bobcat"};
	
	public String getname() {
		return PREDATORS[(int)(Math.random()*PREDATORS.length)];
	}
	
	public static void main(String[] args) {
		Wilderness wilderness=new Wilderness("A wooded Area",10);
		Predator p=new Predator(wilderness);
		wilderness.addAnimal(p);
		wilderness.simulate(2);
	}
	
	public ReproductionAnimal getoffspring(ReproductionAnimal mate) {
		return new Predator(habitat,getDescription(),Trait.getDominateTrait(getTrait1(), mate.getTrait1()),
				Trait.getDominateTrait(getTrait2(), mate.getTrait2()));
	}
	
	public boolean canEat() {
		int attempts=0;
		while(attempts<3) {
			int tIndex=(int)(Math.random()*habitat.getAnimals().length);
			Animal target=habitat.getAnimals()[tIndex];
			if(target instanceof Prey) {
				habitat.removeAnimal(tIndex);
				return true;
			}
			attempts++;
		}
		return false;
	}
	

}
