//----------------------------------------------------------
//Green Piece 3: Lion
//----------------------------------------------------------
//standard dice movement | kills everyone else, only weakness is the shark
//----------------------------------------------------------

package model.piece.jungle;

import model.DiceSingleton;
import model.SquareBoard;
import model.piece.Piece;

public class LionPiece implements Piece {

	int pieceColumn;
	int pieceRow;
	SquareBoard board;

	public LionPiece(int startColumn, int startRow, SquareBoard board) {
		this.pieceColumn = startColumn;
		this.pieceRow = startRow;
		this.board = board;
	}

	@Override
	public void move() {
		int diceRoll = DiceSingleton.getDice().roll();

		for (int i = 0; i < diceRoll; i++) {
			if (this.pieceColumn < 4) {
				this.pieceColumn++;
			} else {
				this.pieceRow++;
				this.pieceColumn = 0;
			}
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
		return "lion";
	}

}
