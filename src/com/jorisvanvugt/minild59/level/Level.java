package com.jorisvanvugt.minild59.level;

import com.jorisvanvugt.minild59.Game;
import com.jorisvanvugt.minild59.graphics.Bitmap;
import com.jorisvanvugt.minild59.level.tiles.BrickTile;
import com.jorisvanvugt.minild59.level.tiles.FloorTile;
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
					setTile(x, y, new BrickTile());
				else
					setTile(x, y, new FloorTile());
			}
		}
	}

	public void draw(Bitmap bitmap, int xOffset, int yOffset) {
		for (int y = 0; y < bitmap.getHeight(); y++) {
			int yy = y + yOffset;
			if (yy / Game.spriteSize < 0 || yy / Game.spriteSize >= 64)
				continue;
			for (int x = 0; x < bitmap.getWidth(); x++) {
				int xx = x + xOffset;
				if (xx / Game.spriteSize < 0 || xx / Game.spriteSize >= 64)
					continue;

				int tileCoord = (xx / Game.spriteSize) + (yy / Game.spriteSize) * size;
				int spriteCoord = (xx % Game.spriteSize) + (yy % Game.spriteSize) * Game.spriteSize;
				if (spriteCoord < 0) // Otherwise it breaks when xOffset or yOffset < 0. It still doesn't fully work though.
					continue;
				bitmap.pixels[x + y * bitmap.getWidth()] = tiles[tileCoord].getSprite().pixels[spriteCoord];
			}
		}
	}

	public void setTile(int x, int y, Tile tile) {
		tiles[x + y * size] = tile;
	}
	
	public void loadSprites() {
		for(Tile t: tiles) {
			t.loadSprite();
		}
	}

}
