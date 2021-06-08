package me.mustache.items;

public class Potion extends Consumable{

    private int type;
    private int value;

    public Potion(String name, String desc, int id, int value, int type){
        super(name, desc, id);

        this.type = type;
        this.value = value;

    }

    public int getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void useItem() {

    }
}
