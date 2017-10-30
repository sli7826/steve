package caveExplorer;

public class Inventory {
	
	private String map;
	
	public Inventory() {
		updateMap();
	}

	public void updateMap() {
		map=" ";
		for(int i=0;i<CaveExplorer.caves[0].length-1;i++) {
			map+="____";
		}
		map+="___\n";
		for(CaveRoom[] row:CaveExplorer.caves) {
			for(int i=0;i<3;i++) {
				String text="";
				for(CaveRoom cr:row) {
					if(cr.getDoor(CaveRoom.WEST)!=null&&cr.getDoor(CaveRoom.WEST).isOpen()) {
						text+=" ";
					}
					else {
						text +="|";
					}
					if(i==0) {
						text+="   ";
					}
					else if(i==1){
						text+=" "+cr.getContents()+" ";
					}
					else if(i==2) {
						if(cr.getDoor(CaveRoom.SOUTH)!=null&&cr.getDoor(CaveRoom.SOUTH).isOpen()) {
							text+="   ";
						}
						else {
							text+="___";
						}
					}
				}
				text+="|";
				map+=text+"\n";
			}
		}
	}

	public String getDescription() {
		return map;
		//return "You have nothing in your inventory.";
	}
	
	
}
