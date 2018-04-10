//----------------------------------------------------------
//Blue Piece 3 : Jellyfish
//----------------------------------------------------------
//Poisons opposing pieces causing them to move only half of what's on the dice. Standard dice movement
//----------------------------------------------------------

package model.piece.ocean;

import java.util.ArrayList;

import model.Board;
import model.DiceSingleton;
import model.piece.Piece;
import model.tile.OceanTile;
import model.tile.Tile;

public class JellyfishPiece implements Piece {

	int pieceColumn;
	int pieceRow;
	Board board;
	
	public JellyfishPiece(int startColumn, int startRow, Board board) {
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
				this.pieceRow++;
				this.pieceColumn = 0;
			}
		}
		
		ArrayList<ArrayList<Tile>> tileArray = this.board.getTileArray();
		Tile currentTile = tileArray.get(this.pieceRow).get(pieceColumn);
		
		if(currentTile instanceof OceanTile) {
			((OceanTile)tileArray.get(this.pieceRow).get(pieceColumn)).setPoisoned(true);
		}
	}

	@Override
	public void capture(Piece piecetoCapture) {
		// TODO Auto-generated method stub

	}
}
