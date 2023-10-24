package model;

import java.awt.Point;

public class Obstacle {
	private Point position;

	public Obstacle(int x, int y, int initialSize) {
		position = new Point(x, y);
	}

	public void generateObstacle() {
		// Logic for generating new obstacle at a random position
	}
}
