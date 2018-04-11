//----------------------------------------------------------
//Blue Piece 4: Electric Eel
//----------------------------------------------------------
//Shocks opposing pieces causing them to miss one turn. Standard dice movement
//----------------------------------------------------------

package model.piece.ocean;

import java.util.ArrayList;

import model.SquareBoard;
import model.DiceSingleton;
import model.piece.Piece;
import model.tile.OceanTile;
import model.tile.Tile;

public class ElectricEelPiece implements Piece {

	private int pieceColumn;
	private int pieceRow;
	private SquareBoard board;
	
	public ElectricEelPiece(int startColumn, int startRow, SquareBoard board) {
		this.pieceColumn = startColumn;
		this.pieceRow = startRow;
		this.board = board;
	}
	
	@Override
	public void move() {
		int toMove = DiceSingleton.getDice().roll();

		for (int i = 0; i < toMove; i++) {
			if (this.pieceColumn < 4) {
				this.pieceColumn++;
			} else {
				this.pieceRow--;
				this.pieceColumn = 0;
			}
		}

		ArrayList<ArrayList<Tile>> tileArray = this.board.getTileArray();
		Tile currentTile = tileArray.get(this.pieceRow).get(pieceColumn);
		
		if(currentTile instanceof OceanTile) {
			((OceanTile)tileArray.get(this.pieceRow).get(pieceColumn)).setShocked(true);
		}
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
		return "eel";
	}

}
