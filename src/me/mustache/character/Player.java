package me.mustache.character;

public class Player {

    private Health health;
    private Mana mana;
    private Hunger hunger;
    private static String name;

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

    public void setName(String pName){
        name = pName;
    }

    public static String getName(){
        return name;
    }
}
