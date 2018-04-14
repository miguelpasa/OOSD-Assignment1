//----------------------------------------------------------
//Blue Piece 3 : Jellyfish
//----------------------------------------------------------
//Poisons opposing pieces causing them to move only half of what's on the dice. Standard dice movement
//----------------------------------------------------------

package model.piece.ocean;

import java.util.ArrayList;

import model.Dice;
import model.SquareBoard;
import model.piece.Piece;
import model.tile.OceanTile;
import model.tile.Tile;

public class JellyfishPiece implements Piece {

	int pieceColumn;
	int pieceRow;
	SquareBoard board;
	
	public JellyfishPiece(int startColumn, int startRow, SquareBoard board) {
		this.pieceColumn = startColumn;
		this.pieceRow = startRow;
		this.board = board;
	}

	@Override
	public void move() {
		int toMove = Dice.getSingletoneDice().roll();

		for (int i = 0; i < toMove; i++) {
			if (this.pieceColumn < 4) {
				this.pieceColumn++;
			} else {
				this.pieceRow--;
				this.pieceColumn = 0;
			}
		}
		
		System.out.println("dice was: " + toMove + ". eel moved to " + this.pieceRow + " " + this.pieceColumn);

		
//		ArrayList<ArrayList<Tile>> tileArray = this.board.getTileArray();
//		Tile currentTile = tileArray.get(this.pieceRow).get(pieceColumn);
//		
//		if(currentTile instanceof OceanTile) {
//			((OceanTile)tileArray.get(this.pieceRow).get(pieceColumn)).setPoisoned(true);
//		}
	}

	@Override
	public void capture(Piece piecetoCapture) {
		// TODO Auto-generated method stub

	}
	
	public int getRow() {
		return this.pieceRow;
	}

	public int getColumn() {
		return this.pieceColumn;
	}

	@Override
	public String getPieceType() {
		return "jellyfish";
	}
}
