package com.skilldistillery.jet;

import java.io.*;
import java.util.*;

public class Airfield {

	String file = "Jets.txt";
	List<Jet> ParkingLot;
	String line;

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

				else if (line.contains("Cargo")) {
					CargoPlane j = new CargoPlane(type, model, speed, range, price);
					ParkingLot.add(j);
				} else if (line.contains("Luxury")) {
					LuxuryPlane j = new LuxuryPlane(type, model, speed, range, price);
					ParkingLot.add(j);

				} else {
					System.out.println("This vehicle is not a jet/cargo or luxury plane");
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
		for (Jet jet : ParkingLot) {
			System.out.println(jet.getModel());
		}
	}

	public void flyAll() {

		for (Jet jet : ParkingLot) {
			double timeLeft = jet.getRange() / jet.getSpeed();
			double roundOff = Math.round(timeLeft * 100) / 100;

			System.out.println(jet.getModel() + jet.fly());
			System.out.println(" and can stay in the air for\n " + roundOff + "hrs");
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

				System.out.println(jet2.getModel() + " can fly the fastest!");
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

				System.out.println(jet2.getModel() + " can fly the farthest!");
			}

		}

	}

	public void loadAll() {
		for (Jet jet : ParkingLot) {
			if (jet instanceof CargoCarrier) {
				System.out.println(jet.getModel());
				CargoCarrier.Loading();

			}

		}
	}

	public void fightAll() {
		for (Jet jet : ParkingLot) {
			if (jet instanceof CombatReady) {
				System.out.println(jet.getModel());
				CombatReady.dogFight();
			}

			if (jet instanceof LoadingBombs) {
				LoadingBombs.bombsAway();
			}
		}

	}

	public void addJet(Scanner kb) {

		try {
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
				Jet j = new Fighter(type, model, speed, range, price);
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

		} catch (InputMismatchException exception) {
			System.out.println("This is not the correct type of input");
			if (exception != null) {
				addJet(kb);

			}
		}

	}

	public void removeJet(Scanner kb) {

		for (int i = 0; i < ParkingLot.size(); i++) {
			System.out.println((i + 1) + " " + ParkingLot.get(i).getModel());

		}
		int choice = kb.nextInt();
		
		
		
		if(choice <= ParkingLot.size()) {
			 Jet newParkingLot = (ParkingLot.remove(choice - 1));
			System.out.println("New inventory: ");
			for (Jet jet : ParkingLot) {
				System.out.println(jet.getModel());
		
		}
		}
//			if ( choice != ParkingLot.size()) {
//				
////				System.out.println("Beg your pardon, I don't know what you intended sir. ");
//				
//			}
//		
		
		
			
			
	  }

}


