package search;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {

	public static void main(String[] args){
		File file = new File("Data/");
		file.mkdirs();
		new Generator("Data/ints.txt", 10000);
	}
	
	public Generator(String filename, int numberOfInts) {
		String s="";
		FileWriter f;
		int j = 0;
		for(int i=0; i < numberOfInts; i++){
			j+= (int)(Math.random()*10);
			s+=j+", ";
		}
		try {
			
			f = new FileWriter(filename);
			f.write(s); 
			f.close(); 	
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
}
