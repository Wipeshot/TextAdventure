package me.mustache.consumables;

import me.mustache.character.Hunger;
import me.mustache.main.Main;

public class Bread extends Consumable{

    private int hungerC = 20;
    public Bread(){
        super ("Brot", "Ein billiges Gebäck.");

    }


    @Override
    public void useItem()
    {
        Hunger hunger = Main.thePlayer.getHunger();


        int currentH = hunger.getHunger();
        int maxH = hunger.getMaxHunger();

        if(currentH < maxH-hungerC){
            hunger.setHunger(currentH+hungerC);
        }
    }
}
