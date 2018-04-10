//----------------------------------------------------------
//Green Piece 1 : Turtle
//----------------------------------------------------------
//Only moves when 1 or 6 is rolled
//Once on last row and 6 is rolled then advances to finish 
//----------------------------------------------------------

package model.piece.jungle;

import model.DiceSingleton;
import model.piece.Piece;

public class TurtlePiece implements Piece {

	int pieceColumn;
	int pieceRow;

	public TurtlePiece(int startColumn, int startRow) {
		this.pieceColumn = startColumn;
		this.pieceRow = startRow;
	}

	@Override
	public void move() {
		int diceRoll = DiceSingleton.getDice().roll();

		if (diceRoll == 1) {
			if (this.pieceRow > 0) {
				this.pieceRow--;
			}
		} else if (diceRoll == 6) {
			if (this.pieceRow < 5) {
				this.pieceRow++;
			}
		}
	}

	@Override
	public void capture(Piece piecetoCapture) {
		// TODO Auto-generated method stub

	}
}
