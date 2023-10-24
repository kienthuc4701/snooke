package model;

import java.awt.Point;
import java.util.List;
import java.util.Random;

public class Food {
	@Override
	public String toString() {
		return "Food [position=" + position + "]";
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	private Point position;

	public Food(int x, int y, int initialSize) {
		position = new Point(x, y);
	}

	public Food() {

	}

	public void generateFood(List<Point> validFoodPositions) {
		if (!validFoodPositions.isEmpty()) {
			Random random = new Random();
			int index = random.nextInt(validFoodPositions.size());
			position = validFoodPositions.get(index);
		}
	}
}
