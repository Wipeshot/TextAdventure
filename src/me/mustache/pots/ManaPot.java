package me.mustache.pots;

import me.mustache.character.Mana;
import me.mustache.gui.MetadataInventar;
import me.mustache.main.Main;

public class ManaPot extends Pot {


    public ManaPot(){
        super("Manatrank ", "Dieser Trank erhöht dein Mana um 20");

    }

    MetadataInventar inv = MetadataInventar.getInstance();
    @Override
    public void useItem() {

        Mana mana = Main.thePlayer.getMana();

        int currentM = mana.getMana();
        int maxM = mana.getMaxMana();

        if(inv.getAmountOfPot(name) >= 1) {
            if (currentM < maxM - 20) {
                mana.setMana(currentM + 20);
            } else if (currentM + 20 >= maxM) {
                mana.setMana(maxM);
            }
        }
    }

}
