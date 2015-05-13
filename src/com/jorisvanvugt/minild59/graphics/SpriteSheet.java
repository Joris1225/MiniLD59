package com.jorisvanvugt.minild59.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private int[] pixels;
	private int width;
	private int height;
	private int spriteSize;
	protected String sheetURL;

	public SpriteSheet(String sheetURL, int spriteSize) {
		this.spriteSize = spriteSize;
		this.sheetURL = sheetURL;
		BufferedImage image = loadImage();
		width = image.getWidth();
		height = image.getHeight();
		pixels = new int[width * height];
		image.getRGB(0, 0, width, height, pixels, 0, width);
	}
	
	protected BufferedImage loadImage() {
		try {
			return ImageIO.read(SpriteSheet.class.getResource(sheetURL)); 
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retrieves a sprite from the spritesheet.
	 * 
	 * @param x
	 *            X coordinate of the sprite starting left at 0.
	 * @param y
	 *            Y coordinate of the sprite starting top at 0.
	 * @return
	 */
	public Bitmap getSprite(int xCoord, int yCoord) {
		Bitmap result = new Bitmap(spriteSize, spriteSize);
		for (int y = 0; y < spriteSize; y++) {
			for (int x = 0; x < spriteSize; x++) {
				result.pixels[x + y * spriteSize] = pixels[(xCoord * spriteSize + x) + (yCoord * spriteSize + y) * width];
			}
		}
		return result;
	}
}
