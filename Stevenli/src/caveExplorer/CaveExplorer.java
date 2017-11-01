package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoom[][] caves;
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	public static boolean playing=true;
	public static NPC[] npcs;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		
		inventory= new Inventory();
		startExploring();
	}
	public static void startExploring() {
		while(playing) {
			npcActions();
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input=in.nextLine();
			currentRoom.interpretInput(input);
		}
		
	}
	
	private static void npcActions() {
		for(NPC n:npcs) {
			n.act();
		}
		inventory.updateMap();
		
	}
	public static void print(String s) {
		System.out.println(s);
	}

}
