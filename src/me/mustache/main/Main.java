package me.mustache.main;

import me.mustache.character.Player;

import me.mustache.database.Database;
import me.mustache.gui.*;
import me.mustache.gui.MetadataInventar;

import java.sql.SQLException;




public class Main {

    public static Player thePlayer;
    public static MetadataInventar inventar;
    public static void main(String[] args) throws SQLException {


        thePlayer = new Player();
        new StartGui();

        Database.createNewDatabase("test.db");

        Database.addItem(5);
        Database.addItem(1);
        Database.addItem(6);
        Database.addItem(7);
        Database.addItem(4);
        Database.addItem(8);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);
        Database.addItem(3);





    }


}
