package me.mustache.trade;

import me.mustache.gui.TradeGui;

public class PotTrader extends Trader {

    public PotTrader(String pName){
        super (pName);

        new TradeGui("Herbert der Trankbrauer");
    }


}
