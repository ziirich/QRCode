package org.barsf.camera.util.jh;

import org.barsf.camera.util.ImageUtils;

import java.awt.image.BufferedImage;


public class JHNormalizeFilter extends JHFilter {

	@Override
	public BufferedImage filter(BufferedImage src, BufferedImage dest) {

		final int w = src.getWidth();
		final int h = src.getHeight();

		int c, a, r, g, b, i, max = 1;

		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {

				c = src.getRGB(x, y);
				a = ImageUtils.clamp((c >> 24) & 0xff);
				r = ImageUtils.clamp((c >> 16) & 0xff);
				g = ImageUtils.clamp((c >> 8) & 0xff);
				b = ImageUtils.clamp(c & 0xff);
				i = (a << 24) | (r << 16) | (g << 8) | b;

				if (i > max) {
					max = i;
				}
			}
		}

		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				c = src.getRGB(x, y);
				i = c * 256 / max;
				dest.setRGB(x, y, i);
			}
		}

		return dest;
	}

}
