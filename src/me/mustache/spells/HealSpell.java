package me.mustache.spells;

import me.mustache.character.Stats;
import me.mustache.main.Main;

public class HealSpell extends Spell {

    public HealSpell() {
        super("Heilzauber", "Heilt dich um 20LP.", 20);
    }

    @Override
    public void useSpell() {

        Stats stats = Main.thePlayer.getStats();

        int currentH = stats.getCurrHp();
        int maxH = stats.getMaxHp();
        int currentM = stats.getCurrMana();

        if (currentM > manaC) {
            if (currentH < maxH - 20) {
                stats.setCurrHp(currentH + 20);
            } else if (currentH + 20 >= maxH) {
                stats.setCurrHp(maxH);
            }
        }
        stats.setCurrMana(currentM - manaC);
    }
}
