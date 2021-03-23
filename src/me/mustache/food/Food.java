package me.mustache.food;

public abstract class Food {

    protected int hungerC;

    public Food(String pName, String pBeschreibung, int pHunger){

        hungerC = pHunger;

    }

    public abstract void useFood();

}
