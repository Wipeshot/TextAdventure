package me.mustache.gui;

import me.mustache.trade.Trader;

import javax.swing.*;
import java.awt.*;

public class TradeGui extends JFrame {

    public TradeGui(String pTitle){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenX = (int) screenSize.getWidth();
        int screenY = (int) screenSize.getHeight();

        int windowX = screenX/4;
        int windowY = screenY/4;

        String title;
        setTitle(pTitle);
        setSize(windowX, windowY);
        setResizable(false);
        setVisible(true);


    }




}
