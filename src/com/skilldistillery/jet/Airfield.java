package com.skilldistillery.jet;

import java.io.*;
import java.util.*;

public class Airfield {

	String file = "Jets.txt";
	List<Jet> ParkingLot;

	public Airfield() {
		ParkingLot = new ArrayList<Jet>();
		lookupRecords(file);
	}

	private void lookupRecords(String file) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt"))) {
		String line;
		while ((line = bufIn.readLine()) != null) {
		String[] jetData = line.split(", ");
		String type= jetData[0];
		String model=jetData[1];
		double speed = Double.parseDouble(jetData[2]);
		int range = Integer.parseInt(jetData[3]);
		long price = Long.parseLong(jetData[4].trim());
		
		if (line.contains("Fighter")) {
		Jet j = new Fighter (type,model,speed, range, price);
			ParkingLot.add(j);
		}
		
		if(line.contains("Cargo" )) {
			CargoPlane j = new CargoPlane (type,model,speed, range,price);
			ParkingLot.add(j);
		}
		}
		
		}
				 catch (FileNotFoundException e) { 
					e.printStackTrace();}
				 catch (IOException e) {
					e.printStackTrace();
				 }
		

	

}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Airfield [file=").append(file).append(", JLists=").append(ParkingLot).append("]");
		return builder.toString();
	}

	public void displayAll() {
//		System.out.println("The jets in the hanger are\n " +  ParkingLot);
	for (Jet jet : ParkingLot) {
		System.out.println(jet);
	}

	}

	public void flyAll() {
		for (Jet jet : ParkingLot) {
			System.out.println("The entire fleet is up in the air");
			
		}
	}

	public void fastestJet() {
		
	}

	public void longestRange() {
		
	}

	public void loadAll() {
		
	}

	public void fightAll() {
		
	}

	public void addJet() {
		
	}

	public void removeJet() {
		
	}
	
	
	
	
	
	
	
	
	
}