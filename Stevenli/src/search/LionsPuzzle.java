package search;

public class LionsPuzzle {

	public LionsPuzzle() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int lions=10;
		System.out.println(lions+" decide to eat the sheep? "+eatSheepOrNot(lions));

	}

	private static boolean eatSheepOrNot(int lions) {
		if(lions==1) {
			return true;
		}else {
			return !eatSheepOrNot(lions-1);
		}
		
	}

}
