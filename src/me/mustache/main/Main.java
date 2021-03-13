package me.mustache.main;

import me.mustache.character.Hunger;
import me.mustache.character.Player;
import me.mustache.gui.Gui;

public class Main {

    public static Player thePlayer;

    public static void main(String[] args){




        thePlayer = new Player();
        new Gui();
    }
}
