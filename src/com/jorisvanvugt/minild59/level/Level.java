package com.jorisvanvugt.minild59.level;

import com.jorisvanvugt.minild59.graphics.Bitmap;
import com.jorisvanvugt.minild59.graphics.SpriteManager;
import com.jorisvanvugt.minild59.level.tiles.Tile;

public class Level {

	private Tile[] tiles;
	private int size;

	public Level(int size) {
		this.size = size;
		tiles = new Tile[size * size];
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				if (x == 0 || x == size - 1 || y == 0 || y == size - 1)
					setTile(x, y, Tile.BRICK);
				else
					setTile(x, y, Tile.FLOOR);
			}
		}
	}

	public void draw(Bitmap bitmap, int xOffset, int yOffset) {
		for (int y = 0; y < bitmap.getHeight(); y++) {
			int yy = y + yOffset;
			if (yy / SpriteManager.spriteSize < 0 || yy / SpriteManager.spriteSize >= 64)
				continue;
			for (int x = 0; x < bitmap.getWidth(); x++) {
				int xx = x + xOffset;
				if (xx / SpriteManager.spriteSize < 0 || xx / SpriteManager.spriteSize >= 64)
					continue;

				int tileCoord = (xx / SpriteManager.spriteSize) + (yy / SpriteManager.spriteSize) * size;
				int spriteCoord = (xx % SpriteManager.spriteSize) + (yy % SpriteManager.spriteSize) * SpriteManager.spriteSize;
				if (spriteCoord < 0) // Otherwise it breaks when xOffset or yOffset < 0. It still doesn't fully work though.
					continue;
				bitmap.pixels[x + y * bitmap.getWidth()] = tiles[tileCoord].getSprite().pixels[spriteCoord];
			}
		}
	}

	public void setTile(int x, int y, Tile tile) {
		tiles[x + y * size] = tile;
	}

}
