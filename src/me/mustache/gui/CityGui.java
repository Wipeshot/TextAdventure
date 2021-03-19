package me.mustache.gui;

import me.mustache.trade.PotTrader;

import javax.swing.*;

public class CityGui extends Gui {

    public CityGui() {


    JButton trankladen = new JButton("Trankladen");

    //Button Trankladen
    int tLocX = screenX / 2 - screenX / 8;
    trankladen.setBounds(tLocX-17,2,screenX/8,screenY/16);
    trankladen.addActionListener(e ->

    {
        openPotTrader();
    });

    add(trankladen);

    }



    public void openPotTrader(){
        new PotTrader("Herbert der Trankbrauer");
    }

}
