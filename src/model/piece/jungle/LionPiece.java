//----------------------------------------------------------
//Green Piece 3: Lion
//----------------------------------------------------------
//standard dice movement | kills everyone else, only weakness is the shark
//----------------------------------------------------------

package model.piece.jungle;

import model.DiceSingleton;
import model.piece.Piece;

public class LionPiece implements Piece {

	int pieceColumn;
	int pieceRow;

	public LionPiece(int startColumn, int startRow) {
		this.pieceColumn = startColumn;
		this.pieceRow = startRow;
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

}
