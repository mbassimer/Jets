package com.skilldistillery.jet;

public abstract class Jet {
	
	private String Type;
	private String Model;
	private double speed;
	private int range;
	private long price;

	protected Jet(String Type,String Model, double speed, int range, long price) {
		this.Type = Type;
		this.Model = Model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet [Type=").append(Type).append(", Model=").append(Model).append(", speed=").append(speed)
				.append(", range=").append(range).append(", price=").append(price).append("]");
		return builder.toString();
	}
	
	



}