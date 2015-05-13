package com.jorisvanvugt.minild59;

import java.util.ArrayList;

import com.jorisvanvugt.minild59.graphics.Bitmap;
import com.jorisvanvugt.minild59.level.Level;
import com.jorisvanvugt.minild59.level.entities.Entity;
import com.jorisvanvugt.minild59.level.entities.Player;

public class Game {
	
	private Player player = new Player();
	private Level level = new Level(64);
	private ArrayList<Entity> entities = new ArrayList<>(20);

	public Game() {
		entities.add(player);
	}

	public void update() {
		for(Entity e: entities) {
			e.update();
		}
	}

	public void render(Bitmap bitmap) {
		level.draw(bitmap, Math.round(player.x), Math.round(player.y));
		player.draw(bitmap);
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
}
