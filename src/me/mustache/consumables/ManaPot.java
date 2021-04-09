package me.mustache.consumables;

import me.mustache.character.Stats;
import me.mustache.gui.MetadataInventar;
import me.mustache.main.Main;

public class ManaPot extends Consumable {


    public ManaPot(){
        super("Manatrank ", "Dieser Trank erhöht dein Mana um 20");

    }

    MetadataInventar inv = MetadataInventar.getInstance();
    @Override
    public void useItem() {

        Stats stats = Main.thePlayer.getStats();

        int currentM = stats.getCurrMana();
        int maxM = stats.getMaxMana();

        if(inv.getAmountOfConsumable(name) >= 1) {
            if (currentM < maxM - 20) {
                stats.setCurrMana(currentM + 20);
            } else if (currentM + 20 >= maxM) {
                stats.setCurrMana(maxM);
            }
        }
    }

}
