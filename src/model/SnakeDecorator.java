package model;

public abstract class SnakeDecorator implements Snake {
	protected Snake snake;
	protected double speed;

	public SnakeDecorator(Snake snake) {
		this.snake = snake;
	}

	protected abstract void setSpeed();

}
