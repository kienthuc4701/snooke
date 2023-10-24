package view;

import javax.swing.JFrame;

public class TestDriven {
	public static void main(String[] args) {
		GameBoard game = new GameBoard();
		JFrame frame = new JFrame("Snake Game");
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
