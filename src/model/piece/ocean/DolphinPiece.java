//----------------------------------------------------------
//Blue Piece 1 : Dolphin
//----------------------------------------------------------
//Only moves 1 and gives the rest to shark
//----------------------------------------------------------

package model.piece.ocean;

import model.Dice;
import model.SquareBoard;
import model.piece.Piece;

public class DolphinPiece implements Piece {

	int pieceColumn;
	int pieceRow;
	SquareBoard board;
	SharkPiece sharkPieceLink = null;

	public DolphinPiece(int startColumn, int startRow, SquareBoard board) {
		this.pieceColumn = startColumn;
		this.pieceRow = startRow;
		this.board = board;
	}

	@Override
	public void move() {
		int toGiveToShark = Dice.getSingletoneDice().roll();;
		this.sharkPieceLink.setMovementFromDolphin(toGiveToShark);

		if (this.pieceColumn < 4) {
			this.pieceColumn++;
		} else {
			this.pieceRow--;
			this.pieceColumn = 0;
		}
		
		System.out.println("dice was: " + 1 + ". dolphin moved to " + this.pieceRow + " " + this.pieceColumn);

	}

	@Override
	public void capture(Piece piecetoCapture) {
		// TODO Auto-generated method stub

	}

	public void setSharkLink(SharkPiece shark) {
		this.sharkPieceLink = shark;
	}
	
	public int getRow() {
		return this.pieceRow;
	}

	public int getColumn() {
		return this.pieceColumn;
	}

	@Override
	public String getPieceType() {
		return "dolphin";
	}

}
