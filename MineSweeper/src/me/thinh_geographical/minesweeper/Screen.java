package me.thinh_geographical.minesweeper;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class Screen extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5910677373237135352L;
	private ImageLoader loader;
	private Tile[][] list = new Tile[10][10];
	
	public Screen() {
		this.setPreferredSize(new Dimension(320,320));
		this.setDoubleBuffered(true);
		this.setFocusable(true);
        loader = new ImageLoader();
        setDefault();
        createPixel();
        addMouseListener(new MouseController(this));
	}
	private void setDefault() {
		for(int x = 0;x < 10;x++) for(int y = 0;y < 10;y++) {
			list[y][x] = new Tile(PixelSquare.NONE,x,y);
		}
	}
	
	public Tile getTile(int x,int y) {	
		int x1 = Math.floorDiv(x,ImageLoader.PIXEL);
		int y1 = Math.floorDiv(y, ImageLoader.PIXEL);
		if(x1 < 0 || x1 >= 10 || y1 < 0 || y1 >= 10) return null;
		return list[y1][x1];
	}
    //Tao boom
	private void createPixel() {
		List<Integer> random = new ArrayList<>();
		for(int i = 0; i < 100;i++) {
			random.add(i);
		}
		Collections.shuffle(random);
		for(int i = 0;i < 10;i++) {
			Integer next = random.get(i);
			int x = Math.floorMod(next, 10);
			int y = Math.floorDiv(next, 10);
			list[y][x] = new Tile(PixelSquare.BOMB,x,y);
		}
		reCaculator();
	}
    //Update so bom xung quanh
	private void reCaculator() {
		for(int y = 0;y < 10;y++) for(int x = 0;x < 10;x++) {
			Tile t = list[y][x];
			if(t.getPixelSquare() == PixelSquare.NONE) {
				int b = 0;
				for(int x1 = -1;x1 <= 1;x1++) 
					for(int y1 = -1;y1 <= 1;y1++) {
					int x2 = x + x1;
					int y2 = y + y1;
					if(x2 < 0 || x2 >= 10 || y2 < 0 || y2 >= 10) continue;
					Tile t2 = list[y2][x2];
					if(t2.getPixelSquare() == PixelSquare.BOMB) b++;
				}
				t.setPixelSquare(PixelSquare.b(b));
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		render(g);
	}

	private void render(Graphics g) {
		for(int x = 0;x < 10;x++) for(int y = 0;y < 10;y++) {
			list[x][y].draw(g, loader);
		}
	}


	public void update() {
		repaint();
	}
	public void uncloseAllTile() {
		for(int x = 0;x < 10;x++) for(int y = 0;y < 10;y++) {
			Tile t2 = list[y][x];
			t2.setClose(false);
		}
	}

}
