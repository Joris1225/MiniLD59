package com.jorisvanvugt.minild59.level.tiles;

import com.jorisvanvugt.minild59.graphics.Bitmap;
import com.jorisvanvugt.minild59.graphics.SpriteManager;

public class Tile {

	public final static Tile BRICK = new Tile(SpriteManager.BRICK1);
	public final static Tile FLOOR = new Tile(SpriteManager.FLOOR);

	private Bitmap sprite;

	public Tile(Bitmap sprite) {
		this.sprite = sprite;
	}

	public Bitmap getSprite() {
		return sprite;
	}
}
