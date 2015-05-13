package com.jorisvanvugt.minild59.graphics;

public abstract class Sprite {
	protected Bitmap sprite;
	
	protected Sprite() {
		loadSprite();
	}
	
	public abstract void loadSprite();
}
