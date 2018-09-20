package com.tutorial.main;

import java.awt.Graphics;

//all objects used for the game
//x,y position, emumeration ID and speed x,y

public abstract class GameObject {
	
	protected int x, y;
	protected ID id; //ID enumeration
	protected int velX, velY;
	
	
	//CONSTRUCTOR
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	 
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setID(ID id) {
		this.id = id;
	}
	
	public ID getID() {
		return id;
	}
	
	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}
	
	public int gameBoundaryCheck(int currentPosition, int min, int max) {
		if (currentPosition <= min) {
			return currentPosition = min;
		}
		else if (currentPosition >= max) {
			return currentPosition = max;
		}
		else {
			return currentPosition;
		}
	}
	
}
