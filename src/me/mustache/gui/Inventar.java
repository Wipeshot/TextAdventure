package me.mustache.gui;

import javax.swing.*;
import java.awt.*;

public class Inventar extends JFrame {

    public Inventar(String pName){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenX = (int) screenSize.getWidth();
        int screenY = (int) screenSize.getHeight();

        int windowX = screenX/4;
        int windowY = screenY/4;

        setTitle(pName);
        setSize(windowX, windowY);
        setResizable(false);
        setVisible(true);

    }

}
