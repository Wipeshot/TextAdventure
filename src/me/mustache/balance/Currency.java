package me.mustache.balance;

public class Currency {

    private int gold = 0;

    /**
     * @param pGold
     */
    public Currency(int pGold){

        gold = pGold;

    }

    /**
     * @param gold
     */
    public void increaseGold(int gold){
        this.gold = this.gold+gold;

    }

    /**
     * @param gold
     */
    public void decreaseGold(int gold){
        this.gold = this.gold-gold;
    }

    /**
     * @param gold
     * @return enough money true/false
     */
    public boolean checkMoney(int gold){
        return (gold < this.gold)? true : false;
    }


    /**
     * @return gold
     */
    public int getGold(){
        return gold;
    }


    /**
     * @param gold
     */
    public void setGold(int gold){
        this.gold = gold;
    }

}
