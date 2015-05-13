package com.jorisvanvugt.minild59.level.entities;

import com.jorisvanvugt.minild59.graphics.SpriteManager;

public class Bullet extends Entity {
	
	public int xVel, yVel;
	
	public Bullet(int xVel, int yVel) {
		sprite = SpriteManager.BULLET;
		this.xVel = xVel;
		this.yVel = yVel;
	}
	
	@Override
	public void update() {
		x += xVel;
		y += yVel;
	}

}
