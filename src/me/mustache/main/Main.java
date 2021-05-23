package me.mustache.main;

import me.mustache.character.Player;

import me.mustache.consumables.Bread;
import me.mustache.database.Database;
import me.mustache.gui.*;
import me.mustache.gui.MetadataInventar;
import me.mustache.consumables.HealthPot;
import me.mustache.consumables.ManaPot;

import javax.xml.crypto.Data;
import java.sql.SQLException;

import static me.mustache.database.Database.insertIntoStory;


public class Main {

    public static Player thePlayer;
    MetadataInventar inventar;
    public static void main(String[] args) throws SQLException {


        thePlayer = new Player();
        new StartGui();
        Database story = new Database();

        String[] answers = new String[4];

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

        Database.createStory();
        Database.insertIntoAnswer("Antwort 1");
        Database.insertIntoAnswer("Antwort 2");
        Database.insertIntoAnswer("Antwort 3");
        Database.insertIntoAnswer("Antwort 4");
        Database.insertIntoStory("Story 1", "1,2,3,4");

        answers = Database.getFirstAnswers();

        System.out.println(Database.getFirstStory());
        System.out.println(answers[0]);
        System.out.println(answers[1]);
        System.out.println(answers[2]);
        System.out.println(answers[3]);

    }


}
