package algorithm;

import java.util.Random;

public enum Move implements GAConstants {

	UP(0), DOWN(1), LEFT(2), RIGHT(3);

	public final int direction;
	private Random random = new Random();

	private Move(int direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		switch (direction) {
			case 0:
				return "UP";
			case 1:
				return "DOWN";
			case 2:
				return "LEFT";
			case 3:
				return "RIGHT";
			default:
				return "UNDEFINED";
		}
	}

}
