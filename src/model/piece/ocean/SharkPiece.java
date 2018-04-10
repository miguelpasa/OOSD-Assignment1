//----------------------------------------------------------
//Blue Piece 2 : Shark
//----------------------------------------------------------
//Gets movement from dolphin and thats added to whatever it rolls on the dice.
//It can kill the lion only, and can be killed by the lion only.
//----------------------------------------------------------

package model.piece.ocean;

import model.DiceSingleton;
import model.piece.Piece;

public class SharkPiece implements Piece {
	
	int movementFromDolphin = 7;
	int pieceColumn;
	int pieceRow;

	public SharkPiece(int startColumn, int startRow) {
		this.pieceColumn = startColumn;
		this.pieceRow = startRow;
	}

	@Override
	public void move() {
		int toMove = DiceSingleton.getDice().roll();
		
		//will only start if dolphin piece moved before shark piece
		if(movementFromDolphin < 6) { 
			toMove = toMove + movementFromDolphin;
		}
		
		for(int i = 0; i < toMove; i++) {
			if(this.pieceColumn < 4) {
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
	
	public void setMovementFromDolphin(int movement) {
		this.movementFromDolphin = movement;
	}

}
