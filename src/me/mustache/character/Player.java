package me.mustache.character;
import me.mustache.balance.*;
import me.mustache.items.Item;

public class Player {

    //private Hunger hunger;
    private String name;
    private boolean alive;



    private Currency currency;

    private Stats stats;

    public Player() {
        stats = new Stats(100,100,0,100,100,10,10,10,10,10,10); //Setzt die start stats
        //hunger = new Hunger();
        currency = new Currency(100);
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

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
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

    }

    /**
     * @param item
     */
    public void unequipItem(Item item)
    {

    }

    /**
     * @param item
     */
    public void canEquip(Item item)
    {

    }
}