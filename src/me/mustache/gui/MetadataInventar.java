package me.mustache.gui;



import me.mustache.database.Database;
import me.mustache.items.Consumable;
import me.mustache.items.Item;

import java.util.ArrayList;

public class MetadataInventar {
    private ArrayList<Consumable> consumables = new ArrayList<>();

    private ArrayList<Item> shopItems = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private int currentCapacity = consumables.size() + items.size() ;
    private int maxCapacity = 50;
    private static MetadataInventar instance = null;
    public static MetadataInventar getInstance() {
        if (instance == null) {
            instance = new MetadataInventar();
        }
        return instance;
    }

    /**
     * @return can add more Items?
     */
    private boolean canAdd()
    {
        boolean retVal = false;
        if(currentCapacity < maxCapacity) retVal = true;
        currentCapacity = consumables.size() + items.size();
        return retVal;
    }

    /**
     * @param consumable
     */
    public void addConsumable(Consumable consumable)
    {
        if(canAdd()) consumables.add(consumable);
    }

    /**
     * @param item
     */
    public void addItem(Item item)
    {
        if(canAdd()){
            items.add(item);
    }
    }

    /**
     * @param name
     * @return consumables
     */
    private boolean hasConsumable(String name)
    {
        return getAllCurrentConsumablesAsStringList().contains(name);
    }

    /**
     * @param name
     */
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

    /**
     * @param name
     */
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

    /**
     * @param name
     * @return consumable Index
     */
    public int findConsumableIndex(String name)
    {
        for (Consumable p: consumables) {
            if(p.getName().equals(name))
                return consumables.indexOf(p);
        }
        return 0;
    }

    /**
     * @param name
     * @return item Index
     */
    public int findItemIndex(String name)
    {
        for (Item i: items) {
            if(i.getName().equals(name))
                return consumables.indexOf(i);
        }
        return 0;
    }

    /**
     * @param name
     * @return amount of consumables
     */
    public int getAmountOfConsumable(String name)
    {
        int count =0;
        for (Consumable p: consumables) {
            if(p.getName().equals(name))
                count++;
        }
        return count;
    }

    /**
     * @param name
     * @return amount of Items
     */
    public int getAmountOfItem(String name)
    {
        int count =0;
        for (Item i: items) {
            if(i.getName().equals(name))
                count++;
        }
        return count;
    }

    /**
     * @return consumables
     */
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

    /**
     * @return items
     */
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