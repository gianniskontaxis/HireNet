import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	
	private aes data = new aes();
	private final String secretKey = "aes4";
	
	public FileManager() {}
	
	public ArrayList<String> read(String filename) {
		
		String line="";
		ArrayList<String> list = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader((filename)));
			while( (line=reader.readLine()) != null ) {					
				list.add(line);				
			}				
			reader.close();					
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return list;
	}
	public ArrayList<String> readDecr(String filename) {	
		
		String line="";
		ArrayList<String> list = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader((filename)));
			while( (line=reader.readLine()) != null ) {		
				line=data.decrypt(line,secretKey);
				list.add(line);					
			}				
			reader.close();					
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return list;		
	}
	public void writeText(String filename,String text,boolean append,boolean encryption) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter((filename),append));	
			if (encryption) 
				text=data.encrypt(text,secretKey);
			writer.write(text+ "\n");						
			writer.close();			
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	public void writeList (String filename,ArrayList<String> list,boolean append,boolean encryption) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter((filename),append));	
			for (String text : list) {
			if (encryption) 
				text=data.encrypt(text,secretKey);
			writer.write(text+ "\n");	
			}
			writer.close();			
		} catch (IOException e1) {
			e1.printStackTrace();
		}			
	}
}
