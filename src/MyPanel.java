import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel {
	public enum Direction {DOWN, UP, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT};
	
	
	public static final int MAX = 50;
	private Direction dir;
	private Timer timer;
	private Point stars[], suns[];
	private int curMouseX, curMouseY, prevMouseX, prevMouseY;
	
	public MyPanel() {
		createObjects();	
		this.addMouseMotionListener(new MouseHandler());
	}
	
	private void createObjects() {
		Handler hnd = new Handler();
		// Create array
		stars = new Point[MAX];
		suns = new Point[MAX / 3];
		for(int i = 0; i < MAX; i++) {
			stars[i] = new Point(1);
			if(i < MAX / 3)
				suns[i] = new Point(3 + (i % 2));
		}
		dir = Direction.DOWN;
		dir = Direction.UP;
		dir = Direction.LEFT;
		dir = Direction.RIGHT;
		dir = Direction.UP_LEFT;
		dir = Direction.UP_RIGHT;
		dir = Direction.DOWN_LEFT;
		dir = Direction.DOWN_RIGHT;
		
		// Creates timer
		timer = new Timer(20, hnd);
		timer.start(); // Starts the timer
	}
	
	public void setDirection(Direction d) {
		dir = d;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g; // Cast parent Graphics into child Graphics2D
		// Makes black background
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		g2.setColor(Color.CYAN);
		for(int i = 0; i < MAX; i++) 
			g2.fillRect(stars[i].getX(), stars[i].getY(), 2, 2);
				
		g2.setColor(Color.YELLOW);
		for(int i = 0; i < MAX / 3; i++) 
			g2.fillRect(suns[i].getX(), suns[i].getY(), 2 + (i % 2), 2 + (i % 2));
		
		g2.setColor(Color.WHITE);
		g2.drawString("X = " + curMouseX + ", Y = " + curMouseY, curMouseX, curMouseY);
	}
	
	private class MouseHandler implements MouseMotionListener {
		public void mouseDragged(MouseEvent arg0) {	}

		public void mouseMoved(MouseEvent e) {
			prevMouseX = curMouseX;
			prevMouseY = curMouseY;
			curMouseX = e.getX();
			curMouseY = e.getY();
			repaint();
		}
		
	}
	
	private class Handler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == timer) {
				for(int i = 0; i < MAX; i++) {
					switch(dir) {
						case DOWN:
							stars[i].moveDown();
							break;
						case UP:
							stars[i].moveUp();
							break;
						case RIGHT:
							stars[i].moveRight();
							break;
						case LEFT:
							stars[i].moveLeft();
							break;
						case UP_RIGHT:
							stars[i].moveUpRight();
							break;
						case UP_LEFT:
							stars[i].moveUpLeft();
							break;
						case DOWN_RIGHT:
							stars[i].moveDownRight();
							break;
						case DOWN_LEFT:
							stars[i].moveDownLeft();
							break;
					}
					
					if(i < MAX / 3){
						suns[i].moveDown();  
						
					}
				}
				repaint();
			}
		}
		
	}

}