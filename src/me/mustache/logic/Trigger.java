package me.mustache.logic;

import me.mustache.database.Database;
import me.mustache.entity.Entity;

public class Trigger {

    static Entity wolf;
    static Entity monster;
    static Entity bär;
    static Entity dieb;

    public Trigger(){

    }

    public void useTrigger(int answerId){
        int triggerId = Database.getTriggerIdByAnswerId(answerId);

        if(triggerId == 1){
            wolf = Database.createEntity(11);
        }else if (triggerId == 2){
            monster = Database.createEntity(1);
        }else if (triggerId == 3){
            bär = Database.createEntity(12);
        }else if (triggerId == 4 ){ //Deathscreen existiert noch nicht

        }else if (triggerId == 5){
            dieb = Database.createEntity(13);
        }else if (triggerId == 6) { //Winscreen (Wahrscheinlich nur Einbildung, das Bett ist so gemütlich und du so müde das du nicht mehr genügend Zeit hast darüber nachzudenken da schläfst du schon.) existiert noch nicht

        } else if (triggerId == 7){ //Winscreen (Unser kleiner Held.) existiert noch nicht.

        }

    }


}
