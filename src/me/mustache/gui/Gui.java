package me.mustache.gui;

import me.mustache.character.Player;
import me.mustache.trade.PotTrader;

import java.awt.Dimension;

import javax.swing.*;

import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Gui extends JFrame {

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	protected static int screenX = (int) screenSize.getWidth();
	protected static int screenY = (int) screenSize.getHeight();

	protected static int windowX = screenX/2;
	protected static int windowY = screenY/2;
	
	public Gui() {

		JButton inventar = new JButton("Inventar");
		
		
		//Erstellt das Fenster
		
		this.setSize(windowX, windowY);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Components



		//Button Inventar
		int iLocX = screenX/2-screenX/8;
		int iLocY = screenY/16;
		inventar.setBounds(iLocX-17, iLocY+2, screenX/8, screenY/16);
		inventar.addActionListener(e -> {
			openInventar();
		});
		add(inventar);



	}



	public void openInventar(){
		new Inventar(Player.getName());
	}




	}



