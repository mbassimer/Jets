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
				String type = jetData[0];
				String model = jetData[1];
				double speed = Double.parseDouble(jetData[2]);
				int range = Integer.parseInt(jetData[3]);
				long price = Long.parseLong(jetData[4].trim());

				if (line.contains("Fighter")) {
					Jet j = new Fighter(type, model, speed, range, price);
					ParkingLot.add(j);
				}

				if (line.contains("Cargo")) {
					CargoPlane j = new CargoPlane(type, model, speed, range, price);
					ParkingLot.add(j);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
			double timeLeft = jet.getRange() / jet.getSpeed();
			double roundOff = Math.round(timeLeft * 100) / 100;
			System.out
					.println(jet.getModel() + "  is in the air" + " and has\n " + roundOff + " hours left in the air");

		}
	}

	public void fastestJet() {
		double fastest = 0;

		for (Jet jet : ParkingLot) {
			if (jet.getSpeed() > fastest) {
				fastest = jet.getSpeed();

			}
		}
		for (Jet jet2 : ParkingLot) {
			if (fastest == jet2.getSpeed()) {

				System.out.println(jet2.toString() + "can fly the fastest!");
			}

		}
	}

	public void longestRange() {
		double longestRange = 0;
		
		for (Jet jet : ParkingLot) {
			if (jet.getRange() > longestRange) {
				longestRange = jet.getRange();

			}
		}

			for (Jet jet2 : ParkingLot) {
				if (longestRange == jet2.getRange()) {

					System.out.println(jet2.toString() + " can fly the farthest!");
				}

			}

		}
	

	public void loadAll() {
		 for (Jet jet : ParkingLot) {
			 if ( jet.getType().contentEquals("Cargo")); {
//				 Cargoier();
			
		}
		}

	}

	public void fightAll() {

	}

	public void addJet() {

	}

	public void removeJet() {

	}

}