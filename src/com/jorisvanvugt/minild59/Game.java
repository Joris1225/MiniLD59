package com.jorisvanvugt.minild59;

import com.jorisvanvugt.minild59.graphics.Bitmap;
import com.jorisvanvugt.minild59.graphics.SpriteSheet;
import com.jorisvanvugt.minild59.level.entities.Player;
import com.jorisvanvugt.minild59.level.tiles.Level;

public class Game {
	public final static int spriteSize = 16;
	public final static SpriteSheet spriteSheet = new SpriteSheet("/spritesheet.png", spriteSize);
	private Player player = new Player();
	private Level level = new Level(64);

	public Game() {
		
	}

	public void update() {
		player.update();
	}

	public void render(Bitmap bitmap) {
		level.draw(bitmap, Math.round(player.x), Math.round(player.y));
		player.draw(bitmap);
	}
}
