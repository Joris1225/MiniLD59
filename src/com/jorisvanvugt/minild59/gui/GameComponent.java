package com.jorisvanvugt.minild59.gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.jorisvanvugt.minild59.Game;
import com.jorisvanvugt.minild59.Input;
import com.jorisvanvugt.minild59.graphics.Bitmap;

public class GameComponent extends Canvas implements Runnable {

	private static final long serialVersionUID = -7472664683257412526L;
	public final static int WIDTH = 200;
	public final static int HEIGHT = 200;
	public final static int SCALE = 4;

	private Thread thread;
	private boolean running = false;

	private BufferedImage image;
	private int[] pixels;
	private Bitmap bitmap;
	private Game game;

	public GameComponent() {
		Dimension dimension = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setSize(dimension);
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		addKeyListener(new Input());

		bitmap = new Bitmap(WIDTH, HEIGHT);
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		game = new Game();

	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		
		while (running) {
			long now = System.nanoTime();
			delta += (now-  lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				frames = 0;
				updates = 0;
			}
		}
	}

	public void update() {
		game.update();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		bitmap.fill(0x000000);
		game.render(bitmap);
		System.arraycopy(bitmap.pixels, 0, pixels, 0, WIDTH * HEIGHT);

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		g.dispose();
		bs.show();
	}

	public synchronized void stop() {
		if (!running)
			return;

		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		GameComponent gc = new GameComponent();
		JFrame frame = new JFrame("MiniLD59 by Joris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gc);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		gc.start();
	}
}
