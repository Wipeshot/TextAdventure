package me.mustache.pots;

public abstract class Pot {

    protected String name;
    protected String description;

    public Pot(String pName,String pDescription){

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
