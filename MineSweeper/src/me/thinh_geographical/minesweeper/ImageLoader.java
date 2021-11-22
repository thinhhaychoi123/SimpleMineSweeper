package me.thinh_geographical.minesweeper;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public final static int PIXEL = 32;
	private BufferedImage[] list; 
	
	public ImageLoader() {
		list = new BufferedImage[12];
		loadImage();
	}

	private void loadImage() {
		try {
			BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/tiles.png"));
			for(PixelSquare ps : PixelSquare.values()) {
				list[ps.a()] = image.getSubimage(ps.a()*PIXEL, 0, PIXEL, PIXEL);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public BufferedImage getImageFrom(PixelSquare ps) {
		return list[ps.a()];
	}

}
