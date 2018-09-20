package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Enemy extends GameObject {

	public Enemy(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		
	}


	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if (id == ID.Enemy) {
			g.setColor(Color.red);
			g.fillRect(x, y, 32, 32);
		}

	}

}
