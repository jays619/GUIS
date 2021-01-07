import java.util.Random;

import javax.swing.JPanel;

public class Point {
	private int X, Y, interval;
	private static Random rand; // We only need one instance of the random class
	private static int maxX, maxY; // All points will share the same Max X and Y;

	public static void setMaxX(int MaxX) {maxX = MaxX;}	
	public static void setMaxY(int MaxY) {maxY = MaxY;}	
	public static int getMaxX() {return maxX;}
	public static int getMaxY() {return maxY;}
	
	public int getX() {	return X; }
	public int getY() { return Y; }
	
	public Point(int interval) {
		this.interval = interval;
		
		if(rand == null) // Only until the first point is created, the random class is instanciated
			rand = new Random();
		
		X = rand.nextInt(maxX) + 1;
		Y = rand.nextInt(maxY) + 1;
	}
	
	public void moveDown() {
		if(Y < maxY)
			Y += interval;
		else {
			X = rand.nextInt(maxX);
			Y = 0;
		}
	}
	
	public void moveLeft() {
		if(X < maxX)
			X += interval;
		else {
			Y = rand.nextInt(maxY);
			X = 0;
		}
	}
	
	public void moveRight() {
		if(X < maxX)
			X -= interval;
		else {
			Y = rand.nextInt(maxY);
			X = 0;
		}
	}
	
	public void moveUp() {
		if(Y < maxY)
			Y -= interval;
		else {
			X = rand.nextInt(maxX);
			Y = 0;
		}
	}
	
	public void moveDownLeft() {
		moveDown();
		moveLeft();
	}
	
	public void moveDownRight() {
		moveDown();
		moveRight();
	}
	
	public void moveUpLeft() {
		moveUp();
		moveLeft();
		
	}
	
	public void moveUpRight() {
		moveUp();
		moveRight();
	}
}
