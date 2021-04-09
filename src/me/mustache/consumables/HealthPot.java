package me.mustache.consumables;

import me.mustache.character.Stats;
import me.mustache.gui.MetadataInventar;
import me.mustache.main.Main;

public class HealthPot extends Consumable {

    public HealthPot() {
        super("Heiltrank", "Dieser Trank heilt dich um 20LP.");


    }
    MetadataInventar inv = MetadataInventar.getInstance();


    @Override
    public void useItem() {

        Stats stats = Main.thePlayer.getStats();

        int currentH = stats.getCurrHp();
        int maxH = stats.getMaxHp();

        if(inv.getAmountOfConsumable(name) >= 1) {
            if (currentH < maxH - 20) {
                stats.setCurrHp(currentH + 20);
            } else if (currentH + 20 >= maxH) {
                stats.setCurrHp(maxH);
            }
            System.out.println(stats.getCurrHp());
        }
    }

}
