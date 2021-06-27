package me.mustache.main;

import me.mustache.character.Player;

import me.mustache.database.Database;
import me.mustache.gui.*;
import me.mustache.gui.MetadataInventar;

import java.sql.SQLException;
import java.util.ArrayList;


public class Main {


    public static MetadataInventar inventar;
    public static void main(String[] args){



        new StartGui();

        Database.createNewDatabase("test.db"); //Überpürft ob die Datenbank vorhanden ist und wenn nicht wird eine neue erstellt

        Database.addItem(2);
        Database.addItem(2);
        Database.addItem(2);
        Database.addItem(2);

    }


}
