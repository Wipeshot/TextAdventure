package me.mustache.spells;

public abstract class Spell {

    protected String name;
    protected String desc;
    protected int manaC;

    public Spell(String pName, String pDesc, int pManaC){
        name = pName;
        desc = pDesc;
        manaC = pManaC;

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
