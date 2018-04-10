//----------------------------------------------------------
//Green Piece 4: Rabbit
//----------------------------------------------------------
//Can move double the dice
//----------------------------------------------------------


package model.piece.jungle;

import model.DiceSingleton;
import model.piece.Piece;

public class RabbitPiece implements Piece {

	int pieceColumn;
	int pieceRow;

	public RabbitPiece(int startColumn, int startRow) {
		this.pieceColumn = startColumn;
		this.pieceRow = startRow;
	}

	@Override
	public void move() {
		int diceRoll = DiceSingleton.getDice().roll();
		
		int toMove = diceRoll*2;
		
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

}