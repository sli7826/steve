package search;

public class ArtificialForLoop {

	public static void main(String[] args) {
		forLoop(10,new Action() {
			
			int count=1;
			public void act() {
				System.out.println(count+" Hello World!");
				count++;
			}
		});

	}
	
	public static void forLoop(int n,Action a) {
		//if(n>0) {
			a.act();
			forLoop(n-1,a);
		//}
	}
}
