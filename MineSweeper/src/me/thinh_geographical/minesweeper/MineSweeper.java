package me.thinh_geographical.minesweeper;

import javax.swing.JFrame;

public class MineSweeper {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.add(new Screen());
		jf.pack();
		jf.setTitle("MineSweeper - Make by Thinh_Geographical");
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
	}
	
}
