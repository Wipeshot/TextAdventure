package me.mustache.balance;


public class Currency {

    private int gold = 0;

    public Currency(int pGold){

        gold = pGold;

    }

    public void increaseGold(int gold){
        this.gold = this.gold+gold;

    }

    public void decreaseGold(int gold){
        this.gold = this.gold-gold;
    }

    public boolean checkMoney(int gold){
        boolean goodToGo;
        if(gold < this.gold){
            goodToGo = true;
        } else {
            goodToGo = false;
        }
        return goodToGo;
    }



    public int getGold(){
        return gold;
    }


    public void setGold(int gold){
        this.gold = gold;
    }

}
