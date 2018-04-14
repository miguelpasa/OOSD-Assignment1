package controller;

public class MainController {

	public static void main(String[] args) {
		GameThread game = new GameThread();
		Thread t = new Thread(game);
		t.start();
	}
}
