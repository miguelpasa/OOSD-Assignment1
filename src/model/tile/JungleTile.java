package model.tile;

public class JungleTile implements Tile {
	
	int number = 0;

	@Override
	public void setNumber(int numberToSet) {
		this.number = numberToSet;
	}

	@Override
	public int getNumber() {
		return number;
	}
}
