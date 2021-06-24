package me.mustache.gui;

import me.mustache.character.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static me.mustache.main.Main.*;

public class StartGui extends JFrame{


    public StartGui(){

        int windowX = 500;
        int windowY = 130;

        JLabel lblName = new JLabel("Gebe hier einen gewünschten Namen ein:");
        JTextField fieldName = new JTextField();
        JButton buttonName = new JButton("Eingabe");

        this.setSize(windowX, windowY);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        lblName.setBounds(10, 5, 400, 50);
        add(lblName);
        lblName.setVisible(true);

        fieldName.setBounds(10, 40, 300, 20);
        add(fieldName);
        fieldName.setVisible(true);

        buttonName.setBounds(315,40,100,20);
        add(buttonName);
        buttonName.setVisible(true);
        buttonName.addActionListener(e -> {
            Player p = new Player();
            p.setName(fieldName.getText());
            this.dispose();
            Gui.getInstance();
        });




    }

}
