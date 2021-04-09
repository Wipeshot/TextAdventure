package me.mustache.character;

public class Stats {

    protected int maxHp;
    protected int maxMana;
    protected int armor;
    protected int currHp;
    protected int currMana;
    protected int strength;
    protected int intellect;
    protected int dexterity;
    protected int wisdom;
    protected int charisma;
    protected int perception;

    public Stats(int maxHp, int maxMana, int armor, int currHp, int currMana, int strength, int intellect, int dexterity, int wisdom, int charisma, int perception) {
        this.maxHp = maxHp;
        this.maxMana = maxMana;
        this.armor = armor;
        this.currHp = currHp;
        this.currMana = currMana;
        this.strength = strength;
        this.intellect = intellect;
        this.dexterity = dexterity;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.perception = perception;
    }
    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getCurrHp() {
        return currHp;
    }

    public void setCurrHp(int currHp) {
        this.currHp = currHp;
    }

    public int getCurrMana() {
        return currMana;
    }

    public void setCurrMana(int currMana) {
        this.currMana = currMana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }


}