package model.piece;

public interface Piece {
	//dependency on player
	
	void move();
	
	void capture(Piece piecetoCapture);
	
	int getRow();
	
	int getColumn();
	
	String getPieceType();
}
