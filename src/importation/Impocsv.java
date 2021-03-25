package importation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Impocsv {

	String path="";
	String line="";

	public Impocsv(String path) {
		this.path = path;
		
	}
	
	public ArrayList<String> impocsv() {
		
		ArrayList<String> l0 = new ArrayList<>();
		try {
			BufferedReader rd = new BufferedReader(new FileReader(path));
			while((line = rd.readLine()) != null) {
				String[] values = line.split(",");
				l0.add(values[0]);
				
			}
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}
		
		return l0;
	}
}
