package recursion;

public class Pokemon {
	
	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle",26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		squirtle.iChooseYou();
		bulbasaur.iChooseYou();
		System.out.println("Squirtle is preparing to attack with water blast");
		squirtle.attack(bulbasaur, new Attack() {
		
			public void attack(Pokemon target) {
			int hp = target.getHp();
			target.setHp(hp/2);
		}
		});
		System.out.println("Bulbasaur is preparing to attack with poison.");
		bulbasaur.attack(squirtle, new Attack() {
		
			public void attack(Pokemon target) {
			target.setPoisoned(true);
			}
			});
		squirtle.lapse();
		bulbasaur.lapse();
		printScore(squirtle, bulbasaur);
		System.out.println("Squirtle is attacking again");
		squirtle.attack(bulbasaur, new Attack() {
			
			public void attack(Pokemon target) {
				int oldHP=target.getHp();
				target.setHp(oldHP-1);
			}
		
		});
		printScore(squirtle, bulbasaur);
		squirtle.levelUp(squirtle,new Effect() {
			
			@Override
			public void effect() {
				squirtle.setHp(squirtle.getHp()+2);
				
			}
		});
		printScore(squirtle, bulbasaur);
		
	}
	
	public void levelUp(Pokemon p,Effect e) {
		p.level++;
		e.effect();
		System.out.println(name+" leveled up and it has gained 2 health.");
	}
	
	public static void printScore(Pokemon squirtle, Pokemon bulbasaur) {
		System.out.println(squirtle.getName()+", HP = "+squirtle.getHp());
		System.out.println(bulbasaur.getName()+", HP = "+bulbasaur.getHp());
	}

	public void attack(Pokemon target, Attack attack){
		if(Math.random() < .9){
			attack.attack(target);
			System.out.println("The attack hit");
		}else{
			System.out.println("The attack missed");
		}
	}
	
	
	
	public Pokemon(String name,int level) {
		this.level=level;
		this.name=name;
		poisoned=false;
		hp=100;
	}
	
	public void iChooseYou() {
		System.out.println(name);
		System.out.println(name);
	}
	
	public void lapse() {
		if(poisoned) {
			hp-=15;
		}
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}

}
