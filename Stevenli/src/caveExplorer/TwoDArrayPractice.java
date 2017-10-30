package caveExplorer;

public class TwoDArrayPractice {

	public static void main(String[] args) {
		String[][] pic=new String[6][10];
		for(int row=0;row<pic.length;row++) {
			for(int col=0;col<pic[row].length;col++) {
				pic[row][col]=" ";
			}
		}
		drawBox(pic,5,4);
		print(pic);
	}

	private static void drawBox(String[][] pic, int i, int j) {
		if(i<pic.length&&i>=0) {
			drawSlot(pic,i,j);
			drawSlot(pic,i+1,j);
			if(i>0) {
				if(j>0)
					pic[i-1][j-1]="_";
				pic[i-1][j]="_";
				if(j<pic[i-1].length-1)
					pic[i-1][j+1]="_";
			}
			if(i<pic.length-1) {
				pic[i+1][j]="_";
			}
		}	
	}

	private static void drawSlot(String[][] pic, int i, int j) {
		if(i<pic.length&&i>=0) {
			if(j>0)
				pic[i][j-1]="|";
			if(j<pic[i].length-1)
				pic[i][j+1]="|";
			pic[i][j]=" ";
		}
	}

	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row=0;row<pic.length;row++) {
			pic[row][col]="|";
		}
		
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int col=0;col<pic[row].length;col++) {
			pic[row][col]="-";
		}
		
	}

	private static void print(String[][] pic) {
		String a="";
		for(int row=0;row<pic.length;row++) {
			for(int col=0;col<pic[row].length;col++) {
				a+=pic[row][col];
			}
			a+="\n";
		}
		System.out.println(a);
	}

}
