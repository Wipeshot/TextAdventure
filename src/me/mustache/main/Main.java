package me.mustache.main;

import me.mustache.character.Player;
import me.mustache.gui.Inventar;
import me.mustache.gui.StartGui;
import me.mustache.location.City;
import me.mustache.pots.HealthPot;
import me.mustache.trade.PotTrader;


public class Main {

    public static Player thePlayer;
    private static Inventar inv;

    public static void main(String[] args){


        thePlayer = new Player();
        new StartGui();

        HealthPot healthPot = new HealthPot();

        healthPot.setNumInInventory(7);
        inv.refreshInv();



    }
}
