package controller;

import java.util.ArrayList;

import model.Player;

public class MainController {

	public static void main(String[] args) {
		
		//initialising game elements
		BoardController boardController = new BoardController();
		
		Player playerOne = new Player("Miguel", false, boardController.getBoard()); //jungle
		Player playerTwo = new Player("Nasrin", true, boardController.getBoard()); //ocean
		
		
		Game game = new Game(playerOne, playerTwo);
		game.start();
		
		//initialise Board
		//initialise Players
		//set currentPlayer as first player
		
		//while loop until a player has reach the end
		//Player 1 picks their colour, and P	layer 2 gets the other colour
		//take current player's turn
		//switch currentPlayer to other player
	}
}
