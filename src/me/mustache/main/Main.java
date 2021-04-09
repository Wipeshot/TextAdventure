package me.mustache.main;

import me.mustache.character.Player;

import me.mustache.gui.Inventar;
import me.mustache.gui.StartGui;
import me.mustache.gui.MetadataInventar;
import me.mustache.location.City;
import me.mustache.pots.HealthPot;
import me.mustache.pots.ManaPot;
import me.mustache.trade.PotTrader;


public class Main {

    public static Player thePlayer;
    MetadataInventar inventar;
    public static void main(String[] args){


        thePlayer = new Player();
        new StartGui();
        MetadataInventar.getInstance().addPot(new HealthPot());
        MetadataInventar.getInstance().addPot(new HealthPot());
        MetadataInventar.getInstance().addPot(new HealthPot());
        MetadataInventar.getInstance().addPot(new HealthPot());
        MetadataInventar.getInstance().addPot(new ManaPot());
        MetadataInventar.getInstance().addPot(new ManaPot());
        MetadataInventar.getInstance().addPot(new ManaPot());
        MetadataInventar.getInstance().addPot(new ManaPot());
        MetadataInventar.getInstance().addPot(new ManaPot());




    }
}
