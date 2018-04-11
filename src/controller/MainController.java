package controller;

import java.util.ArrayList;

import model.Player;
import model.SquareBoard;

public class MainController {

	public static void main(String[] args) {
		
		//initialising game elements
		SquareBoard board = new SquareBoard();
		
		Player playerOne = new Player("Miguel", false, board); //jungle
		Player playerTwo = new Player("Nasrin", true, board); //ocean
		ArrayList<Player> playerArray = new ArrayList<Player>();
		playerArray.add(playerOne);
		playerArray.add(playerTwo);
		
		//initialise Board
		//initialise Players
		//set currentPlayer as first player
		
		//while loop until a player has reach the end
		//Player 1 picks their colour, and P	layer 2 gets the other colour
		//take current player's turn
		//switch currentPlayer to other player
	}
}
