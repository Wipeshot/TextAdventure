package me.mustache.spells;

import me.mustache.character.Health;
import me.mustache.character.Mana;
import me.mustache.main.Main;

public class RegenerationSpell extends Spell{

    public RegenerationSpell(){ super("Regenerationszauber", "Heilt dich innerhalb einiger Sekunden um 20LP.", 15);

    }

    public void useSpell() {

        Health health = Main.thePlayer.getHealth();
        Mana mana = Main.thePlayer.getMana();

        if (mana.getMana() > manaC) {
            if (health.getHealth() < health.getMaxHealth() - 20) {
                health.setHealth(health.getHealth() + 1);
            }
            }
        }
        mana.setMana(mana.getMana() - manaC);
    }

}
