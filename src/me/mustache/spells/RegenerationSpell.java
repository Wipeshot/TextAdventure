package me.mustache.spells;

import me.mustache.character.Stats;
import me.mustache.main.Main;
import java.lang.*;

public class RegenerationSpell extends Spell{

    public RegenerationSpell(){ super("Regenerationszauber", "Heilt dich innerhalb 20 Sekunden um 20LP.", 15);

    }

    @Override
    public void useSpell() {

        Stats stats = Main.thePlayer.getStats();

        int currentH = stats.getCurrHp();
        int maxH = stats.getMaxHp();
        int currentM = stats.getCurrMana();


        for (int i = 0; i < 20; i++) {

            if (currentM > manaC) {
                if (currentH < maxH - 20) {
                    stats.setCurrHp(currentH + 1);
                    stats.setCurrMana(currentM - manaC);
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


