package com.skilldistillery.jet;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String Type, String Model, double speed, int range, long price) {
		super(Type, Model, speed, range, price);

		

	}

	public String fly() {

		return("Taking off....I Think we are within the amount of maximum weight?");
	}

	public void loading() {

	}

}
