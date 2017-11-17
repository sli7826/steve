package javaTheHardWay;

public class ReproductionAnimal extends RoamingAnimal{
	
	private int maxLitter;
	public static void main(String[] args) {
		Habitat h = new Habitat(3);
		ReproductionAnimal animal1 = new ReproductionAnimal(h);
		ReproductionAnimal animal2 = new ReproductionAnimal(h);
		ReproductionAnimal youngAnimal = animal1.getOffspring(animal2);
		while(youngAnimal == null) {
			animal2 = new ReproductionAnimal(h);
			youngAnimal = animal1.getOffspring(animal2);
		}
		System.out.println(animal1 + " and a\n" +  animal2);
		System.out.println("had a baby and it was a\n"+youngAnimal);
	}


	public ReproductionAnimal(Habitat matingArea) {
		super(matingArea);
		maxLitter =1;
	}

	public ReproductionAnimal(Habitat matingArea, String description, Trait trait1, Trait trait2) {
		super(matingArea, description, trait1, trait2);
		maxLitter =1;
	}
	
	public void setmaxLitterSize(int max) {
		this.maxLitter =  max;
	}
	
	public ReproductionAnimal getOffspring(ReproductionAnimal mate) {
		return new ReproductionAnimal(habitat, getDescription(),
					Trait.getDominateTrait(getTrait1(), mate.getTrait1()),
					Trait.getDominateTrait(getTrait2(), mate.getTrait2()));
					
	}
	
	public final void mate() {
		
		int i = 0;
		while(i < habitat.getAnimals().length) {
				Animal target = habitat.getAnimals()[i];
				if(target instanceof ReproductionAnimal &&
								target.getDescription().equals(getDescription()) &&
								((ReproductionAnimal) target).getSex() != getSex() &&
								!target.hasMated()) {
					Animal baby = getOffspring((ReproductionAnimal)target);
					if(baby != null) {
						int litterSize = (int)(Math.random() * maxLitter);
						for(int j = 1; j < litterSize; j++) {
							habitat.addAnimal(baby);;
							baby = getOffspring((ReproductionAnimal)target);
							
						}
						setMated(true);
						target.setMated(true);;
						break;
				}
			}
			i++;
		}
	}
}
