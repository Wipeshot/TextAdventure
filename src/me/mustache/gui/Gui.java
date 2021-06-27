package me.mustache.gui;

import me.mustache.character.Player;
import me.mustache.database.Database;
import me.mustache.entity.Entity;
import me.mustache.logic.BattleLogic;
import me.mustache.logic.Trigger;
import me.mustache.main.Main;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;


public class Gui extends JFrame {


	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private int screenWidth = 1920;
	private int screenHeight = 1080;

	private int windowWidth = (int) (screenWidth*0.7);
	private int windowHeight = (int) (screenHeight*0.7);
	private int currentStoryId = 1;
	private String[] answer = Database.getFirstAnswers();
	private JTextArea storyArea = new JTextArea();
	private JButton upperLeftBtn = new JButton(answer[0]);
	private JButton upperRightBtn = new JButton(answer[1]);
	private JButton lowerLeftBtn = new JButton(answer[2]);
	private JButton lowerRightBtn = new JButton(answer[3]);
	private JButton inv;
	private JPanel characterPanel;
	private JPanel inventoryPanel;
	private JPanel storyPanel;
	private JPanel choicesPanel;
	private JPanel encounterPanel;
	private JPanel envPanel;
	private JPanel mapPanel;
	private JButton attack = new JButton("Angriff");
	private JButton escape = new JButton("Flüchten");

	private static Gui instance = null;
	public static Gui getInstance() {
		if (instance == null) {
			instance = new Gui();
		}
		return instance;
	}

	public Gui() {
		this.setSize(windowWidth, windowHeight);
		this.setResizable(false);
		this.setVisible(true);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		characterPanel = new JPanel();
		characterPanel.setBounds(0,0,200,200);
		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(0,characterPanel.getHeight(),200,characterPanel.getHeight()*2);
		inv = new JButton("Inventar");
		inv.setBounds(0,inventoryPanel.getY()+inventoryPanel.getHeight(),200,115);
		storyPanel = new JPanel();
		storyPanel.setBounds(characterPanel.getWidth(),0,927,(int)(this.getContentPane().getHeight()*0.6));
		choicesPanel = new JPanel();
		choicesPanel.setBounds(characterPanel.getWidth(),storyPanel.getHeight(),927,(int)(this.getContentPane().getHeight()*0.4));
		choicesPanel.setLayout(new GridLayout(2, 2));
		encounterPanel = new JPanel();
		encounterPanel.setBounds(characterPanel.getWidth()+storyPanel.getWidth(),0,200,200);
		envPanel = new JPanel();
		envPanel.setBounds(characterPanel.getWidth()+storyPanel.getWidth(),encounterPanel.getHeight(),200,encounterPanel.getHeight()*2);
		mapPanel = new JPanel();
		JLabel mapLabel = new JLabel();
		mapPanel.setBounds(characterPanel.getWidth()+storyPanel.getWidth(),envPanel.getY()+envPanel.getHeight(),200,windowHeight-envPanel.getHeight()-encounterPanel.getHeight()-40);
		mapPanel.add(mapLabel);
		storyArea.setForeground(Color.GREEN); //196 108 93
		storyArea.setBackground(Color.BLACK);
		storyArea.setText(Database.getFirstStory());
		storyArea.setLineWrap(true);
		storyArea.setWrapStyleWord(true);
		storyArea.setEditable(false);
		storyArea.setFont(new Font("Courier", Font.PLAIN,12));
		JScrollPane storyScroll = new JScrollPane(storyArea);
		storyPanel.add(storyScroll);
		storyPanel.setLayout(new GridLayout(0, 1));


		Border mainBorder;

		mainBorder = BorderFactory.createLineBorder(Color.green);

		inventoryPanel.setBorder(mainBorder);

		characterPanel.setBorder(mainBorder);
		characterPanel.setBackground(Color.BLACK);
		inventoryPanel.setBorder(mainBorder);
		inventoryPanel.setBackground(Color.BLACK);
		inv.setBorder(mainBorder);
		inv.setBackground(Color.BLACK);
		inv.setForeground(Color.GREEN);
		upperLeftBtn.setBorder(mainBorder);
		upperLeftBtn.setBackground(Color.BLACK);
		upperLeftBtn.setForeground(Color.GREEN);
		upperRightBtn.setBorder(mainBorder);
		upperRightBtn.setBackground(Color.BLACK);
		upperRightBtn.setForeground(Color.GREEN);
		lowerLeftBtn.setBorder(mainBorder);
		lowerLeftBtn.setBackground(Color.BLACK);
		lowerLeftBtn.setForeground(Color.GREEN);
		lowerRightBtn.setBorder(mainBorder);
		lowerRightBtn.setBackground(Color.BLACK);
		lowerRightBtn.setForeground(Color.GREEN);


		upperLeftBtn.addActionListener(e -> {
			choicePressed(1);
			int[] answerIds = Database.getAnswerIdsByStory(currentStoryId);
			currentStoryId = Database.getNextStoryId(1);
			addToStory(Database.getStoryByAnswer(answerIds[0]));
			setChoices(Database.getAnswersByStory(currentStoryId), answerIds);
		});
		upperRightBtn.addActionListener(e -> {
			choicePressed(2);
			int[] answerIds = Database.getAnswerIdsByStory(currentStoryId);
			currentStoryId = Database.getNextStoryId(2);
			addToStory(Database.getStoryByAnswer(2));
			setChoices(Database.getAnswersByStory(currentStoryId), answerIds);
		});
		lowerLeftBtn.addActionListener(e -> {
			choicePressed(3);
			int[] answerIds = Database.getAnswerIdsByStory(currentStoryId);
			currentStoryId = Database.getNextStoryId(3);
			addToStory(Database.getStoryByAnswer(3));
			setChoices(Database.getAnswersByStory(currentStoryId), answerIds);
		});
		lowerRightBtn.addActionListener(e -> {
			choicePressed(4);
			int[] answerIds = Database.getAnswerIdsByStory(currentStoryId);
			currentStoryId = Database.getNextStoryId(4);
			addToStory(Database.getStoryByAnswer(4));
			setChoices(Database.getAnswersByStory(currentStoryId), answerIds);
		});


		choicesPanel.add(upperLeftBtn);
		choicesPanel.add(upperRightBtn);
		choicesPanel.add(lowerLeftBtn);
		choicesPanel.add(lowerRightBtn);
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

		inv.addActionListener(e -> {
			openInventar();
		});

		add(characterPanel);
		add(inventoryPanel);
		add(inv);
		add(storyPanel);
		add(choicesPanel);
		add(envPanel);
		add(encounterPanel);
		add(mapPanel);
		setLayout(null);
	}

