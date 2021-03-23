package me.mustache.food;

import me.mustache.character.Hunger;
import me.mustache.character.Player;
import me.mustache.main.Main;

public class Bread extends Food{

    private int hungerC;

    public Bread(){
        super ("Brot", "Ein billiges Gebäck.", 20);

    }

    @Override
    public void useFood(){

        Hunger hunger = Main.thePlayer.getHunger();


        int currentH = hunger.getHunger();
        int maxH = hunger.getMaxHunger();

        if(currentH < maxH-hungerC){
            hunger.setHunger(currentH+hungerC);
        }
    }

}
