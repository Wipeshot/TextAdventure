package me.mustache.items;

public abstract class Consumable extends Item {


    /**
     * @param name
     * @param description
     * @param id
     */
    public Consumable(String name, String description, int id, EquipSlot slot){
        super(name, description, id, slot);
    }

    public abstract void useItem(); //Abstrakte Operation die den use Effekt des Items festlegen



}
