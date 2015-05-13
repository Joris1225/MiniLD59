package com.jorisvanvugt.minild59.level.tiles;

import com.jorisvanvugt.minild59.graphics.SpriteManager;

public class FloorTile extends Tile{
	
	public FloorTile() {
		super();
	}

	@Override
	public void loadSprite() {
		sprite = SpriteManager.FLOOR;
	}
	
	
}
