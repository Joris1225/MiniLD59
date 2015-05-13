package com.jorisvanvugt.minild59.level.entities;

import com.jorisvanvugt.minild59.graphics.Bitmap;

public abstract class Entity {

	public float x;
	public float y;

	protected Bitmap sprite;

	protected Entity() {

	}

	public void update() {

	}

	public void draw(Bitmap bitmap) {
		bitmap.draw(sprite, Math.round(x - sprite.getWidth() / 2), Math.round(y - sprite.getHeight() / 2));
	}

}
