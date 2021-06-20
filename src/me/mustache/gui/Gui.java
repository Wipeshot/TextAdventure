package me.mustache.gui;

import me.mustache.character.Player;
import me.mustache.database.Database;

import java.awt.*;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class Gui extends JFrame {


	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private int screenWidth = (int) screenSize.getWidth();
	private int screenHeight = (int) screenSize.getHeight();

	private int windowWidth = (int) (screenWidth*0.7);
	private int windowHeight = (int) (screenHeight*0.7);
	private int currentStoryId = 1;
	private String[] answer = Database.getFirstAnswers();
	private JTextArea storyArea = new JTextArea();
	private JButton upperLeftBtn = new JButton(answer[0]);
	private JButton upperRightBtn = new JButton(answer[1]);
	private JButton lowerLeftBtn = new JButton(answer[2]);
	private JButton lowerRightBtn = new JButton(answer[3]);

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
		choicesPanel.setLayout(new GridLayout(2, 2));
		JPanel encounterPanel = new JPanel();
		encounterPanel.setBounds(characterPanel.getWidth()+storyPanel.getWidth(),0,200,200);
		JPanel envPanel = new JPanel();
		envPanel.setBounds(characterPanel.getWidth()+storyPanel.getWidth(),encounterPanel.getHeight(),200,encounterPanel.getHeight()*2);
		JPanel mapPanel = new JPanel();
		mapPanel.setBounds(characterPanel.getWidth()+storyPanel.getWidth(),envPanel.getY()+envPanel.getHeight(),200,windowHeight-envPanel.getHeight()-encounterPanel.getHeight()-40);
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
		inventar.setBorder(mainBorder);
		inventar.setBackground(Color.BLACK);
		inventar.setForeground(Color.GREEN);
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
		new Inventar("");
	}

	public void addToStory(String str) {
		storyArea.append("\n\n");
		storyArea.append(str);
	}

	public void setChoices(String[] texts, int[] ids) {
		setButton(upperLeftBtn,texts[0],ids[0],0);
		setButton(upperRightBtn,texts[1],ids[1],1);
		setButton(lowerLeftBtn,texts[2],ids[2],2);
		setButton(lowerRightBtn,texts[3],ids[3],3);
	}

	private void setButton(JButton btn, String text,int id, int btnId) {
		btn.setText(text);
		for( ActionListener act : btn.getActionListeners() ) {
			btn.removeActionListener( act );
		}
		btn.addActionListener(e -> {
			choicePressed(id);
			int[] answerIds = Database.getAnswerIdsByStory(currentStoryId);
			currentStoryId = Database.getNextStoryId(id);
			addToStory(Database.getStoryByAnswer(id));
			setChoices(Database.getAnswersByStory(currentStoryId), answerIds);
		});
	}

	private void choicePressed(int id)
	{
		System.out.println("Antwort mit der ID:" +id+" wurde gedrückt");
	}

	}



