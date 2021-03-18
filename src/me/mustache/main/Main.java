package me.mustache.main;

import me.mustache.character.Hunger;
import me.mustache.character.Player;
import me.mustache.gui.Gui;
import me.mustache.location.City;
import me.mustache.trade.PotTrader;

public class Main {

    public static Player thePlayer;
    public static PotTrader potTrader;
    public static City marburg;

    public static void main(String[] args){



        potTrader = new PotTrader("Herbert der Trankbrauer");
        thePlayer = new Player();
        marburg = new City("Marburg");
        new Gui();
    }
}
