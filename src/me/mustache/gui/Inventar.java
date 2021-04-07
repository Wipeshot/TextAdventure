package me.mustache.gui;

import me.mustache.pots.HealthPot;
import me.mustache.pots.Pot;

import javax.swing.*;
import java.awt.*;

public class Inventar extends JFrame {

    public Inventar(String pName){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenX = (int) screenSize.getWidth();
        int screenY = (int) screenSize.getHeight();

        int windowX = screenX/4;
        int windowY = screenY/4;

        setTitle(pName + "'s Inventar");
        setSize(windowX, windowY);
        setResizable(false);
        setVisible(true);

    }


    public void healthPot(){

        HealthPot healthPot = new HealthPot();

        JLabel itemName = new JLabel(healthPot.getName());
        JLabel numInventory = new JLabel(String.valueOf(healthPot.getNumInInventory()));
        JButton useItem = new JButton("Benutzen");

        add(itemName);
        add(numInventory);
        add(useItem);


    }

}
