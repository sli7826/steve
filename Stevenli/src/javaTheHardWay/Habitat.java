package javaTheHardWay;

public class Habitat extends Environment{
	
	private Animal[] animals;

	public Habitat(int livingCapacity) {
		super(livingCapacity);
		animals= new Animal[livingCapacity];
	}

	public static void main(String[] args) {
		Habitat h= new Habitat(5);
		int count = 0;
		while(count<6) {
			Animal a = new Animal();
			h.addAnimal(a);
			count++;
		}
		System.out.println(h);

	}
	
	public String toString() {
		return super.toString()+"\nHabitants:\n"+animalReport();
	}

	public String animalReport() {
		String s="";
		for(Animal a:animals) {
			s+=a+"\n";
		}
		return s;
	}
	
	public Animal[] getAnimals() {
		return animals;
	}
	
	public void addAnimal(Animal animal) {
		int i=0;
		while(i<animals.length) {
			if(animals[i]==null) {
				animals[i]=animal;
				break;
			}
			i++;
		}
	}
	
	public void removeAnimal(int i) {
		animals[i]=null;
	}
	
	public void removeAnimal(Animal a) {
		for(int i=0;i<animals.length;i++) {
			if(animals[i]==a)animals[i]=null;
		}
	}

}
