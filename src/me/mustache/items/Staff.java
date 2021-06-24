package me.mustache.items;

public class Staff extends Item {

    private double magicpower;

    /**
     * @param name 
     * @param desc
     * @param id
     * @param magicpower
     */
    public Staff(String name, String desc, int id, double magicpower){
        super(name, desc, id);

        this.magicpower = magicpower;

    }

    /**
     * @param magicpower
     */
    public void setMagicpower(double magicpower){
        this.magicpower = magicpower;
    }

    /**
     * @return magicpower
     */
    public double getMagicpower(){
        return magicpower;
    }

}
