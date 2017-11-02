package caveExplorer;

public class CaveRoom {
	private String description;
	private String directions;
	private String contents;
	private String defaultContents;
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	public static final int NORTH=0;
	public static final int EAST=1;
	public static final int SOUTH=2;
	public static final int WEST=3;
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents=defaultContents;
		
		borderingRooms=new CaveRoom[4];
		doors=new Door[4];
		setDirections();
	}
	public static String toDirection(int dir) {
		String[] arr= {"the North","the East","the South","the West"};
		if(dir<arr.length)
			return arr[dir];
		return "";
	}
	public void enter() {
		contents="X";
	}
	public void leave() {
		contents=defaultContents;
	}
	public void setConnection(int direction,CaveRoom anotherRoom,Door door) {
		addRoom(direction,anotherRoom,door);
		anotherRoom.addRoom(oppositeDirection(direction),this,door);
	}
	public static int oppositeDirection(int direction) {
		return (direction+2)%4;
	}
	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction]=cave;
		doors[direction]=door;
		setDirections();
	}
	public void interpretInput(String input) {
		while(!isValid(input)) {
			printAllowedEntry();
			input=CaveExplorer.in.nextLine();
		}
		String dirs=validKeys();
		respondToKey(dirs.indexOf(input));
	}
	public String validKeys(){
		return "wdsa";
	}
	public void printAllowedEntry() {
		System.out.println("You can only enter 'w','a''s', or 'd'.");
	}
	public void respondToKey(int direction) {
		if(direction<4) {
			if(borderingRooms[direction]!=null&&doors[direction]!=null) {
				CaveExplorer.currentRoom.leave();
				CaveExplorer.currentRoom=borderingRooms[direction];
				CaveExplorer.currentRoom.enter();
				CaveExplorer.inventory.updateMap();
			}
		}else {
			performAction(direction);
		}
	}
	public void performAction(int direction) {
		CaveExplorer.print("That key does nothing.");
		
	}
	public static void setUpCaves() {
		CaveExplorer.caves=new NPCRoom[5][5];
		for(int row=0;row<CaveExplorer.caves.length;row++) {
			for(int col=0;col<CaveExplorer.caves[row].length;col++) {
				CaveExplorer.caves[row][col]=new NPCRoom("This cave has coords("+row+","+col+")");
			}
		}
		CaveExplorer.npcs=new NPC[1];
		CaveExplorer.npcs[0]=new NPC();
		CaveExplorer.npcs[0].setposition(1, 1);
		CaveExplorer.currentRoom=CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		int[][] wentTo=new int[CaveExplorer.caves.length*CaveExplorer.caves.length][2];
		int[] start={1,1};
		wentTo[0]= start;
		while(checkNull(wentTo)) {
			CaveExplorer.npcs[0].act();
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
	public boolean isValid(String input) {
		String validEntries=validKeys();
		return validEntries.indexOf(input)>-1&&input.length()==1;
	}
	public void setDirections() {
		directions="";
		boolean doorFound=false;
		for(int i=0;i<doors.length;i++) {
			if(doors[i]!=null) {
				doorFound=true;
				directions+="\n There is a "+doors[i].getDescription()+" to "+toDirection(i)+". "+doors[i].getDetails();
			}
		}
		if(!doorFound) {
			directions+="There are no doors, you are trapped in here.";
		}
	}
	
	public String getDescription() {
		return description +"\n"+directions;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}
	public Door getDoor(int direction) {
		if(direction>=0 &&direction<doors.length) {
			return doors[direction];
		}
		else {
			return null;
		}
	}
	
	

}
