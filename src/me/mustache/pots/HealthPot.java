package me.mustache.pots;

import me.mustache.character.Health;
import me.mustache.gui.MetadataInventar;
import me.mustache.main.Main;

public class HealthPot extends Pot {

    public HealthPot() {
        super("Heiltrank", "Dieser Trank heilt dich um 20LP.");


    }
    MetadataInventar inv = MetadataInventar.getInstance();


    @Override
    public void useItem() {

        Health health = Main.thePlayer.getHealth();

        int currentH = health.getHealth();
        int maxH = health.getMaxHealth();

        if(inv.getAmountOfPot(name) >= 1) {
            if (currentH < maxH - 20) {
                health.setHealth(currentH + 20);
            } else if (currentH + 20 >= maxH) {
                health.setHealth(maxH);
            }
            System.out.println(health.getHealth());
        }
    }

}
