package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.piece.Piece;
import model.tile.JungleTile;
import model.tile.OceanTile;

// BOARD TILE NUMBER LAYOUT
// 40 41 42 43 44
// 30 31 32 33 34 
// 20 21 22 23 24
// 10 11 12 13 14
// 00 01 02 03 04

import model.tile.Tile;

public class SquareBoard {

	private static final int SQUARE_BOARD_ROW_COLUMN_SIZE = 5;

	private ArrayList<Piece> junglePieces = new ArrayList<Piece>();
	private ArrayList<Piece> oceanPieces = new ArrayList<Piece>();
	private Map<Piece, Tile> junglePieceLocations = new HashMap<Piece, Tile>();
	private Map<Piece, Tile> oceanPieceLocations = new HashMap<Piece, Tile>();
	private ArrayList<ArrayList<Tile>> tileArray = new ArrayList<ArrayList<Tile>>();

	public SquareBoard() {
		int counter = 0;
		for (int i = 0; i < SQUARE_BOARD_ROW_COLUMN_SIZE; i++) {
			ArrayList<Tile> tileArrayRow = new ArrayList<Tile>();
			for (int j = 0; j < SQUARE_BOARD_ROW_COLUMN_SIZE; j++) {
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
	
	public ArrayList<Piece> getJunglePieces() {
		return this.junglePieces;
	}
	
	public ArrayList<Piece> getOceanPieces() {
		return this.oceanPieces;
	}
	
	public Map<Piece, Tile> getJunglePieceLocations() {
		return this.junglePieceLocations;
	}
	
	public Map<Piece, Tile> getOceanPieceLocations() {
		return this.oceanPieceLocations;
	}
	
	public void setJunglePieceLocations(Map<Piece, Tile> junglePieceLocationsParam) {
		this.junglePieceLocations = junglePieceLocationsParam;
	}
	
	public void setOceanPieceLocations(Map<Piece, Tile> oceanPieceLocationsParam) {
		this.oceanPieceLocations = oceanPieceLocationsParam;
	}
}
