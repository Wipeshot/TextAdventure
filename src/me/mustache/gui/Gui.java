package me.mustache.gui;

import me.mustache.character.Player;
import me.mustache.trade.PotTrader;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


@SuppressWarnings("serial")
public class Gui extends JFrame {


	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	 static int screenWidth = (int) screenSize.getWidth();
	 static int screenHeight = (int) screenSize.getHeight();

	 static int windowWidth = (int) (screenWidth*0.7);
	 static int windowHeight = (int) (screenHeight*0.7);


	public Gui() {
		this.setSize(windowWidth, windowHeight);
		this.setResizable(false);
		this.setVisible(true);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel characterPanel = new JPanel();
		characterPanel.setBounds(0,0,200,200);
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setBounds(0,characterPanel.getHeight(),200,characterPanel.getHeight()*2);
		JButton inventar = new JButton("Inventar");
		inventar.setBounds(0,inventoryPanel.getY()+inventoryPanel.getHeight(),200,115);
		JPanel storyPanel = new JPanel();
		storyPanel.setBounds(characterPanel.getWidth(),0,927,(int)(this.getContentPane().getHeight()*0.6));
		JPanel choicesPanel = new JPanel();
		choicesPanel.setBounds(characterPanel.getWidth(),storyPanel.getHeight(),927,(int)(this.getContentPane().getHeight()*0.4));
		JPanel encounterPanel = new JPanel();
		encounterPanel.setBounds(characterPanel.getWidth()+storyPanel.getWidth(),0,200,200);
		JPanel envPanel = new JPanel();
		envPanel.setBounds(characterPanel.getWidth()+storyPanel.getWidth(),encounterPanel.getHeight(),200,encounterPanel.getHeight()*2);
		JPanel mapPanel = new JPanel();
		mapPanel.setBounds(characterPanel.getWidth()+storyPanel.getWidth(),envPanel.getY()+envPanel.getHeight(),200,windowHeight-envPanel.getHeight()-encounterPanel.getHeight()-40);


		Border mainBorder;

		mainBorder = BorderFactory.createLineBorder(Color.green);

		inventoryPanel.setBorder(mainBorder);

		characterPanel.setBorder(mainBorder);
		characterPanel.setBackground(Color.BLACK);
		inventoryPanel.setBorder(mainBorder);
		inventoryPanel.setBackground(Color.BLACK);
		inventar.setBorder(mainBorder);
		inventar.setBackground(Color.BLACK);
		inventar.setForeground(Color.GREEN);
		storyPanel.setBorder(mainBorder);
		storyPanel.setBackground(Color.BLACK);
		choicesPanel.setBorder(mainBorder);
		choicesPanel.setBackground(Color.BLACK);
		envPanel.setBorder(mainBorder);
		envPanel.setBackground(Color.BLACK);
		encounterPanel.setBorder(mainBorder);
		encounterPanel.setBackground(Color.BLACK);
		mapPanel.setBorder(mainBorder);
		mapPanel.setBackground(Color.BLACK);

		inventar.addActionListener(e -> {
			openInventar();
		});

		add(characterPanel);
		add(inventoryPanel);
		add(inventar);
		add(storyPanel);
		add(choicesPanel);
		add(envPanel);
		add(encounterPanel);
		add(mapPanel);
		setLayout(null);





	}



	public void openInventar(){
		new Inventar("s");
	}




	}



