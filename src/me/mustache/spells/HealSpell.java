package me.mustache.spells;

import me.mustache.character.Health;
import me.mustache.character.Mana;
import me.mustache.main.Main;

public class HealSpell extends Spell {

    public HealSpell() {
        super("Heilzaber", "Heilt dich um 20LP.", 20);
    }

    @Override
    public void useSpell() {

        Health health = Main.thePlayer.getHealth();
        Mana mana = Main.thePlayer.getMana();

        if (mana.getMana() > manaC) {
            if (health.getHealth() < health.getMaxHealth() - 20) {
                health.setHealth(health.getHealth() + 20);
            } else if (health.getHealth() + 20 >= health.getMaxHealth()) {
                health.setHealth(health.getMaxHealth());
            }
        }
        mana.setMana(mana.getMana() - manaC);
    }
}
