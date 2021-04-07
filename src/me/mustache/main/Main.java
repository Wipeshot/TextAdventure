package me.mustache.main;

import me.mustache.character.Hunger;
import me.mustache.character.Player;
import me.mustache.gui.Gui;
import me.mustache.location.City;
import me.mustache.location.Location;
import me.mustache.trade.PotTrader;

import static me.mustache.gui.Gui.*;

public class Main {

    public static Player thePlayer;
    public static PotTrader potTrader;
    public static City marburg;

    public static void main(String[] args){


        thePlayer = new Player();
        marburg = new City("Marburg");
        new Gui();

        thePlayer.setName("Pimmelkopf");

    }
}
