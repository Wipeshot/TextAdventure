package me.mustache.items;

public abstract class Consumable extends Item {


    public Consumable(String name, String description, int id){
        super(name, description, id);
    }

    public abstract void useItem();



}
