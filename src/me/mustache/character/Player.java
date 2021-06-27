package me.mustache.character;
import me.mustache.balance.*;
import me.mustache.gui.MetadataInventar;
import me.mustache.items.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    //private Hunger hunger;

    private String name;
    private boolean alive;
    private HashMap equipedItems = new HashMap();

    private void initEquip()
    {
        equipedItems.put(Item.EquipSlot.WEAPON,null);
        equipedItems.put(Item.EquipSlot.BOOTS,null);
        equipedItems.put(Item.EquipSlot.CHEST,null);
        equipedItems.put(Item.EquipSlot.HELMET,null);
        equipedItems.put(Item.EquipSlot.LEGS,null);
    }

    private static Player instance = null;
    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }



    private Currency currency;

    private Stats stats;

    public Player() {
        stats = new Stats(100,100,0,100,100,10,10,10,10,10,10); //Setzt die start stats
        //hunger = new Hunger();
        currency = new Currency(100);
        initEquip();
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    public boolean checkDeath(){
        return (stats.getCurrHp() <= 0)? true : false;
    }

    /**
     * @return currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /*public Hunger getHunger() {
        return hunger;
    }

    public void setHunger(Hunger hunger) {
        this.hunger = hunger;
    }

    public Hunger getMaxHunger() {
        return hunger;
    }*/

    /**
     * @return stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * @param stats
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * @param item
     */
    public void equipItem(Item item)
    {
        equipedItems.put(item.getSlot(),item);
    }

    /**
     * @param item
     */
    public void unequipItem(Item item)
    {
        equipedItems.remove(item.getSlot());
    }

    /**
     * @param item
     */
    public boolean canEquip(Item item)
    {
        return equipedItems.containsKey(item.getSlot()) ? false : true;
    }
}