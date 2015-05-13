package com.jorisvanvugt.minild59.graphics;

public class SpriteManager {
	public final static int spriteSize = 16;
	public final static SpriteSheet SPRITESHEET = new SpriteSheet("/spritesheet.png", spriteSize);
	// public final static SpriteSheet spriteSheet = new RandomSpriteSheet(spriteSize);

	public final static Bitmap CHAR1_FACING_DOWN1 = SPRITESHEET.getSprite(0, 0);
	public final static Bitmap CHAR1_FACING_DOWN2 = SPRITESHEET.getSprite(1, 0);
	public final static Bitmap CHAR1_FACING_DOWN3 = SPRITESHEET.getSprite(2, 0);
	public final static Bitmap CHAR1_FACING_RIGHT1 = SPRITESHEET.getSprite(3, 0);
	public final static Bitmap CHAR1_FACING_RIGHT2 = SPRITESHEET.getSprite(4, 0);
	public final static Bitmap CHAR1_FACING_RIGHT3 = SPRITESHEET.getSprite(5, 0);
	public final static Bitmap CHAR1_FACING_UP1 = SPRITESHEET.getSprite(6, 0);
	public final static Bitmap CHAR1_FACING_UP2 = SPRITESHEET.getSprite(7, 0);
	public final static Bitmap CHAR1_FACING_UP3 = SPRITESHEET.getSprite(0, 1);
	public final static Bitmap CHAR1_FACING_LEFT1 = CHAR1_FACING_RIGHT1.flipHorizontal();
	public final static Bitmap CHAR1_FACING_LEFT2 = CHAR1_FACING_RIGHT2.flipHorizontal();
	public final static Bitmap CHAR1_FACING_LEFT3 = CHAR1_FACING_RIGHT3.flipHorizontal();
	
	public final static Bitmap FLOOR = SPRITESHEET.getSprite(7, 7);
	public final static Bitmap BRICK1 = SPRITESHEET.getSprite(0, 6);

	private SpriteManager() {

	}
}
