package com.skilldistillery.jet;

import java.io.*;
import java.util.*;

public class Airfield {

	String file = "Jets.txt";
	List<jet> ParkingLot;
	String line;
	private String Scanner;

	public Airfield() {
		ParkingLot = new ArrayList<jet>();
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
					jet j = new Fighter(type, model, speed, range, price);
					ParkingLot.add(j);
				}

				else if (line.contains("Cargo")) {
					CargoPlane j = new CargoPlane(type, model, speed, range, price);
					ParkingLot.add(j);
				} else if (line.contains("Luxury")) {
					LuxuryPlane j = new LuxuryPlane(type, model, speed, range, price);
					ParkingLot.add(j);

				} else {
					System.out.println("This vehicle is not a jet or luxury plane");
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
		System.out.println("The jets in the hanger are\n " +  ParkingLot);
		for (jet jet : ParkingLot) {
			System.out.println(ParkingLot);
		}

	}
	
	
	
	public  void flyAll() {

		for (jet jet : ParkingLot) {
			double timeLeft = jet.getRange() / jet.getSpeed();
			double roundOff = Math.round(timeLeft * 100) / 100;
			
			System.out.println(jet.fly() + "  is in the air" + " and has\n " + roundOff + " hours left in the air");
		}
	}

	

	public void fastestJet() {
		double fastest = 0;

		for (jet jet : ParkingLot) {
			if (jet.getSpeed() > fastest) {
				fastest = jet.getSpeed();

			}
		}
		for (jet jet2 : ParkingLot) {
			if (fastest == jet2.getSpeed()) {

				System.out.println(jet2.toString() + "can fly the fastest!");
			}

		}
	}

	public void longestRange() {
		double longestRange = 0;

		for (jet jet : ParkingLot) {
			if (jet.getRange() > longestRange) {
				longestRange = jet.getRange();

			}
		}

		for (jet jet2 : ParkingLot) {
			if (longestRange == jet2.getRange()) {

				System.out.println(jet2.toString() + " can fly the farthest!");
			}

		}

	}

	public void loadAll() {
		for (jet jet : ParkingLot) {
			if (jet instanceof CargoCarrier) {
				CargoCarrier.Loading();
				System.out.println(jet.toString());
				

			}

		}
	}


	public void fightAll() {
		for (jet jet : ParkingLot) {
			if (jet instanceof CombatReady) {
				System.out.println(jet.toString());
				CombatReady.dogFight();
			}

			if (jet instanceof LoadingBombs) {
				LoadingBombs.bombsAway();
			}
		}

	}

	public void addJet() {

		Scanner kb = new Scanner(System.in);

		System.out.println("Please enter a jet type from Fighter, Cargo, or Luxury: ");
		String type = kb.next();
		System.out.println("Enter a model: ");
		String model = kb.next();
		System.out.println("Enter in the max speed:");
		double speed = kb.nextDouble();
		System.out.println("Enter a range :");
		int range = kb.nextInt();
		System.out.println("How much is the plane worth?");
		long price = kb.nextLong();

		if (type.contains("Fighter")) {
			jet j = new Fighter(type, model, speed, range, price);
			ParkingLot.add(j);
		}

		else if (type.contains("Cargo")) {
			CargoPlane j = new CargoPlane(type, model, speed, range, price);
			ParkingLot.add(j);
		} else if (type.contains("Luxury")) {
			LuxuryPlane j = new LuxuryPlane(type, model, speed, range, price);
			ParkingLot.add(j);

		} else {
			System.out.println("This vehicle is not a jet or luxury plane");
		}
	}

	public void removeJet() {
		Scanner kb = new Scanner(System.in);

		{

			for (int i = 0; i < ParkingLot.size(); i++) {
				System.out.println((i + 1) + " " + ParkingLot.get(i).getModel());
			}
			int choice = kb.nextInt();

			if (choice != ParkingLot.size()) {
				System.out.println("Beg your pardon, I don't know what you intended sir. ");
			} else {

				ParkingLot.remove(choice - 1);
				System.out.println("New inventory: ");
				for (jet jet : ParkingLot) {

					System.out.println(jet);

				}

			}

		}

	}

}
