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

import static me.mustache.database.Database.getAnswersByStory;
import static me.mustache.database.Database.insertIntoStory;


public class Main {

    public static Player thePlayer;
    MetadataInventar inventar;
    public static void main(String[] args) throws SQLException {


        thePlayer = new Player();
        new StartGui();
        Database story = new Database();

        String[] answer;

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

        Database.setStoryForAnswer(1, 2);
        Database.setStoryForAnswer(2,3);
        Database.setStoryForAnswer(3,4);
        Database.setStoryForAnswer(4,5);
        Database.setStoryForAnswer(5, 6);
        Database.setStoryForAnswer(6,7);
        Database.setStoryForAnswer(7,8);
        Database.setStoryForAnswer(8,9);
        Database.setStoryForAnswer(9, 10);
        Database.setStoryForAnswer(10,11);
        Database.setStoryForAnswer(11,12);
        Database.setStoryForAnswer(12,13);
        Database.setStoryForAnswer(13, 14);
        Database.setStoryForAnswer(14,15);
        Database.setStoryForAnswer(15,1);
        Database.setStoryForAnswer(16,2);
        Database.setStoryForAnswer(17, 3);
        Database.setStoryForAnswer(18,4);
        Database.setStoryForAnswer(19,5);
        Database.setStoryForAnswer(20,6);
        Database.setStoryForAnswer(21, 7);
        Database.setStoryForAnswer(22,8);
        Database.setStoryForAnswer(23,9);
        Database.setStoryForAnswer(24,10);
        Database.setStoryForAnswer(25, 11);
        Database.setStoryForAnswer(26,12);
        Database.setStoryForAnswer(27,13);
        Database.setStoryForAnswer(28,14);
        Database.setStoryForAnswer(29, 15);
        Database.setStoryForAnswer(30,1);
        Database.setStoryForAnswer(31,2);
        Database.setStoryForAnswer(32,3);
        Database.setStoryForAnswer(33, 4);
        Database.setStoryForAnswer(34,5);
        Database.setStoryForAnswer(35,6);
        Database.setStoryForAnswer(36,7);
        Database.setStoryForAnswer(37, 8);
        Database.setStoryForAnswer(38,9);
        Database.setStoryForAnswer(39,10);
        Database.setStoryForAnswer(40,11);
        Database.setStoryForAnswer(41, 12);
        Database.setStoryForAnswer(42,13);
        Database.setStoryForAnswer(43,14);
        Database.setStoryForAnswer(44,15);
        Database.setStoryForAnswer(45, 1);
        Database.setStoryForAnswer(46,2);
        Database.setStoryForAnswer(47,3);
        Database.setStoryForAnswer(48,4);
        Database.setStoryForAnswer(49, 5);
        Database.setStoryForAnswer(50,6);
        Database.setStoryForAnswer(51,7);
        Database.setStoryForAnswer(52,8);
        Database.setStoryForAnswer(53, 9);
        Database.setStoryForAnswer(54,10);
        Database.setStoryForAnswer(55,11);
        Database.setStoryForAnswer(56,12);
        Database.setStoryForAnswer(57, 13);
        Database.setStoryForAnswer(58,14);
        Database.setStoryForAnswer(59,15);
        Database.setStoryForAnswer(60,1);

    }


}
