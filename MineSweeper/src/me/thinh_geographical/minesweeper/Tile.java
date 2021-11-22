package me.thinh_geographical.minesweeper;

import java.awt.Graphics;

public class Tile {

	private PixelSquare ps;
	private int x;
	private int y;
	private boolean close;
	private boolean flag;
	public Tile(PixelSquare ps, int x, int y) {
		this.ps = ps;
		this.x = x;
		this.y = y;
		this.close = true;
		this.flag = false;
	}
	
	public void draw(Graphics g,ImageLoader load) {
		PixelSquare pst = ps;
		if(close) {
			pst = PixelSquare.UNKNOWN;
		}
		if(flag) {
			pst = PixelSquare.FLAG;
		}
		g.drawImage(load.getImageFrom(pst), x*ImageLoader.PIXEL, y*ImageLoader.PIXEL, null);
	}
	
	public PixelSquare getPixelSquare() {
		return this.ps;
	}
	
	public void setPixelSquare(PixelSquare ps) {
		this.ps = ps;
	}
	public boolean isClose() {
		return this.close;
	}
	public void setClose(boolean close) {
		this.close = close;
	}
	public void toggleFlag() {
		setFlag(!this.flag);
	}
	public boolean hasFlag() {
		return this.flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
