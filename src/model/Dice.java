package model;

import java.util.Random;

public class Dice {
	
	private static Dice singletoneDice;
	
	private Dice() {
		}
	
	public static Dice getSingletoneDice(){
		if(singletoneDice != null){
			return singletoneDice;
		}
		else return (new Dice());
	}
	
	public int roll() {
		Random random = new Random();
		return random.nextInt(5) + 1;
	}
}