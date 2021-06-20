package me.mustache.gui;


import me.mustache.database.Database;
import me.mustache.main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Currency;

public class TradeGui extends JFrame {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private int screenX = (int) screenSize.getWidth();
    private int screenY = (int) screenSize.getHeight();

    private int windowX = screenX/4;
    private int windowY = screenY/4;

    private MetadataInventar inv = MetadataInventar.getInstance();

    public TradeGui(int traderId){


        setTitle(Database.getTraderName(traderId));
        setSize(windowX, windowY);
        setResizable(false);
        setLayout(null);
        setVisible(true);

        setupInventory();


    }

    private void setupInventory() {
        int posYLabel = 0;
        int posYNum = 0;

        ArrayList<String> allConsumables = inv.getAllCurrentConsumablesAsStringList();
        ArrayList<String> allItems = inv.getAllCurrentItemsAsStringList();
        for (String str : allConsumables) {
            JLabel itemName = new JLabel(str);
            itemName.setBounds((int) Math.round(windowX * 0.05), posYLabel * 40, (int) Math.round(windowX * 0.4), (int) Math.round(windowY * 0.125));
            add(itemName);
            JButton buyItem = new JButton("Kaufen");
            JLabel price = new JLabel(String.valueOf(Database.getItemPrice(Database.getItemIdByName(str))));
            price.setBounds((int) Math.round(windowX * 0.45), posYLabel * 40, (int) Math.round(windowX * 0.166), (int) Math.round(windowY * 0.125));
            add(price);
            buyItem.setBounds((int) Math.round(windowX * 0.616), posYLabel * 40, (int) Math.round(windowX * 0.344), (int) Math.round(windowY * 0.125));
            add(buyItem);
            buyItem.addActionListener(e -> {
                if(Main.thePlayer.getCurrency().checkMoney(Database.getItemPrice(Database.getItemIdByName(str)))) Database.addItem(Database.getItemIdByName(str));
            });
            posYLabel++;
        }
        for (String str : allItems) {
            JLabel itemName = new JLabel(str);
            itemName.setBounds((int) Math.round(windowX * 0.05), posYLabel * 40, (int) Math.round(windowX * 0.4), (int) Math.round(windowY * 0.125));
            add(itemName);
            JButton buyItem = new JButton("Kaufen");
            JLabel price = new JLabel(String.valueOf(Database.getItemPrice(Database.getItemIdByName(str))));
            price.setBounds((int) Math.round(windowX * 0.45), posYLabel * 40, (int) Math.round(windowX * 0.166), (int) Math.round(windowY * 0.125));
            add(price);
            buyItem.setBounds((int) Math.round(windowX * 0.616), posYLabel * 40, (int) Math.round(windowX * 0.344), (int) Math.round(windowY * 0.125));
            add(buyItem);
            buyItem.addActionListener(e -> {
                if(Main.thePlayer.getCurrency().checkMoney(Database.getItemPrice(Database.getItemIdByName(str)))) Database.addItem(Database.getItemIdByName(str));
            });
            posYLabel++;
        }


    }
}
