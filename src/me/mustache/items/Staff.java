package me.mustache.items;

public class Staff extends Item {

    private double magicpower;

    public Staff(String name, String desc, int id, double magicpower){
        super(name, desc, id);

        this.magicpower = magicpower;

    }

    public void setMagicpower(double magicpower){
        this.magicpower = magicpower;
    }

    public double getMagicpower(){
        return magicpower;
    }

}
