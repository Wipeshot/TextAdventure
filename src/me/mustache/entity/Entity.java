package me.mustache.entity;

import me.mustache.character.Stats;

public abstract class Entity {

    protected Stats stats;
    protected boolean affinity;
    protected String name;
    protected String desc;

    public Entity(String name, String desc, int maxHP, int currentHP, int armor, int strenght, boolean affinity){
        stats = new Stats(maxHP, 0, armor, currentHP, 0, strenght, 0, 0, 0, 0, 0);

        this.affinity = affinity;
        this.name = name;
        this.desc = desc;

    }

}
