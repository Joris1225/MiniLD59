package com.jorisvanvugt.minild59.level.entities;

import java.awt.event.KeyEvent;

import com.jorisvanvugt.minild59.Game;
import com.jorisvanvugt.minild59.Input;
import com.jorisvanvugt.minild59.graphics.Bitmap;

public class Player extends Entity {

	private float speed = 1f;

	public Player() {
		sprite = Game.spriteSheet.getSprite(0, 0);
		x = 64 * 16 / 2;
		y = 64 * 16 / 2;
	}

	@Override
	public void update() {
		if (Input.getKeyDown(KeyEvent.VK_UP)) {
			y -= speed;
		}
		if (Input.getKeyDown(KeyEvent.VK_DOWN)) {
			y += speed;
		}
		if (Input.getKeyDown(KeyEvent.VK_LEFT)) {
			x -= speed;
		}
		if (Input.getKeyDown(KeyEvent.VK_RIGHT)) {
			x += speed;
		}
	}
	
	@Override
	public void draw(Bitmap bitmap) {
		bitmap.draw(sprite, Math.round(bitmap.getWidth() / 2 - sprite.getWidth() / 2), Math.round(bitmap.getHeight() / 2 - sprite.getHeight() / 2));
	}

}
