package me.mustache.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Inventar extends JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    MetadataInventar inv = MetadataInventar.getInstance();
    private int screenX = (int) screenSize.getWidth();
    private int screenY = (int) screenSize.getHeight();

    private int windowX = screenX/4;
    private int windowY = screenY/4;

    /**
     * @param pName
     */
    public Inventar(String pName){

        setTitle(pName + "'s Inventar");
        setSize(windowX, windowY);
        setResizable(false);
        setLayout(null);
        setVisible(true);


        setupInventory();

    }

    private void setupInventory() //erstellt die rows für die einzelnen Items
    {
        int posYLabel=0;
        int posYNum=0;

        ArrayList<String> allConsumables = inv.getAllCurrentConsumablesAsStringList();
        ArrayList<String> allItems = inv.getAllCurrentItemsAsStringList();
        for (String str: allConsumables ) {
            JLabel itemName = new JLabel(str);
            itemName.setBounds((int) Math.round(windowX*0.05), posYLabel*40, (int) Math.round(windowX*0.4), (int) Math.round(windowY*0.125));
            add(itemName);
            JButton useItem = new JButton("Benutzen");
            JLabel numInventory = new JLabel(String.valueOf(inv.getAmountOfConsumable(str)));
            numInventory.setBounds((int) Math.round(windowX*0.45),posYLabel*40, (int) Math.round( windowX*0.166), (int) Math.round(windowY*0.125));
            add(numInventory);
            useItem.setBounds((int) Math.round( windowX*0.616), posYLabel*40, (int) Math.round( windowX*0.344), (int) Math.round( windowY*0.125));
            add(useItem);
            useItem.addActionListener(e -> {
                        inv.useConsumable(str);
                        numInventory.setText(String.valueOf(inv.getAmountOfConsumable(str)));
                    });
            posYLabel++;
        }
        for (String str: allItems ) {
            JLabel itemName = new JLabel(str);
            itemName.setBounds((int) Math.round(windowX*0.05), posYLabel*40, (int) Math.round(windowX*0.4), (int) Math.round(windowY*0.125));
            add(itemName);
            JButton useItem = new JButton("Ausrüsten");
            JLabel numInventory = new JLabel(String.valueOf(inv.getAmountOfConsumable(str)));
            numInventory.setBounds((int) Math.round(windowX*0.45),posYLabel*40, (int) Math.round( windowX*0.166), (int) Math.round(windowY*0.125));
            add(numInventory);
            useItem.setBounds((int) Math.round( windowX*0.616), posYLabel*40, (int) Math.round( windowX*0.344), (int) Math.round( windowY*0.125));
            add(useItem);
            useItem.addActionListener(e -> {
                inv.useConsumable(str);
                numInventory.setText(String.valueOf(inv.getAmountOfItem(str)));
            });
            posYLabel++;
        }



    }



}
