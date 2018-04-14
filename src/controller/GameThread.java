package controller;

import java.util.ArrayList;

import model.Player;
import view.MainFrame;

public class GameThread implements Runnable {
	
	private static String selectedPiece = "";
	private static Object monitor = new Object();

	@Override
	public void run() {

		//initialising game elements
		BoardController boardController = new BoardController();
		boardController.createBoard();
		
		//initialising view
		MainFrame view = new MainFrame(boardController.getBoardGrid(), boardController.getChoicePanel());
		
		//player array created for turn taking and switching
		ArrayList<Player> playerArray = new ArrayList<Player>();
		playerArray.add(new Player("Miguel", false, boardController.getSquareBoard())); //jungle
		playerArray.add(new Player("Nasrin", true, boardController.getSquareBoard())); //ocean
		
		boardController.getSquareBoard().setJunglePieces(playerArray.get(0).getPieceArray());
		boardController.getSquareBoard().setOceanPieces(playerArray.get(1).getPieceArray());
		
		Game game = new Game();
		int playerTurnCounter = 0;
		
		while(!game.isFinished()) {
			//ask player which piece they want to move (from view)
			//takeTurn() function requires the name of the piece the player wants to move e.g. "lion"
			boardController.updatePiecePositionsOnBoard();
			
			String toMove = "";
			int index = playerTurnCounter++ % 2;
			boardController.setPlayer(index == 1);

			synchronized(monitor) {
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				toMove = this.selectedPiece;
			}
			
			playerArray.get(index).takeTurn(toMove);
			boardController.updatePiecePositionsOnBoard();
		}
	}
	
	public static void setSelectedPiece(String piece) {
		selectedPiece = piece;
	}
	
	public static Object getThreadMonitor() {
		return monitor;
	}

}
