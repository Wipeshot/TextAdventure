package me.mustache.character;

import java.util.Timer;
import java.util.TimerTask;

public class Hunger {


    protected int maxHunger = 100;
    protected int Hunger = 100;

    private final Timer timer = new Timer();

    public Hunger() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                setHunger(getHunger()-2);
            }
        }, 10000, 10000);
    }


    //Set-Operationen
    public void setMaxHunger(int pMaxHunger) {
        maxHunger = pMaxHunger;
    }

    public void setHunger(int pHunger) {
        Hunger = pHunger;
    }


    //Get-Operationen
    public int getMaxHunger() {
        return maxHunger;
    }

    public int getHunger() {
        return Hunger;
    }
}