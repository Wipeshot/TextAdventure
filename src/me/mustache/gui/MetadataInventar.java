package me.mustache.gui;



import me.mustache.pots.Pot;

import java.util.ArrayList;

public class MetadataInventar {
    private static ArrayList<Pot> pots = new ArrayList<>();
    private static MetadataInventar instance = null;
    public static MetadataInventar getInstance() {
        if (instance == null) {
            instance = new MetadataInventar();
        }
        return instance;
    }
    public static void addPot(Pot pot)
    {
        pots.add(pot);
    }
    private boolean hasPot()
    {
        return !pots.isEmpty();
    }
    public void useHealthPot()
    {
        if(hasPot())
        {
            pots.get(0).useItem();
            pots.remove(0);
        }
    }

    public Pot getHealthPot()
    {
        if(hasPot())
        {
            return pots.get(0);
        }
        return pots.get(0);

    }
    public int getAmountOfPot(String name)
    {
        int count =0;
        for (Pot p: pots) {
            if(p.getName().equals(name))
                count++;
        }
        return count;
    }

}