//----------------------------------------------------------
//Blue Piece 1 : Dolphin
//----------------------------------------------------------
//Only moves 1 and gives the rest to shark
//----------------------------------------------------------

package model.piece.ocean;

import model.DiceSingleton;
import model.piece.Piece;

public class DolphinPiece implements Piece {

	int pieceColumn;
	int pieceRow;
	SharkPiece sharkPieceLink = null;

	public DolphinPiece(int startColumn, int startRow) {
		this.pieceColumn = startColumn;
		this.pieceRow = startRow;
	}

	@Override
	public void move() {
		int toGiveToShark = DiceSingleton.getDice().roll() - 1;
		this.sharkPieceLink.setMovementFromDolphin(toGiveToShark);

		if (this.pieceColumn < 4) {
			this.pieceColumn++;
		} else {
			this.pieceRow++;
			this.pieceColumn = 0;
		}
	}

	@Override
	public void capture(Piece piecetoCapture) {
		// TODO Auto-generated method stub

	}

	public void setSharkLink(SharkPiece shark) {
		this.sharkPieceLink = shark;
	}

}
