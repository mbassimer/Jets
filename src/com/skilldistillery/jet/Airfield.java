package com.skilldistillery.jet;
import java.io.*;


public class Airfield() {

	
		
		 try ( BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt")) ) {
		      String Jet;
		      Jet = bufIn.readLine();
		      while ((Jet = bufIn.readLine()) != null) {
		        
				String[] jetRecord = Jet.split(", ");
		        
		        
		        
		        
		       
		        
		        Jet = bufIn.readLine();
		        		
	}
		
		
	}
	
	

}
