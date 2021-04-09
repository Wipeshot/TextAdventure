package me.mustache.gui;

import me.mustache.pots.HealthPot;
import me.mustache.pots.Pot;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;

public class Inventar extends JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    MetadataInventar inv = MetadataInventar.getInstance();
    private int screenX = (int) screenSize.getWidth();
    private int screenY = (int) screenSize.getHeight();

    private int windowX = screenX/4;
    private int windowY = screenY/4;

    public Inventar(String pName){

        setTitle(pName + "'s Inventar");
        setSize(windowX, windowY);
        setResizable(false);
        setLayout(null);
        setVisible(true);


        healthPot();

    }


    public void healthPot(){

        JLabel itemName = new JLabel(inv.getHealthPot().getName());
        JLabel numInventory = new JLabel(String.valueOf(inv.getAmountOfPot(inv.getHealthPot().getName())));
        JButton useItem = new JButton("Benutzen");

        itemName.setBounds((int) Math.round(windowX*0.05), 0, (int) Math.round(windowX*0.4), (int) Math.round(windowY*0.125));
        numInventory.setBounds((int) Math.round(windowX*0.45),0, (int) Math.round( windowX*0.166), (int) Math.round(windowY*0.125));
        useItem.setBounds((int) Math.round( windowX*0.616), 0, (int) Math.round( windowX*0.344), (int) Math.round( windowY*0.125));

        add(itemName);
        add(numInventory);
        add(useItem);

        useItem.addActionListener(e -> {
                    inv.useHealthPot();
                }
                );

    }


}
