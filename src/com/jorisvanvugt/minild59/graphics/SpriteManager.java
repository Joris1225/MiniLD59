package com.jorisvanvugt.minild59.graphics;

public class SpriteManager {

	public static Bitmap CHAR1_FACING_DOWN1;
	public static Bitmap CHAR1_FACING_DOWN2;
	public static Bitmap CHAR1_FACING_DOWN3;
	public static Bitmap CHAR1_FACING_RIGHT1;
	public static Bitmap CHAR1_FACING_RIGHT2;
	public static Bitmap CHAR1_FACING_RIGHT3;
	public static Bitmap CHAR1_FACING_UP1;
	public static Bitmap CHAR1_FACING_UP2;
	public static Bitmap CHAR1_FACING_UP3;
	public static Bitmap CHAR1_FACING_LEFT1;
	public static Bitmap CHAR1_FACING_LEFT2;
	public static Bitmap CHAR1_FACING_LEFT3;
	public static Bitmap BULLET;
	
	public static Bitmap FLOOR;
	public static Bitmap BRICK1;

	private SpriteManager() {
		
	}
	
	public static void loadSpriteSheet(SpriteSheet spriteSheet) {
		CHAR1_FACING_DOWN1 = spriteSheet.getSprite(0, 0);
		CHAR1_FACING_DOWN2 = spriteSheet.getSprite(1, 0);
		CHAR1_FACING_DOWN3 = spriteSheet.getSprite(2, 0);
		CHAR1_FACING_RIGHT1 = spriteSheet.getSprite(3, 0);
		CHAR1_FACING_RIGHT2 = spriteSheet.getSprite(4, 0);
		CHAR1_FACING_RIGHT3 = spriteSheet.getSprite(5, 0);
		CHAR1_FACING_UP1 = spriteSheet.getSprite(6, 0);
		CHAR1_FACING_UP2 = spriteSheet.getSprite(7, 0);
		CHAR1_FACING_UP3 = spriteSheet.getSprite(0, 1);
		CHAR1_FACING_LEFT1 = CHAR1_FACING_RIGHT1.flipHorizontal();
		CHAR1_FACING_LEFT2 = CHAR1_FACING_RIGHT2.flipHorizontal();
		CHAR1_FACING_LEFT3 = CHAR1_FACING_RIGHT3.flipHorizontal();
		BULLET = spriteSheet.getSprite(5, 3);
		FLOOR = spriteSheet.getSprite(4, 7);
		BRICK1 = spriteSheet.getSprite(0, 6);
	}
}
