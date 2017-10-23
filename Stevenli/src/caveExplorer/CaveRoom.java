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
	private void setDirections() {
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
		return description;
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
	
	

}
