package me.mustache.character;

public class Player {

    private Health health;
    private Mana mana;
    private Hunger hunger;

    public Player(){
        health = new Health();
        mana = new Mana();
        hunger = new Hunger();
    }

    public Health getHealth() {
        return health;
    }

    public Mana getMana() {
        return mana;
    }

    public Hunger getHunger(){
        return hunger;
    }
}
