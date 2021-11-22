package me.thinh_geographical.minesweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class MouseController implements MouseListener {
	
	
	

	private Screen s;

	public MouseController(Screen screen) {
	this.s = screen;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		Tile t = s.getTile(x, y);
		if(t == null) return;
		if(SwingUtilities.isLeftMouseButton(arg0)) {
			if(!t.hasFlag()) {
			if(t.isClose()) {
				t.setClose(false);
			}
			if(t.getPixelSquare() == PixelSquare.BOMB) {
				s.uncloseAllTile();
			}
			}
		} else if(SwingUtilities.isRightMouseButton(arg0)) {
			if(t.isClose()) {
				t.toggleFlag();
			}
		}
		s.update();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
//		
	}

}
