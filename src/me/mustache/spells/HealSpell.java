package me.mustache.spells;

import me.mustache.character.Health;
import me.mustache.character.Mana;
import me.mustache.main.Main;

public class HealSpell extends Spell {

    public HealSpell() {
        super("Heilzauber", "Heilt dich um 20LP.", 20);
    }

    @Override
    public void useSpell() {

        Health health = Main.thePlayer.getHealth();
        Mana mana = Main.thePlayer.getMana();

        int currentH = health.getHealth();
        int maxH = health.getMaxHealth();
        int currentM = mana.getMana();

        if (currentM > manaC) {
            if (currentH < maxH - 20) {
                health.setHealth(currentH + 20);
            } else if (currentH + 20 >= maxH) {
                health.setHealth(maxH);
            }
        }
        mana.setMana(currentM - manaC);
    }
}
