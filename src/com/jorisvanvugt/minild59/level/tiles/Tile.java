package com.jorisvanvugt.minild59.level.tiles;

import com.jorisvanvugt.minild59.graphics.Bitmap;
import com.jorisvanvugt.minild59.graphics.Sprite;

public abstract class Tile extends Sprite{
	
	protected boolean traversable = true;
	
	protected Tile() {
		super();
	}

	public Bitmap getSprite() {
		return sprite;
	}
	
	public boolean isTraversable() {
		return traversable;
	}
}
