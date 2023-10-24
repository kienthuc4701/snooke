package model;

import java.awt.Point;

public class Enemy {
	private Point position;
	private int speed;

	public Enemy(int x, int y, int initialSize, int initialSpeed) {
		position = new Point(x, y);
		speed = initialSpeed;
	}

	public void move() {
		// Logic for moving the enemy
	}
}
