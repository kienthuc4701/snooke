package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameOverMenu extends JPanel {
	private JButton restartButton;
	private JButton exitButton;

	public GameOverMenu() {
		setLayout(new GridLayout(2, 1));

		restartButton = new JButton("Restart");
		exitButton = new JButton("Exit");

		add(restartButton);
		add(exitButton);

		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Handle restart button click (e.g., restart the game)
			}
		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public void showMenu() {
		setVisible(true);
	}

	public void hideMenu() {
		setVisible(false);
	}
}