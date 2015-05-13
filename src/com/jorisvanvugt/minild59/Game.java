package com.jorisvanvugt.minild59;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.jorisvanvugt.minild59.graphics.Bitmap;
import com.jorisvanvugt.minild59.graphics.RandomSpriteSheet;
import com.jorisvanvugt.minild59.graphics.SpriteManager;
import com.jorisvanvugt.minild59.graphics.SpriteSheet;
import com.jorisvanvugt.minild59.level.Level;
import com.jorisvanvugt.minild59.level.entities.Entity;
import com.jorisvanvugt.minild59.level.entities.Player;

public class Game {
	public final static int spriteSize = 16;
	
	private Player player;
	private Level level;
	private ArrayList<Entity> entities;

	public Game() {
		SpriteManager.loadSpriteSheet(new RandomSpriteSheet(spriteSize));
		
		player = new Player();
		level = new Level(64);
		entities = new ArrayList<>(20);
		entities.add(player);
	}

	public void update() {
		if(Input.getKeyDown(KeyEvent.VK_R)) {
			changeSpriteSheet(new RandomSpriteSheet(spriteSize));
		}
		if(Input.getKeyDown(KeyEvent.VK_M)) {
			changeSpriteSheet(new SpriteSheet("/spritesheet.png", spriteSize));
		}
		
		for(Entity e: entities) {
			e.update();
		}
	}
	
	private void changeSpriteSheet(SpriteSheet spriteSheet) {
		SpriteManager.loadSpriteSheet(spriteSheet);
		resetSprites();
	}
	
	private void resetSprites() {
		for(Entity e: entities) {
			e.loadSprite();
		}
		level.loadSprites();
	}

	public void render(Bitmap bitmap) {
		level.draw(bitmap, Math.round(player.x), Math.round(player.y));
		player.draw(bitmap);
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
}
