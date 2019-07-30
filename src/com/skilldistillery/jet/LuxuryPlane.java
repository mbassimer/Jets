package com.skilldistillery.jet;

public class LuxuryPlane extends jet {

	public LuxuryPlane(String Type, String Model, double speed, int range, long price) {
		super(Type, Model, speed, range, price);

	}

	public String fly() {

		return ("We're taking off to cruise at a low speed, ready for picturesque views");
	}

}
