package model;

import java.util.ArrayList;
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
	private ArrayList<Piece> pieceArray = new ArrayList<Piece>();
	private SquareBoard board;
	
	public Player(String name, boolean isBlue, SquareBoard board) {
		this.playerName = name;
		this.playerColorIsBlue = isBlue;
		
		//creating the pieces for each player, based on the player's color
		if(!isBlue) {
			pieceArray.add(new DogPiece(0,0, board));
			pieceArray.add(new LionPiece(1,0, board));
			pieceArray.add(new RabbitPiece(2, 0, board));
			pieceArray.add(new TurtlePiece(3, 0, board));
		} else {
			DolphinPiece dolphin = new DolphinPiece(0, 4, board);
			SharkPiece shark = new SharkPiece(3, 4, board);
			pieceArray.add(dolphin);
			pieceArray.add(new ElectricEelPiece(1, 4, board));
			pieceArray.add(new JellyfishPiece(2, 4, board));
			pieceArray.add(shark);
			dolphin.setSharkLink(shark);
		}
	}
	
	//@param pieceName the identifier for the piece e.g. "dog" or "dolphin"
	public void takeTurn(String pieceName) {
		for(Piece piece : this.pieceArray) {
			if(piece.getPieceType().equals(pieceName)) {
				piece.move();
			}
		}
	}
	
	public String getName() {
		return this.playerName;
	}
	
	public ArrayList<Piece> getPieceArray() {
		return this.pieceArray;
	}
}