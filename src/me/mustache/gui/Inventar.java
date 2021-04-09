package me.mustache.gui;

import me.mustache.pots.HealthPot;
import me.mustache.pots.Pot;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

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


        setupInventory();

    }

    private void setupInventory()
    {
        int posYLabel=0;
        int posYNum=0;

        ArrayList<String> allPots = inv.getAllCurrentPotsAsStringList();
        for (String str: allPots ) {
            JLabel itemName = new JLabel(str);
            itemName.setBounds((int) Math.round(windowX*0.05), posYLabel*30, (int) Math.round(windowX*0.4), (int) Math.round(windowY*0.125));
            add(itemName);
            JButton useItem = new JButton("Benutzen");
            JLabel numInventory = new JLabel(String.valueOf(inv.getAmountOfPot(str)));
            numInventory.setBounds((int) Math.round(windowX*0.45),posYLabel*30, (int) Math.round( windowX*0.166), (int) Math.round(windowY*0.125));
            add(numInventory);
            useItem.setBounds((int) Math.round( windowX*0.616), posYLabel*30, (int) Math.round( windowX*0.344), (int) Math.round( windowY*0.125));
            add(useItem);
            useItem.addActionListener(e -> {
                        inv.usePot(str);
                        numInventory.setText(String.valueOf(inv.getAmountOfPot(str)));
                    });
            posYLabel++;
        }



    }



}
