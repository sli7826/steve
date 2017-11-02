package caveExplorer;

public class NPC {
	
	private CaveRoom[][] floor;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;

	public NPC() {
		floor=CaveExplorer.caves;
		activeDescription = "There is a person waiting to talk to you.";
		inactiveDescription = "The person you spoke to earlier is standing";
		currentCol=-1;
		currentRow=-1;
		currentRoom=null;
		active=true;
	}

	public boolean isActive() {
		return active;
	}
	
	public void setposition(int row,int col) {
		if(row>=0&&row<floor.length&&col>=0&&col<floor[row].length&&floor[row][col] instanceof NPCRoom) {
			if(currentRoom!=null) {
				currentRoom.leaveNPC();
			}
			currentRow=row;
			currentCol=col;
			currentRoom=(NPCRoom)floor[row][col];
			currentRoom.enterNPC(this);
		}
	}

	public void interact() {
		CaveExplorer.print("Hi");
		String s=CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print(".");
			s=CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("bye");
		active=false;
	}

	public String getInactiveDescription() {
		
		return inactiveDescription;
	}

	public String getActiveDescription() {
		// TODO Auto-generated method stub
		return activeDescription;
	}

	public void act() {
		if(active) {
			int[] move=calcluateMovement();
			int newRow=move[0];
			int newCol=move[1];
			setposition(newRow,newCol);
		}
	}

	public int[] calcluateMovement() {
		int[] moves=new int[2];
		int[][] possibleMoves={{-1,0},{0,1},{1,0},{0,-1}};
		int rand=(int)(Math.random()*possibleMoves.length);
		moves[0]=possibleMoves[rand][0]+currentRow;
		moves[1]=possibleMoves[rand][1]+currentCol;
		CaveExplorer.caves[currentRow][currentCol].setConnection(rand,CaveExplorer.caves[moves[0]][moves[1]],new Door());
		/*while(currentRoom.getDoor(rand)==null||!(CaveExplorer.caves[moves[0]][moves[1]] instanceof NPCRoom)) {
			rand=(int)(Math.random()*possibleMoves.length);
			moves[0]=possibleMoves[rand][0]+currentRow;
			moves[1]=possibleMoves[rand][1]+currentCol;
		}*/
		return moves;
	}
	
	public int[] returnPos() {
		int[] a={currentRow,currentCol};
		return a;
	}

}
