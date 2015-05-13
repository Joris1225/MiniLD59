package com.jorisvanvugt.minild59.level.entities;

import java.awt.event.KeyEvent;

import com.jorisvanvugt.minild59.Game;
import com.jorisvanvugt.minild59.Input;
import com.jorisvanvugt.minild59.graphics.Bitmap;

public class Player extends Entity {

	private float speed = 1f;
	private Bitmap[] sprites = new Bitmap[4];

	public Player() {
		sprites[0] = Game.spriteSheet.getSprite(0, 0); // facing down
		sprites[1] = Game.spriteSheet.getSprite(3, 0); // facing right
		sprites[2] = Game.spriteSheet.getSprite(6, 0); // facing up
		Bitmap left = new Bitmap(sprites[1]);
		left.flipHorizontal();
		sprites[3] = left;
		sprite = sprites[0];
		x = 64 * 16 / 2;
		y = 64 * 16 / 2;
	}

	@Override
	public void update() {
		if (Input.getKeyDown(KeyEvent.VK_UP)) {
			y -= speed;
			sprite = sprites[2];
		}
		if (Input.getKeyDown(KeyEvent.VK_DOWN)) {
			y += speed;
			sprite = sprites[0];
		}
		if (Input.getKeyDown(KeyEvent.VK_LEFT)) {
			x -= speed;
			sprite = sprites[3];
		}
		if (Input.getKeyDown(KeyEvent.VK_RIGHT)) {
			x += speed;
			sprite = sprites[1];
		}
	}

	@Override
	public void draw(Bitmap bitmap) {
		bitmap.draw(sprite, Math.round(bitmap.getWidth() / 2 - sprite.getWidth() / 2), Math.round(bitmap.getHeight() / 2 - sprite.getHeight() / 2));
	}

}
