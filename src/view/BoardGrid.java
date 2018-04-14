package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardGrid extends JPanel {

	private static final int BOARD_COLUMNS = 5;
	private static final int BOARD_ROWS = 5;

	ArrayList<ArrayList<JLabel>> panelHolder = new ArrayList<ArrayList<JLabel>>();

	public BoardGrid() {
		this.setLayout(new GridLayout(BOARD_COLUMNS, BOARD_ROWS));
		int counter = 0;
		for (int i = 0; i < BOARD_ROWS; i++) {
			ArrayList<JLabel> panelRow = new ArrayList<JLabel>();
			for (int j = 0; j < BOARD_COLUMNS; j++) {
				if (counter++ % 2 == 0) {
					JLabel label = new JLabel("");
					label.setHorizontalTextPosition(SwingConstants.CENTER);
					label.setVerticalTextPosition(SwingConstants.CENTER);
					label.setBackground(Color.GREEN);
					label.setOpaque(true);
					panelRow.add(label);
					this.add(label);
				} else {
					JLabel label = new JLabel("");
					label.setHorizontalTextPosition(SwingConstants.CENTER);
					label.setVerticalTextPosition(SwingConstants.CENTER);
					label.setBackground(Color.BLUE);
					label.setOpaque(true);
					panelRow.add(label);
					this.add(label);
				}
			}
			panelHolder.add(panelRow);
		}
		this.setVisible(true);
	}

	public void clearAllTileText() {
		for (int i = 0; i < BOARD_ROWS; i++) {
			for (int j = 0; j < BOARD_COLUMNS; j++) {
				panelHolder.get(i).get(j).setText("");
			}
		}
	}

	public void changeTileText(int row, int column, String text) {
		String previousText = panelHolder.get(row).get(column).getText();

		if (previousText.equals("")) {
			panelHolder.get(row).get(column).setText(text);
		} else {
			panelHolder.get(row).get(column).setText(previousText + " " + text);
		}
	}
}
