package com.jorisvanvugt.minild59.level.tiles;

import com.jorisvanvugt.minild59.Game;
import com.jorisvanvugt.minild59.graphics.Bitmap;

public class Tile {

	public final static Tile BRICK = new Tile(Game.spriteSheet.getSprite(0, 6));
	public final static Tile FLOOR = new Tile(Game.spriteSheet.getSprite(7, 7));

	private Bitmap sprite;

	public Tile(Bitmap sprite) {
		this.sprite = sprite;
	}

	public Bitmap getSprite() {
		return sprite;
	}
}
