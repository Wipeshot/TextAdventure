package me.mustache.logic;

import me.mustache.database.Database;
import me.mustache.entity.Entity;
import me.mustache.gui.Deathscreen;
import me.mustache.gui.Gui;

public class Trigger {

    static Entity wolf;
    static Entity monster;
    static Entity bär;
    static Entity dieb;

    public Trigger(){

    }

    public static void useTrigger(int answerId){
        int triggerId = Database.getTriggerIdByAnswerId(answerId);


        if(triggerId == 1){
            wolf = Database.createEntity(11);
            //Gui.getInstance().setupFightscreen(wolf);
        }else if (triggerId == 2){
            monster = Database.createEntity(1);
            //Gui.getInstance().setupFightscreen(monster);
        }else if (triggerId == 3){
            bär = Database.createEntity(12);
            //Gui.getInstance().setupFightscreen(bär);
        }else if (triggerId == 4 ){
            Gui.getInstance().dispose();
            new Deathscreen();
        }else if (triggerId == 5){
            dieb = Database.createEntity(13);
            //Gui.getInstance().setupFightscreen(dieb);
        }else if (triggerId == 6) { //Winscreen (Wahrscheinlich nur Einbildung, das Bett ist so gemütlich und du so müde das du nicht mehr genügend Zeit hast darüber nachzudenken da schläfst du schon.) existiert noch nicht

        } else if (triggerId == 7){ //Winscreen (Unser kleiner Held.) existiert noch nicht.

        }

    }


}
