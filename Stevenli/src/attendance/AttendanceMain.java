package attendance;

import java.util.Scanner;

public class AttendanceMain {

	//constants
	public static final String[] names ={"Nabeel Amin","Fahadullah Asif","Mimi Buan","Garrett Chen","Daniel Dong","Daniel Dong","Jane Feng","Jenny Fu","Remington Fu","Benjamin Gloger","Victor Hom","Lubna Khalid","Samuel Khong","Sunny Kwong","David Li","Steven Li","Zhehao Lin","Zhehao Lin","Ricky Pong","Sisiame Sakasamo","Erik Villavera","Jessi Wu","David Yashayev","Justin Yau","Coby Yee","Andrew Zhou","Tristan Chau","Theophilus Davis","Daniel Eisen","David Hung","Alice Karetsky","Joanna Lao","Jessica Li","Kevin Liu","Daniel Maseyev","Ethan Tam","David Tan","Devin Yang","Ji Ye","Raymond Zhao","Vincent Zheng","Weixiong Zhu","Jason Zou"};
	public static final Scanner inputSource = new Scanner(System.in);

	
	
	public static void main(String[] args){
		AttendanceApp app = new AttendanceApp();
		app.run();	
	}
	
	public static String getInput(){
		return inputSource.nextLine();
	}
	
	public static void print(String s){
		multiLinePrint(s);
	}

	public static void multiLinePrint(String s){
		String printString = "";
		int cutoff = 50;
		//this while loop last as long as there are words left in the original String
		while(s.length() > 0){

			String currentCut = "";
			String nextWord = "";

			//while the current cut is still less than the line length 
			//AND there are still words left to add
			while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

				//add the next word
				currentCut += nextWord;

				//remove the word that was added from the original String
				s = s.substring(nextWord.length());

				//identify the following word, exclude the space
				int endOfWord = s.indexOf(" ");

				//if there are no more spaces, this is the last word, so add the whole thing
				if(endOfWord == -1) {
					endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
				}

				//the next word should include the space
				nextWord = s.substring(0,endOfWord+1);
			}

			printString +=currentCut+"\n";

		}
		System.out.print(printString);
	}


}
