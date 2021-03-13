package me.mustache.pots;

import me.mustache.character.Health;
import me.mustache.main.Main;

public class HealthPot extends Pot {

    public HealthPot() {
        super("Heiltrank", "Dieser Trank heilt dich um 20LP.");


    }



    @Override
    public void useItem() {

        Health health = Main.thePlayer.getHealth();

        if(health.getHealth() < health.getMaxHealth()-20) {
            health.setHealth(health.getHealth() + 20);
        } else if (health.getHealth()+20>= health.getMaxHealth()){
            health.setHealth(health.getMaxHealth());
        }
    }
}
