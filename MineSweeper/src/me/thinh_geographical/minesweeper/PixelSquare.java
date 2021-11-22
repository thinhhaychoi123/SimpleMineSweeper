package me.thinh_geographical.minesweeper;

public enum PixelSquare {

	NONE(0),ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),BOMB(9),UNKNOWN(10),FLAG(11);
	
	private int a;

	private PixelSquare(int a) {
		this.a = a;
	}
	
	public int a() {
		return this.a;
	}
	public static PixelSquare b(int b) {
		for(PixelSquare ps : PixelSquare.values()) {
			if(ps.a() == b) return ps;
		}
		return null;
	}
}
