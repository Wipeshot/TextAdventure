package me.mustache.balance;

import me.mustache.trade.Trader;

public class Currency {

    private int gold = 0;

    public Currency(int pGold){

        gold = pGold;

    }

    public void increaseGold(int pGold){
        gold = gold+pGold;

    }

    public void decreaseGold(int pGold){
        gold = gold-pGold;
    }

    public void checkMoney(int pGold, int pSilver){
        if(pGold < gold) Trader.buyable = true;
    }



    public int getGold(){
        return gold;
    }


    public void setGold(int pGold){
        gold = pGold;
    }

}
