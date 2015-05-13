package com.jorisvanvugt.minild59.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private int[] pixels;
	private int width;
	private int height;
	private int spriteSize;

	public SpriteSheet(String filename, int spriteSize) {
		this.spriteSize = spriteSize;
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(filename));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
