package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

//Player object inherited from Game Object class
public class Player extends GameObject{
	
	private int floorHeight = Game.HEIGHT/2;

	public Player(int x, int y, ID id) {
		super(x, y, id);
	}


	public void tick() {

		x += velX;
		y += floorHeight;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		this.x = gameBoundaryCheck(this.x, 0, Game.WIDTH);
		this.x = gameBoundaryCheck(this.x, 0, Game.WIDTH - 38);
		
		this.y = gameBoundaryCheck(this.y, 0, Game.HEIGHT+6);
		this.y = gameBoundaryCheck(this.y, 0, Game.HEIGHT - 72);
		
	}


	public void render(Graphics g) {
		if (id == ID.Player) {
			g.setColor(Color.black);
		}
		if (id == ID.Player2 ) {
			g.setColor(Color.black);
		}
		
		g.fillRect(x, y, 32, 32);
		
	}
	

}
