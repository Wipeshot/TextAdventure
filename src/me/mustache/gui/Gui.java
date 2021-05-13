package me.mustache.gui;

import me.mustache.character.Player;
import me.mustache.trade.PotTrader;

import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.text.BadLocationException;


@SuppressWarnings("serial")
public class Gui extends JFrame {


	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	 static int screenWidth = (int) screenSize.getWidth();
	 static int screenHeight = (int) screenSize.getHeight();

	 static int windowWidth = (int) (screenWidth*0.7);
	 static int windowHeight = (int) (screenHeight*0.7);
	 static private JTextArea storyArea = new JTextArea();
	 static private JButton upperLeftBtn = new JButton("Antwort 1");
	static private JButton upperRightBtn = new JButton("Antwort 2");
	static private JButton lowerLeftBtn = new JButton("Antwort 3");
	static private JButton lowerRightBtn = new JButton("Antwort 4");

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
		storyArea.setForeground(Color.GREEN);
		storyArea.setBackground(Color.BLACK);
		storyArea.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. ");
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
			choicePressed(0);
		});
		upperRightBtn.addActionListener(e -> {
			choicePressed(1);
		});
		lowerLeftBtn.addActionListener(e -> {
			choicePressed(2);
		});
		lowerRightBtn.addActionListener(e -> {
			choicePressed(3);
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

		addToStory("Ich komme bald aus der Datenbank wenn wipeshit das gemacht hat.");



	}



	public void openInventar(){
		new Inventar("s");
	}
	public static void addToStory(String str)
	{
		storyArea.append("\n\n");
		storyArea.append(str);
	}
	// oder man macht eine klasse Answer dann würde die datenbank eine arrayList<Answer> hier rein geben was cooler ist.
	// und vielleicht eine answerButton klasse die von jbutton erbt weil das so wie wir das jetzt machen whack is
	public static void setChoices(ArrayList<String> texts, int[] ids)
	{
		setButton(upperLeftBtn,texts.get(0),ids[0]);
		setButton(upperRightBtn,texts.get(1),ids[1]);
		setButton(lowerLeftBtn,texts.get(2),ids[2]);
		setButton(lowerRightBtn,texts.get(3),ids[3]);
	}
	private static void setButton(JButton btn, String text,int id)
	{
		btn.setText(text);
			for( ActionListener act : btn.getActionListeners() ) {
				btn.removeActionListener( act );
			}
		btn.addActionListener(e -> {
			choicePressed(id);
		});
	}

	private static void choicePressed(int id)
	{
		System.out.println("Antwort mit der ID:" +id+" wurde gedrückt");
	}

	}



