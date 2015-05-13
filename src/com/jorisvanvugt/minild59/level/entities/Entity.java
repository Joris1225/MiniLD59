package com.jorisvanvugt.minild59.level.entities;

import com.jorisvanvugt.minild59.graphics.Bitmap;
import com.jorisvanvugt.minild59.graphics.Sprite;

public abstract class Entity extends Sprite {

	public float x;
	public float y;

	protected Entity() {
		super();
	}

	public void update() {

	}

	public void draw(Bitmap bitmap) {
		bitmap.draw(sprite, Math.round(x - sprite.getWidth() / 2), Math.round(y - sprite.getHeight() / 2));
	}
}
