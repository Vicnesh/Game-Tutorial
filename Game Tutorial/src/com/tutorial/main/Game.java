package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1550691097823471818L;

	
	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private KeyInput keyInput;
	
	//CONSTRUCTOR
	public Game() {

		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Game Tutorial", this);
		this.requestFocus();
		handler.addObject(new Player(WIDTH/8, HEIGHT, ID.Player));
		//handler.addObject(new Player(WIDTH/32, HEIGHT/8, ID.Player2));
		//create random enemy blocks that move from left to right of screen
		handler.addObject(new Enemy(WIDTH/2, HEIGHT/2, ID.Enemy));
	}

	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//used for thread
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				delta--;
			}
			
			if(running) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
			
		}
		
		stop();
	}
	
	
	
	private void tick() {
		handler.tick();
		
	}
	
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	
	//main
	public static void main(String args[]) {
		new Game();
	}

}
