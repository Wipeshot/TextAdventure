package me.mustache.pots;

import me.mustache.character.Mana
import me.mustache.main.Main;

public class ManaPot extends Pot {

    public ManaPot(){
        super("Manatrank", "Dieser Trank erhöht dein Mana um 20");

    }

    @Override
    public void useItem() {

        Mana mana = Main.thePlayer.getMana();

        int currentM = mana.getMana();
        int maxM = mana.getMaxMana();

        if(numInInventory >= 1) {
            if (currentM < maxM - 20) {
                mana.setMana(currentM + 20);
            } else if (currentM + 20 >= maxM) {
                mana.setHealth(maxM);
            }
        }else {
            return;
        }
    }

}
