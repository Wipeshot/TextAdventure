package me.mustache.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	
	public Gui() {
		
		
		//Gibt die Monitor größe
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int screenX = (int) screenSize.getWidth();
		int screenY = (int) screenSize.getHeight();
		
		int windowX = screenX/2;
		int windowY = screenY/2;
		
		this.setSize(windowX, windowY);
		this.setResizable(false);
		this.setVisible(true);
		
		
		
		
		
		
		
	}

}
