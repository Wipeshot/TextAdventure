package me.mustache.gui;

import me.mustache.character.Player;

import javax.swing.*;

import static me.mustache.main.Main.thePlayer;

public class Deathscreen extends JFrame {

    public Deathscreen(){

        int windowX = 500;
        int windowY = 130;

        JLabel lblDeath = new JLabel("Du bist gestorben");

        this.setSize(windowX, windowY);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        lblDeath.setBounds(10, 5, 400, 50);
        add(lblDeath);
        lblDeath.setVisible(true);


    }

}
