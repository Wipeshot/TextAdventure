package me.mustache.items;

import me.mustache.character.Stats;
import me.mustache.main.Main;

public class Food extends Consumable{

    private int value;
    public Food(String name, String description, int id, int foodVal){
        super(name, description, id);
        this.value = foodVal;
    }

    public int getFoodVal() {
        return value;
    }

    @Override
    public void useItem() {
        Stats stats = Main.thePlayer.getStats();
        if(stats.getMaxHp() >= stats.getCurrHp() + value){
            stats.setCurrHp(stats.getCurrHp() + value);
        }else{
            stats.setCurrHp(stats.getMaxHp());
        }
    }
}
