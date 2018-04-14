package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GameThread;

public class PieceChoicePanel extends JPanel{
	
	ArrayList<JButton> buttonArray = new ArrayList<JButton>();

	public PieceChoicePanel() {
		this.setLayout(new GridLayout(1, 4));
		this.setPreferredSize(new Dimension(600,100));
		
		for(int i = 0; i < 4; i++) {
			JButton button = new JButton("");
			addActionListenerToPieceChoice(button);
			buttonArray.add(button);
			this.add(button);
		}
	}
	
	public void updatePieceChoiceButtons(boolean isBlue) {
		if(isBlue) { //ocean player
			buttonArray.get(0).setText("Dolphin");
			buttonArray.get(1).setText("Eel");
			buttonArray.get(2).setText("Jellyfish");
			buttonArray.get(3).setText("Shark");
		} else { //forest player
			buttonArray.get(0).setText("Dog");
			buttonArray.get(1).setText("Lion");
			buttonArray.get(2).setText("Rabbit");
			buttonArray.get(3).setText("Turtle");
		}
	}
	
	private void addActionListenerToPieceChoice(JButton button) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				synchronized(GameThread.getThreadMonitor()) {
					GameThread.setSelectedPiece(button.getText().toLowerCase());
					GameThread.getThreadMonitor().notify();
				}
			}
		});
	}
}

