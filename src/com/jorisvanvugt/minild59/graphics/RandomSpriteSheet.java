package com.jorisvanvugt.minild59.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class RandomSpriteSheet extends SpriteSheet {

	public RandomSpriteSheet(int spriteSize) {
		super("http://swapshop.pixelsyntax.com/api/randomImage", spriteSize);
	}

	@Override
	protected BufferedImage loadImage() {
		try {
			return ImageIO.read(new URL(sheetURL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
