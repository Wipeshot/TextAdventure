package me.mustache.items;

import me.mustache.character.Hunger;
import me.mustache.main.Main;

public class Food extends Consumable{

    private int foodVal;
    public Food(String name, String description, int id, int foodVal){
        super(name, description, id);
        this.foodVal = foodVal;
    }

    public int getFoodVal() {
        return foodVal;
    }

    @Override
    public void useItem() {
        Hunger hunger = Main.thePlayer.getHunger();
        if(hunger.getHunger() + foodVal <= hunger.getMaxHunger()){
            hunger.setHunger(hunger.getHunger() + foodVal);
        } else {
            hunger.setHunger(hunger.getMaxHunger());
        }
    }
}
