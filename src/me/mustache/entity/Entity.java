package me.mustache.entity;

import me.mustache.character.Stats;

public class Entity {



    private Stats stats;
    private boolean affinity;
    private String name;
    private String desc;

    /**
     * @param name
     * @param desc
     * @param maxHP
     * @param currentHP
     * @param armor
     * @param strenght
     * @param affinity
     */
    public Entity(String name, String desc, int maxHP, int currentHP, int armor, int strenght, boolean affinity){
        stats = new Stats(maxHP, 0, armor, currentHP, 0, strenght, 0, 0, 0, 0, 0);

        this.affinity = affinity;
        this.name = name;
        this.desc = desc;

    }

    /**
     * @return stats
     */
    public Stats getStats() {
        return stats;
    }
}
