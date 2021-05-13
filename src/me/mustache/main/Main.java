package me.mustache.main;

import me.mustache.character.Player;

import me.mustache.consumables.Bread;
import me.mustache.database.Database;
import me.mustache.gui.StartGui;
import me.mustache.gui.MetadataInventar;
import me.mustache.consumables.HealthPot;
import me.mustache.consumables.ManaPot;


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


        /*
        Database.createNewDatabase("test.db");
        Database.createStory();

        Database.insertIntoAnswer("Antwort 1");
        Database.insertIntoAnswer("Antwort 2");
        Database.insertIntoAnswer("Antwort 3");
        Database.insertIntoAnswer("Antwort 4");
        Database.insertIntoStory("Story 1", "0,1,2,3");

        String[] answer = new String[4];
        answer = Database.getFirstAnswers();

        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }

        System.out.println(Database.getFirstStory());
        */

    }


}