	public void openInventar(){ //Erstellt das Inventar
		new Inventar(Player.getInstance().getName());
	}

	/**
	 *
	 * @param str
	 */

	public void addToStory(String str) {
		storyArea.append("\n\n");
		storyArea.append(str);
	}

	/**
	 *
	 * @param texts
	 * @param ids
	 */

	public void setChoices(String[] texts, int[] ids) {
		setButton(upperLeftBtn,texts[0],ids[0],0);
		setButton(upperRightBtn,texts[1],ids[1],1);
		setButton(lowerLeftBtn,texts[2],ids[2],2);
		setButton(lowerRightBtn,texts[3],ids[3],3);
	}

	/**
	 *
	 * @param btn
	 * @param text
	 * @param id
	 * @param btnId
	 */

	private void setButton(JButton btn, String text,int id, int btnId) {
		btn.setText(text);
		for( ActionListener act : btn.getActionListeners() ) {
			btn.removeActionListener( act );
		}
		btn.addActionListener(e -> {
			choicePressed(id);
			//Trigger.useTrigger(id);
			int[] answerIds = Database.getAnswerIdsByStory(currentStoryId);
			currentStoryId = Database.getNextStoryId(id);
			addToStory(Database.getStoryByAnswer(id));
			setChoices(Database.getAnswersByStory(currentStoryId), answerIds);
		});
	}

	/**
	 *
	 * @param id
	 */

	private void choicePressed(int id)
	{
		System.out.println("Antwort mit der ID:" +id+" wurde gedrückt");
	}


	public void setupFightscreen(Entity enemy){
		choicesPanel.remove(upperLeftBtn);
		choicesPanel.remove(upperRightBtn);
		choicesPanel.remove(lowerLeftBtn);
		choicesPanel.remove(lowerRightBtn);

		choicesPanel.add(attack);
		choicesPanel.add(escape);

		BattleLogic bl = new BattleLogic(Player.getInstance());

		for( ActionListener act : attack.getActionListeners() ) {
			attack.removeActionListener( act );
		}
		attack.addActionListener(e -> {
			bl.fightEnemy(enemy);
			bl.fightHero(enemy);
			if(!enemy.checkDeath() && !Player.getInstance().checkDeath()){
				setupFightscreen(enemy);
			}else if(Player.getInstance().checkDeath()){
				this.dispose();
				new Deathscreen();
			}else if (enemy.checkDeath()){
				choicesPanel.remove(attack);
				choicesPanel.remove(escape);
				choicesPanel.add(upperLeftBtn);
				choicesPanel.add(upperRightBtn);
				choicesPanel.add(lowerLeftBtn);
				choicesPanel.add(lowerRightBtn);
			}
		});
		this.repaint();
	}


	}



