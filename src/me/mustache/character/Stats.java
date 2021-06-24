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

    /**
     * @param maxHp
     * @param maxMana
     * @param armor
     * @param currHp
     * @param currMana
     * @param strength
     * @param intellect
     * @param dexterity
     * @param wisdom
     * @param charisma
     * @param perception
     */
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

    /**
     * @return maxHp
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * @param maxHp
     */
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    /**
     * @return maxMana
     */
    public int getMaxMana() {
        return maxMana;
    }

    /**
     * @param maxMana
     */
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    /**
     * @return armor
     */
    public int getArmor() {
        return armor;
    }

    /**
     * @param armor
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * @return currentHp
     */
    public int getCurrHp() {
        return currHp;
    }

    /**
     * @param currHp
     */
    public void setCurrHp(int currHp) {
        this.currHp = currHp;
    }

    /**
     * @return currentMana
     */
    public int getCurrMana() {
        return currMana;
    }

    /**
     * @param currMana
     */
    public void setCurrMana(int currMana) {
        this.currMana = currMana;
    }

    /**
     * @return strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * @return intellect
     */
    public int getIntellect() {
        return intellect;
    }

    /**
     * @param intellect
     */
    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    /**
     * @return dexterity
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * @param dexterity
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * @return wisdom
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * @param wisdom
     */
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * @return charisma
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * @param charisma
     */
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    /**
     * @return perception
     */
    public int getPerception() {
        return perception;
    }

    /**
     * @param perception 
     */
    public void setPerception(int perception) {
        this.perception = perception;
    }


}