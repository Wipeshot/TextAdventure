package me.mustache.items;

import me.mustache.character.Player;
import me.mustache.character.Stats;
import me.mustache.main.Main;

public class Potion extends Consumable{

    private int type;
    private int value;
    Stats stats = Player.getInstance().getStats();

    /**
     * @param name
     * @param desc
     * @param id
     * @param value
     * @param type
     */
    public Potion(String name, String desc, int id, int value, int type,EquipSlot slot){
        super(name, desc, id,slot);

        this.type = type;
        this.value = value;

    }

    /**
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * @return value
     */
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
