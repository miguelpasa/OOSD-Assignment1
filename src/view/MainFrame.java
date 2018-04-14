package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.SquareBoard;

public class MainFrame extends JFrame{
	
	public MainFrame(BoardGrid boardGrid, PieceChoicePanel choicePanel) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 600, 600);
		
		JButton buttonTop = new JButton("Ocean Jungle Game");
		buttonTop.setPreferredSize(new Dimension(600,50));
		this.add(buttonTop, BorderLayout.PAGE_START);
		
		this.add(boardGrid, BorderLayout.CENTER);
		
		this.add(choicePanel, BorderLayout.PAGE_END);
		
		this.setVisible(true);
	}
}
