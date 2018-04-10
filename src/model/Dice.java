package model;

import java.util.Random;

public class Dice {
	
	int currentValue = 0;
	
	public Dice() {
		this.currentValue = 1;
	}
	
	public int roll() {
		Random random = new Random();
		this.currentValue = random.nextInt(5) + 1;
		return this. currentValue;
	}
}