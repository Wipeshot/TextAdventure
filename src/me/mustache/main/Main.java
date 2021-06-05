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

        Database.createStory();
        Database.insertIntoAnswer("Antwort 1");
        Database.insertIntoAnswer("Antwort 2");
        Database.insertIntoAnswer("Antwort 3");
        Database.insertIntoAnswer("Antwort 4");
        Database.insertIntoAnswer("Antwort 5");
        Database.insertIntoAnswer("Antwort 6");
        Database.insertIntoAnswer("Antwort 7");
        Database.insertIntoAnswer("Antwort 8");
        Database.insertIntoAnswer("Antwort 9");
        Database.insertIntoAnswer("Antwort 10");
        Database.insertIntoAnswer("Antwort 11");
        Database.insertIntoAnswer("Antwort 12");
        Database.insertIntoAnswer("Antwort 13");
        Database.insertIntoAnswer("Antwort 14");
        Database.insertIntoAnswer("Antwort 15");
        Database.insertIntoAnswer("Antwort 16");
        Database.insertIntoAnswer("Antwort 17");
        Database.insertIntoAnswer("Antwort 18");
        Database.insertIntoAnswer("Antwort 19");
        Database.insertIntoAnswer("Antwort 20");
        Database.insertIntoAnswer("Antwort 21");
        Database.insertIntoAnswer("Antwort 23");
        Database.insertIntoAnswer("Antwort 24");
        Database.insertIntoAnswer("Antwort 25");
        Database.insertIntoAnswer("Antwort 26");
        Database.insertIntoAnswer("Antwort 27");
        Database.insertIntoAnswer("Antwort 28");
        Database.insertIntoAnswer("Antwort 29");
        Database.insertIntoAnswer("Antwort 30");
        Database.insertIntoAnswer("Antwort 31");
        Database.insertIntoAnswer("Antwort 32");
        Database.insertIntoAnswer("Antwort 33");
        Database.insertIntoAnswer("Antwort 34");
        Database.insertIntoAnswer("Antwort 35");
        Database.insertIntoAnswer("Antwort 36");
        Database.insertIntoAnswer("Antwort 37");
        Database.insertIntoAnswer("Antwort 38");
        Database.insertIntoAnswer("Antwort 39");
        Database.insertIntoAnswer("Antwort 40");
        Database.insertIntoAnswer("Antwort 41");
        Database.insertIntoAnswer("Antwort 42");
        Database.insertIntoAnswer("Antwort 43");
        Database.insertIntoAnswer("Antwort 44");
        Database.insertIntoAnswer("Antwort 45");
        Database.insertIntoAnswer("Antwort 46");
        Database.insertIntoAnswer("Antwort 47");
        Database.insertIntoAnswer("Antwort 48");
        Database.insertIntoAnswer("Antwort 49");
        Database.insertIntoAnswer("Antwort 50");
        Database.insertIntoAnswer("Antwort 51");
        Database.insertIntoAnswer("Antwort 52");
        Database.insertIntoAnswer("Antwort 53");
        Database.insertIntoAnswer("Antwort 54");
        Database.insertIntoAnswer("Antwort 55");
        Database.insertIntoAnswer("Antwort 56");
        Database.insertIntoAnswer("Antwort 57");
        Database.insertIntoAnswer("Antwort 58");
        Database.insertIntoAnswer("Antwort 59");
        Database.insertIntoAnswer("Antwort 60");

        Database.insertIntoStory("Story 1", "1,2,3,4");
        Database.insertIntoStory("Story 2", "5,6,7,8");
        Database.insertIntoStory("Story 3", "9,10,11,12");
        Database.insertIntoStory("Story 4", "13,14,15,16");
        Database.insertIntoStory("Story 5", "17,18,19,20");
        Database.insertIntoStory("Story 6", "21,22,23,24");
        Database.insertIntoStory("Story 7", "25,26,27,28");
        Database.insertIntoStory("Story 8", "29,30,31,32");
        Database.insertIntoStory("Story 9", "33,34,35,36");
        Database.insertIntoStory("Story 10", "37,38,39,40");
        Database.insertIntoStory("Story 11", "41,42,43,44");
        Database.insertIntoStory("Story 12", "45,46,47,48");
        Database.insertIntoStory("Story 13", "49,50,51,52");
        Database.insertIntoStory("Story 14", "53,54,55,56");
        Database.insertIntoStory("Story 15", "57,58,59,60");



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
