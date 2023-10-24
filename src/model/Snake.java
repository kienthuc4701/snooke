package model;

import java.awt.Point;
import java.util.ArrayList;

public interface Snake {
	public void move();

	public boolean intersects(Point position);

	public void eatFood(Food food);

	public boolean checkCollision();

	public boolean collidesWith(Food food);

	public ArrayList<Point> getBody();

	public void setBody(ArrayList<Point> body);

	public Point getHead();

	public void setHead(Point head);

	public int getDirection();

	public void setDirection(int direction);

	public int getInitialSize();

	public void setInitialSize(int initialSize);

	public double getSpeed();

//	public double getSpeed() {
//		return speed;
//	}
//
//	public void setSpeed(int speed) {
//		this.speed = speed;
//	}
//
//	public ArrayList<Point> getBody() {
//		return body;
//	}
//
//	public void setBody(ArrayList<Point> body) {
//		this.body = body;
//	}
//
//	public Point getHead() {
//		return head;
//	}
//
//	public void setHead(Point head) {
//		this.head = head;
//	}
//
//	public int getDirection() {
//		return direction;
//	}
//
//	public void setDirection(int direction) {
//		this.direction = direction;
//	}
//
//	public int getInitialSize() {
//		return initialSize;
//	}
//
//	public void setInitialSize(int initialSize) {
//		this.initialSize = initialSize;
//	}
//
//	public void setSpeed(double speed) {
//		this.speed = speed;
//	}
//
//	public void eatFood(Food food) {
//		// Logic for eating food
//		Point tail = body.get(body.size() - 1);
//		body.add(tail);
//	}
//
//	public boolean checkCollision() {
//		for (int i = 1; i < body.size(); i++) {
//			if (body.get(0).equals(body.get(i))) {
//				System.out.println("true");
//				return true;
//			}
//		}
//		return false;
//	}
//
//	
//
//	public boolean collidesWith(Food food) {
//		return body.get(0).equals(food.getPosition());
//	}
//
//	@Override
//	public String toString() {
//		return "Snake [body=" + body + ", head=" + head + ", direction=" + direction + ", initialSize=" + initialSize
//				+ ", speed=" + speed + "]";
//	}
//
//	public boolean intersects(Point postion) {
//		for (Point part : body) {
//			if (part.equals(postion)) {
//				return true;
//			}
//		}
//		return false;
//	}
}
