package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.piece.Piece;
import model.piece.jungle.DogPiece;
import model.piece.jungle.LionPiece;
import model.piece.jungle.RabbitPiece;
import model.piece.jungle.TurtlePiece;
import model.piece.ocean.DolphinPiece;
import model.piece.ocean.ElectricEelPiece;
import model.piece.ocean.JellyfishPiece;
import model.piece.ocean.SharkPiece;

public class Player {
	//dependency on Piece
	
	private String playerName;
	private boolean playerColorIsBlue;
	private Map<String, Piece> pieceArray = new HashMap<String, Piece>();
	private SquareBoard board;
	
	public Player(String name, boolean isBlue, SquareBoard board) {
		this.playerName = name;
		this.playerColorIsBlue = isBlue;
		
		//creating the pieces for each player, based on the player's color
		if(!isBlue) {
			pieceArray.put("dog", new DogPiece(0,0, board));
			pieceArray.put("lion", new LionPiece(0,1, board));
			pieceArray.put("rabbit", new RabbitPiece(0, 2, board));
			pieceArray.put("turtle", new TurtlePiece(0, 3, board));
		} else {
			pieceArray.put("dolphin", new DolphinPiece(5, 0, board));
			pieceArray.put("eel", new ElectricEelPiece(5, 1, board));
			pieceArray.put("jellyfish", new JellyfishPiece(5, 2, board));
			pieceArray.put("shark", new SharkPiece(5, 3, board));
		}
	}
	
	//@param pieceName the identifier for the piece e.g. "dog" or "dolphin"
	public void takeTurn(String pieceName) {
		Iterator it = this.pieceArray.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Piece> pair = (Map.Entry<String, Piece>)it.next();
			if(pair.getKey().equals(pieceName)) {
				pair.getValue().move();
			}
			it.remove();
		}
	}
}