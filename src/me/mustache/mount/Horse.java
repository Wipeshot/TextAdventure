package me.mustache.mount;

public class Horse {

    String name;
    boolean owner;
    double speed;

    public Horse(String pName, boolean pOwner){
        owner = pOwner;
        name = pName;
        speed = 1.25;

    }



    public void setName(String pName){
        name = pName;
    }

    public void setOwner(boolean pOwner){
        owner = pOwner;
    }

    public void setSpeed(double pSpeed){
        speed = pSpeed;
    }

    public String getName(){
        return name;
    }

    public boolean getOwner(){
        return owner;
    }

    public double getSpeed(){
        return speed;
    }

}
