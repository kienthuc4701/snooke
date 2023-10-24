package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Food;
import model.Snake;
import model.SnakeNormal;

public class GameBoard extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	public static int screenWidth = 400;
	public static int screenHeight = 400;
	public static int cellSize = 20;
	private Snake snake;
	private Food food;

	private GameState gameState; // Enum to represent game state

	public GameBoard() {
		// Initialize game objects
		snake = new SnakeNormal(screenWidth / cellSize / 2, screenHeight / cellSize / 2);
		food = new Food(2, 2, cellSize);
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new GameKeyListener());

		Timer timer = new Timer(100, this);
		timer.start();

		gameState = GameState.RUNNING;
	}

	// Enum to represent game state
	private enum GameState {
		RUNNING, GAME_OVER, PAUSED
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateGame();
		repaint();
	}

	// Determine valid food positions
	private List<Point> getValidFoodPositions() {
		List<Point> validPositions = new ArrayList<>();
		// Calculate the game board boundaries
		int minX = 0;
		int minY = 0;
		int maxX = getWidth(); // The maximum X coordinate of the game board
		int maxY = getHeight(); // The maximum Y coordinate of the game board
		// Add all positions within the boundaries to the list of valid positions
		for (int x = minX; x < maxX / cellSize; x++) {
			for (int y = minY; y < maxY / cellSize; y++) {
				Point position = new Point(x, y);
				// Ensure the position is not occupied by the snake or obstacles
				if (!snake.intersects(position)) {
					validPositions.add(position);
				}
			}
		}
		return validPositions;
	}

	private void updateGame() {
		if (gameState == GameState.RUNNING) {
			snake.move();
		}
		if (snake.checkCollision() || isSnakeOutOfBounds()) {
			gameState = GameState.GAME_OVER;
		}
		if (snake.collidesWith(food)) {
			snake.eatFood(food);
			food.generateFood(getValidFoodPositions());
		}
	}

	private boolean isSnakeOutOfBounds() {
		int headX = snake.getBody().get(0).x; // Get the snake's head X position
		int headY = snake.getBody().get(0).y; // Get the snake's head Y position

		// Define the boundaries of the game board
		int minX = 0;
		int minY = 0;
		int maxX = getWidth(); // The maximum X coordinate of the game board
		int maxY = getHeight(); // The maximum Y coordinate of the game board

		// Check if the snake's head is outside the game board boundaries
		return headX < minX || headX >= maxX || headY < minY || headY >= maxY;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGameObjects(g);
	}

	private void drawGameObjects(Graphics g) {
		// Draw snake, food, obstacle, and enemy

		// Clear the screen by painting it with a background color
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, screenWidth, screenHeight);

		// Draw the Snake
		g.setColor(Color.GREEN);
		System.out.println(snake.getBody());

		for (Point bodyPart : snake.getBody()) {
			g.fillRect(bodyPart.x * cellSize, bodyPart.y * cellSize, cellSize, cellSize);
		}
		// Draw the Food
		g.setColor(Color.RED);
		g.fillRect(food.getPosition().x * cellSize, food.getPosition().y * cellSize, cellSize, cellSize);
	}

	private class GameKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (!isOppositeDirection(key)) {
				snake.setDirection(key);
			}
		}
	}

	private boolean isOppositeDirection(int newDirection) {
		// Define constants for directions
		int UP = KeyEvent.VK_UP;
		int RIGHT = KeyEvent.VK_RIGHT;
		int DOWN = KeyEvent.VK_DOWN;
		int LEFT = KeyEvent.VK_LEFT;

		// Check if the new direction is the opposite of the current direction
		return (newDirection == UP && snake.getDirection() == DOWN)
				|| (newDirection == RIGHT && snake.getDirection() == LEFT)
				|| (newDirection == DOWN && snake.getDirection() == UP)
				|| (newDirection == LEFT && snake.getDirection() == RIGHT);
	}
}
