package me.mustache.main;

import me.mustache.character.Player;

import me.mustache.consumables.Bread;
import me.mustache.database.Database;
import me.mustache.gui.StartGui;
import me.mustache.gui.MetadataInventar;
import me.mustache.consumables.HealthPot;
import me.mustache.consumables.ManaPot;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    public static Player thePlayer;
    MetadataInventar inventar;
    public static void main(String[] args){


        thePlayer = new Player();
        new StartGui();
        MetadataInventar.getInstance().addConsumable(new HealthPot());
        MetadataInventar.getInstance().addConsumable(new HealthPot());
        MetadataInventar.getInstance().addConsumable(new HealthPot());
        MetadataInventar.getInstance().addConsumable(new HealthPot());
        MetadataInventar.getInstance().addConsumable(new ManaPot());
        MetadataInventar.getInstance().addConsumable(new ManaPot());
        MetadataInventar.getInstance().addConsumable(new ManaPot());
        MetadataInventar.getInstance().addConsumable(new ManaPot());
        MetadataInventar.getInstance().addConsumable(new Bread());

         Database.createNewDatabase("test.db");


    }


}
