package me.mustache.gui;



import me.mustache.items.Consumable;
import me.mustache.items.Item;

import java.util.ArrayList;

public class MetadataInventar {
    private static ArrayList<Consumable> consumables = new ArrayList<>();

    private static ArrayList<Item> items = new ArrayList<>();
    private static int currentCapacity = consumables.size() + items.size();
    private static int maxCapacity = 50;
    private static MetadataInventar instance = null;
    public static MetadataInventar getInstance() {
        if (instance == null) {
            instance = new MetadataInventar();
        }
        return instance;
    }
    private static boolean canAdd()
    {
        boolean retVal = false;
        if(currentCapacity < maxCapacity) retVal = true;
        return retVal;
    }
    public static void addConsumable(Consumable consumable)
    {
        if(canAdd()) consumables.add(consumable);
    }
    public static void addItem(Item item)
    {
        if(canAdd()) items.add(item);
    }

    private boolean hasConsumable(String name)
    {
        return getAllCurrentConsumablesAsStringList().contains(name);
    }
    public void useConsumable(String name)
    {
        System.out.println(hasConsumable(name));
        if(hasConsumable(name))
        {
            consumables.get(findConsumableIndex(name)).useItem();
            consumables.remove(findConsumableIndex(name));
            System.out.println(getAmountOfConsumable(name));
        }
    }
    public void equipItem(String name)
    {
        System.out.println(hasConsumable(name));
        if(hasConsumable(name))
        {
            consumables.get(findConsumableIndex(name)).useItem();
            consumables.remove(findConsumableIndex(name));
            System.out.println(getAmountOfConsumable(name));
        }
    }
    public int findConsumableIndex(String name)
    {
        for (Consumable p: consumables) {
            if(p.getName().equals(name))
                return consumables.indexOf(p);
        }
        return 0;
    }

    public int findItemIndex(String name)
    {
        for (Item i: items) {
            if(i.getName().equals(name))
                return consumables.indexOf(i);
        }
        return 0;
    }

    public int getAmountOfConsumable(String name)
    {
        int count =0;
        for (Consumable p: consumables) {
            if(p.getName().equals(name))
                count++;
        }
        return count;
    }
    public int getAmountOfItem(String name)
    {
        int count =0;
        for (Item i: items) {
            if(i.getName().equals(name))
                count++;
        }
        return count;
    }
    public ArrayList<String> getAllCurrentConsumablesAsStringList()
    {
        ArrayList<String> allItems = new ArrayList<>();
        for (Consumable consumable : consumables)
        {
            if(!allItems.contains(consumable.getName()))
            {
                allItems.add(consumable.getName());
            }
        }
        return allItems;

    }
    public ArrayList<String> getAllCurrentItemsAsStringList()
    {
        ArrayList<String> allItems = new ArrayList<>();
        for (Item item: items)
        {
            if(!allItems.contains(item.getName()))
            {
                allItems.add(item.getName());
            }
        }
        return allItems;
    }

}