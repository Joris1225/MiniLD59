package com.jorisvanvugt.minild59.level.tiles;

import com.jorisvanvugt.minild59.graphics.SpriteManager;


public class BrickTile extends Tile {

	public BrickTile() {
		super();
	}
	
	@Override
	public void loadSprite() {
		sprite = SpriteManager.BRICK1;
	}

	

}
