package controller;

import model.SquareBoard;
import model.piece.Piece;
import view.BoardGrid;
import view.PieceChoicePanel;

public class BoardController {

	private SquareBoard board;
	private BoardGrid boardGrid;
	private PieceChoicePanel choicePanel;

	public void createBoard() {
		boardGrid = new BoardGrid();
		board = new SquareBoard();
		choicePanel = new PieceChoicePanel();
		updatePiecePositionsOnBoard();
	}

	public void updatePiecePositionsOnBoard() {
		boardGrid.clearAllTileText();
		for (Piece piece : board.getJunglePieces()) {
			int pieceRow = piece.getRow();
			int pieceColumn = piece.getColumn();

			boardGrid.changeTileText(pieceRow, pieceColumn, piece.getPieceType());
			boardGrid.revalidate();
			boardGrid.repaint();
		}

		for (Piece piece : board.getOceanPieces()) {
			int pieceRow = piece.getRow();
			int pieceColumn = piece.getColumn();

			boardGrid.changeTileText(pieceRow, pieceColumn, piece.getPieceType());
			boardGrid.revalidate();
			boardGrid.repaint();
		}
	}
	
	public void setPlayer(boolean isBlue) {
		this.choicePanel.updatePieceChoiceButtons(isBlue);
	}

	public SquareBoard getSquareBoard() {
		return this.board;
	}

	public BoardGrid getBoardGrid() {
		return this.boardGrid;
	}
	
	public PieceChoicePanel getChoicePanel() {
		return this.choicePanel;
	}
}
