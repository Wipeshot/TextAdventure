package me.mustache.consumables;

public abstract class Consumable {

    protected String name;
    protected String description;

    public Consumable(String pName, String pDescription){

        name = pName;
        description = pDescription;
    }

    public abstract void useItem();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }



}
