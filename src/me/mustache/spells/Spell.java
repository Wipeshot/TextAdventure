package me.mustache.spells;

public abstract class Spell {

    protected String name;
    protected String desc;
    protected int manaC;

    public Spell(String name, String desc, int manaC){
        this.name = name;
        this.desc = desc;
        this.manaC = manaC;

    }

    public abstract void useSpell();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return desc;
    }

    public int getManaC() {
        return manaC;
    }
}
