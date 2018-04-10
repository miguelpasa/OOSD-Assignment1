package model;

import java.util.ArrayList;

import model.tile.JungleTile;
import model.tile.OceanTile;

// BOARD TILE NUMBER LAYOUT
// 40 41 42 43 44
// 30 31 32 33 34 
// 20 21 22 23 24
// 10 11 12 13 14
// 00 01 02 03 04

import model.tile.Tile;

public class Board {

	private ArrayList<ArrayList<Tile>> tileArray = new ArrayList<ArrayList<Tile>>();

	public Board() {
		int counter = 0;
		for (int i = 0; i < 5; i++) {
			ArrayList<Tile> tileArrayRow = new ArrayList<Tile>();
			for (int j = 0; j < 5; j++) {
				if (counter++ % 2 == 0) {
					tileArrayRow.add(new JungleTile(i, j));
				} else {
					tileArrayRow.add(new OceanTile(i, j));	
				}
			}
		}
	}
	
	public ArrayList<ArrayList<Tile>> getTileArray() {
		return this.tileArray;
	}
}
