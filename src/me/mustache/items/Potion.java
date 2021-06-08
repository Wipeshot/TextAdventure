package me.mustache.items;

import me.mustache.character.Stats;
import me.mustache.main.Main;

public class Potion extends Consumable{

    private int type;
    private int value;
    Stats stats = Main.thePlayer.getStats();

    public Potion(String name, String desc, int id, int value, int type){
        super(name, desc, id);

        this.type = type;
        this.value = value;

    }

    public int getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void useItem() {
        if(type == 1){
            if(stats.getMaxHp() >= stats.getCurrHp() + value){
                stats.setCurrHp(stats.getCurrHp() + value);
            }else{
                stats.setCurrHp(stats.getMaxHp());
            }
        } else if(type == 2){
            if(stats.getMaxMana() >= stats.getCurrMana() + value){
                stats.setCurrMana(stats.getCurrMana() + value);
            }
        }
    }
}
