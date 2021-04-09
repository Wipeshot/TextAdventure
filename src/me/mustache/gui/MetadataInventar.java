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
    private boolean hasPot(String name)
    {
        return getAllCurrentPotsAsStringList().contains(name);
    }
    public void usePot(String name)
    {
        System.out.println(hasPot(name));
        if(hasPot(name))
        {
            pots.get(findPotIndex(name)).useItem();
            pots.remove(findPotIndex(name));
            System.out.println(getAmountOfPot(name));
        }
    }
    public int findPotIndex(String name)
    {
        for (Pot p: pots) {
            if(p.getName().equals(name))
                return pots.indexOf(p);
        }
        return 0;
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
    public ArrayList<String> getAllCurrentPotsAsStringList()
    {
        ArrayList<String> allItems = new ArrayList<>();
        for (Pot pot: pots)
        {
            if(!allItems.contains(pot.getName()))
            {
                allItems.add(pot.getName());
            }
        }
        return allItems;
    }

}