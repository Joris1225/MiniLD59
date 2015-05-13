package com.jorisvanvugt.minild59.graphics;

public class Bitmap {
	private int width;
	private int height;
	public int[] pixels;

	public Bitmap(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}

	public void draw(Bitmap bitmap, int xOffset, int yOffset) {
		for (int y = 0; y < bitmap.getHeight(); y++) {
			int yPixel = yOffset + y;
			if (yPixel < 0 || yPixel >= height)
				continue;

			for (int x = 0; x < bitmap.getWidth(); x++) {
				// Dont draw the pixel if the alpha channel is 255.
				// Works, but a little bit hacky.
				if ((bitmap.pixels[x + y * bitmap.getHeight()] & 0xff000000) == 0)
					continue;

				int xPixel = xOffset + x;
				if (xPixel < 0 || xPixel >= width)
					continue;

				pixels[xPixel + yPixel * height] = bitmap.pixels[x + y * bitmap.getHeight()];
			}
		}
	}

	public void fill(int color) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = color;
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
