package model;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SnakeNormal implements Snake {
	private ArrayList<Point> body;
	private Point head;
	private int direction;
	private int initialSize = 2;
	private double speed = 100;

	public SnakeNormal(int x, int y) {
		initBody(x, y);
	}

	@Override
	public String toString() {
		return "SnakeNormal [body=" + body + ", head=" + head + ", direction=" + direction + ", initialSize="
				+ initialSize + ", speed=" + speed + "]";
	}

	private void initBody(int x, int y) {
		body = new ArrayList<Point>();
		body.add(new Point(x, y));
	}

	@Override
	public void move() {
		// Logic for moving the snake
		Point newHead = new Point(body.get(0)); // Copy the current head
		// Check if the new direction is not opposite of the current direction
		switch (direction) {
		case KeyEvent.VK_UP: // Up
			newHead.y--;
			break;
		case KeyEvent.VK_RIGHT: // Right
			newHead.x++;
			break;
		case KeyEvent.VK_DOWN: // Down
			newHead.y++;
			break;
		case KeyEvent.VK_LEFT: // Left
			newHead.x--;
			break;
		}
		// Add the new head to the front of the body
		body.add(0, newHead);
		// Remove the tail to keep the snake's length constant
		body.remove(body.size() - 1);

	}

	@Override
	public boolean intersects(Point postion) {
		for (Point part : body) {
			if (part.equals(postion)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void eatFood(Food food) {
		// Logic for eating food
		Point tail = body.get(body.size() - 1);
		body.add(tail);
	}

	@Override
	public boolean checkCollision() {
		for (int i = 1; i < body.size(); i++) {
			if (body.get(0).equals(body.get(i))) {
				System.out.println("true");
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean collidesWith(Food food) {
		return body.get(0).equals(food.getPosition());
	}

	public ArrayList<Point> getBody() {
		return body;
	}

	public void setBody(ArrayList<Point> body) {
		this.body = body;
	}

	public Point getHead() {
		return head;
	}

	public void setHead(Point head) {
		this.head = head;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
