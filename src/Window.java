import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class Window extends JFrame {
	private MyPanel panel;
	
	public static void main(String args[]) { new Window();}
	
	public Window() {
		setTitle("Java 293");
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Point.setMaxX(this.getWidth());
		Point.setMaxY(getHeight());
		panel = new MyPanel();
		add(panel);
		this.addKeyListener(new KeyHandler());
		setVisible(true);
	}
	
	private class KeyHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
	 
			switch(arg0.getKeyCode()) {
			case 37:
				panel.setDirection(MyPanel.Direction.LEFT);
				break;
			case 38:
				panel.setDirection(MyPanel.Direction.UP);
				break;
			case 39:
				panel.setDirection(MyPanel.Direction.RIGHT);
				break;
			case 40:
				panel.setDirection(MyPanel.Direction.DOWN);
				break;
			case 41:
				panel.setDirection(MyPanel.Direction.UP_LEFT);
				break;
			case 42:
				panel.setDirection(MyPanel.Direction.UP_RIGHT);
				break;
			case 43:
				panel.setDirection(MyPanel.Direction.DOWN_LEFT);
				break;
			case 44:
				panel.setDirection(MyPanel.Direction.DOWN_RIGHT);
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
