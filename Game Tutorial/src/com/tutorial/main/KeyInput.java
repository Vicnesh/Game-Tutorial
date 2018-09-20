package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		GameObject tempObject;	
		
			
		for(int i = 0; i < handler.object.size(); i++) {
			tempObject = handler.object.get(i);
			
			int jumpStrength = 100;
			int weight = 1;
			int playerY = tempObject.getY();
			
			//controls for player 1
			if (handler.object.get(i).getID() == ID.Player) {
				
				if (key == KeyEvent.VK_UP ) {
				
					tempObject.setY(playerY -= jumpStrength + weight);
					//jumpStrength -= weight;

				}
				
				else if (key == KeyEvent.VK_DOWN) {
					//move down
					tempObject.setY(tempObject.getY() + 32);
				}

				
			}
		}		
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	}

}
