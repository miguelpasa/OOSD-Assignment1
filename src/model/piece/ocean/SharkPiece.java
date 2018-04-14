//----------------------------------------------------------
//Blue Piece 2 : Shark
//----------------------------------------------------------
//Gets movement from dolphin and thats added to whatever it rolls on the dice.
//It can kill the lion only, and can be killed by the lion only.
//----------------------------------------------------------

package model.piece.ocean;

import model.Dice;
import model.SquareBoard;
import model.piece.Piece;

public class SharkPiece implements Piece {
	
	int movementFromDolphin = 7;
	int pieceColumn;
	int pieceRow;
	SquareBoard board;

	public SharkPiece(int startColumn, int startRow, SquareBoard board) {
		this.pieceColumn = startColumn;
		this.pieceRow = startRow;
		this.board = board;
	}

	@Override
	public void move() {
		int toMove = Dice.getSingletoneDice().roll();
		
		//will only start if dolphin piece moved before shark piece
		if(movementFromDolphin < 6) { 
			toMove = toMove + movementFromDolphin;
		}
		
		for(int i = 0; i < toMove; i++) {
			if(this.pieceColumn < 4) {
				this.pieceColumn++;
			} else {
				this.pieceRow--;
				this.pieceColumn = 0;
			}
			
		}
	}

	@Override
	public void capture(Piece piecetoCapture) {
		// TODO Auto-generated method stub
	}
	
	public void setMovementFromDolphin(int movement) {
		this.movementFromDolphin = movement;
	}

	public int getRow() {
		return this.pieceRow;
	}

	public int getColumn() {
		return this.pieceColumn;
	}

	@Override
	public String getPieceType() {
		return "shark";
	}
}
