package controller;

import model.SquareBoard;
import model.piece.Piece;

public class BoardController {
	
	private SquareBoard board;
	
	public void createBoard() {
		board = new SquareBoard();
	}
	
	public void updatePiecePositionsOnBoard() {
		for(Piece piece : board.getJunglePieces()) {
			int pieceRow = board.getJunglePieceLocations().get(piece.getPieceType()).getRow();
			int pieceColumn = board.getJunglePieceLocations().get(piece.getPieceType()).getColumn();
			
			//update the board view here
		}
	}
}
