package com.jorisvanvugt.minild59.level.tiles;

import com.jorisvanvugt.minild59.Game;
import com.jorisvanvugt.minild59.graphics.Bitmap;

public class Level {

	private Tile[] tiles;
	private int size;

	public Level(int size) {
		this.size = size;
		tiles = new Tile[size * size];
		for (int i = 0; i < size * size; i++) {
			tiles[i] = Tile.FLOOR;
		}
	}

	public void draw(Bitmap bitmap, int xOffset, int yOffset) {
		for (int y = 0; y < bitmap.getHeight(); y++) {
			int yy = y + yOffset;
			if(yy / Game.spriteSize < 0 || yy / Game.spriteSize >= 64)
				continue;
			for (int x = 0; x < bitmap.getWidth(); x++) {
				int xx = x + xOffset;
				if(xx / Game.spriteSize < 0 || xx / Game.spriteSize >= 64)
					continue;
				
				// The game crashes when ypu walk outside of the map on the left or top side
				// I suspect this has something to do with negative modulo.
				int tileCoord = (xx / Game.spriteSize) + (yy / Game.spriteSize) * size;
				int spriteCoord = (xx % Game.spriteSize) + (yy % Game.spriteSize) * Game.spriteSize;
				bitmap.pixels[x + y * bitmap.getWidth()] = tiles[tileCoord].getSprite().pixels[spriteCoord];
			}
		}
	}

}
