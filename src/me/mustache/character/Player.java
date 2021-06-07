package me.mustache.character;
import me.mustache.balance.*;
import me.mustache.items.Item;

public class Player {

    private Hunger hunger;
    private static String name;
    private boolean alive;



    private Currency currency;

    private Stats stats;

    public Player() {
        stats = new Stats(100,100,0,100,100,10,10,10,10,10,10);
        hunger = new Hunger();
        currency = new Currency(100);
    }

    public void setName(String pName) {
        name = pName;
    }

    public static String getName() {
        return name;
    }

    public void setAlive(boolean pAlive) {
        alive = pAlive;
    }

    public boolean isAlive() {
        return alive;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Hunger getHunger() {
        return hunger;
    }

    public void setHunger(Hunger pHunger) {
        hunger = pHunger;
    }

    public Hunger getMaxHunger() {
        return hunger;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void equipItem(Item item)
    {

    }
    public void unequipItem(Item item)
    {

    }

    public void canEquip(Item item)
    {

    }
}