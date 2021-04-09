package me.mustache.items;

public abstract class Staff extends Item {

    private double magicpower;

    public Staff(String pName, String pDesc, int pID, double pMagicpower){
        super(pName, pDesc, pID);

        magicpower = pMagicpower;

    }

    public void setMagicpower(double pMagicpower){
        magicpower = pMagicpower;
    }

    public double getMagicpower(){
        return magicpower;
    }

}
