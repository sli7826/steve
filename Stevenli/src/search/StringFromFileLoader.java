package search;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class StringFromFileLoader {

	private String fileContent;

	public StringFromFileLoader(String fileLocation) {
		fileContent = "";
		readFile(fileLocation);

	}

	public String getFileContent(){
		return fileContent;
	}
	
	private void readFile(String fileName) {
		// (1) loads the entire file
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr); 
			String newLine;
			while ((newLine = br.readLine()) != null){
				fileContent+=newLine;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 


	}

	

}
