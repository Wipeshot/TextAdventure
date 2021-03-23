package me.mustache.spells;

import me.mustache.character.Health;
import me.mustache.character.Mana;
import me.mustache.main.Main;
import java.lang.*;

public class RegenerationSpell extends Spell{

    public RegenerationSpell(){ super("Regenerationszauber", "Heilt dich innerhalb 20 Sekunden um 20LP.", 15);

    }

    @Override
    public void useSpell() {

        Health health = Main.thePlayer.getHealth();
        Mana mana = Main.thePlayer.getMana();

        int currentH = health.getHealth();
        int maxH = health.getMaxHealth();
        int currentM = mana.getMana();


        for (int i = 0; i < 20; i++) {

            if (currentM > manaC) {
                if (currentH < maxH - 20) {
                    health.setHealth(currentH + 1);
                    mana.setMana(currentM - manaC);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


