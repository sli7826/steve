package caveExplorer;

public class makeGridNPC extends NPC{
	
	private int[][] wentTo;
	int[] start;
	
	public makeGridNPC() {
		wentTo=new int[CaveExplorer.caves.length*CaveExplorer.caves.length][2];
		start=super.returnPos();
	}
	public void setUp() {
		wentTo[0]= start;
		int idx=1;
		while(checkNull(wentTo)) {
			super.act();
			for(int[] a:wentTo) {
				
			}
			break;
		}
	}
	

	public static boolean checkNull(int[][] arr) {
		int check=0;
		for(int[] a:arr) {
			for(int b:a) {
				if(b==0) {
					check++;
				}
			}
			if(check==2) {
				return true;
			}
			check=0;
		}
		return false;
	}

}
