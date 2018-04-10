package model;

public class DiceSingleton {
	
	private static Dice dice;
	
	public DiceSingleton() {
		if(dice == null) {
			DiceSingleton.dice = new Dice();
		}
	}
	
	public static Dice getDice() {
		return dice;
	}

}
