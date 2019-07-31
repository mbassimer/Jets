package com.skilldistillery.jet;

import java.util.Scanner;

public class JetsApp {
	Scanner kb = new Scanner(System.in);
	Airfield airfield = new Airfield();

	public static void main(String[] args) {
		JetsApp jetsapp = new JetsApp();
		jetsapp.Launch();
	}

	public JetsApp() {

	}

	public void Launch() {
		Menu();

	}

	public void Menu() {
		System.out.println("Welcome please look at our hangar");
		InfoGraphic();

		boolean setMenu = true;
		int userChoice = 0;

		while (userChoice != 9) {

			System.out.println("Please enter a choice from our menu");
			userChoice = kb.nextInt();

			switch (userChoice) {
			case 1:
				airfield.displayAll();
				break;
			case 2:
				airfield.flyAll();
				break;
			case 3:
				airfield.fastestJet();
				break;
			case 4:
				airfield.longestRange();
				break;
			case 5:
				airfield.loadAll();
				break;
			case 6:
				airfield.fightAll();
				break;
			case 7:
				airfield.addJet();
				break;
			case 8:
				airfield.removeJet();
				break;
			case 9:
				userChoice = 9;
				setMenu = false;

				System.out.println("Thank you for visiting the Jet Selector");
				break;

			default:
				System.out.println("That is not an option, sorry! :( ");
			}
			
			if (setMenu != false) {
				InfoGraphic();
			}
		}
	}
	
	

	public void InfoGraphic() {
		System.out.println("*****************************************");
		System.out.println("*       	Vehicle Selector	*");
		System.out.println("*                                    	*");
		System.out.println("*  Please choose from our selection   	*");
		System.out.println("*                                    	*");
		System.out.println("*         1)List Fleet          	*");
		System.out.println("*         2)Fly the fighters           	*");
		System.out.println("*         3)View Fastest Vehicles       *");
		System.out.println("*         4)View Jet with longest range *");
		System.out.println("*         5)Load All Cargo Jets  	*");
		System.out.println("*         6)DogFight!          		*");
		System.out.println("*         7)Add a jet to Fleet         	*");
		System.out.println("*         8)Remove a jet from fleet     *");
		System.out.println("*         9)Exit    			*");
		System.out.println("*****************************************");
		System.out.println("*****************************************");
	}

}
