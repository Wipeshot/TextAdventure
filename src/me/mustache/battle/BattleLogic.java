package me.mustache.battle;
import me.mustache.character.*;
import me.mustache.balance.*;
import me.mustache.entity.*;
import java.util.Random;
import me.mustache.gui.Gui;
public class BattleLogic {


        private Player player;
      static Gui gui;

        public BattleLogic(Player player)
        {
            this.player = player;
        }


    /**
     * @param enemy
     */
        public void fightHero(Entity enemy)//Gegner greift an
        {

            if(enemy != null)
            {

                int calculatedDamageEnemy = enemy.getStats().getStrength()/player.getStats().getArmor();
                if(gotHit(player.getStats().getDexterity()) == true)
                {
                    if(criticalHit(enemy.getStats().getDexterity(), enemy.getStats().getPerception()) == true)
                    {
                        player.getStats().setCurrHp((int)(player.getStats().getCurrHp()-(calculatedDamageEnemy*1.5)));
                        gui.getInstance().addToStory("Kritisch getroffen!");
                        gui.getInstance().addToStory("Schaden an dem Helden:" + String.valueOf(calculatedDamageEnemy*1.5f));

                    }
                    else
                    {
                        player.getStats().setCurrHp(player.getStats().getCurrHp()-calculatedDamageEnemy);
                        gui.getInstance().addToStory("Schaden an dem Helden:" + String.valueOf(calculatedDamageEnemy));

                    }
                }
                else
                {
                    gui.getInstance().addToStory("Gegner hat verfehlt!");
                    calculatedDamageEnemy = 0;
                    gui.getInstance().addToStory("Schaden an dem Helden:" + String.valueOf(calculatedDamageEnemy));

                }
            }
        }

    /**
     * @param enemy
     */
        public void fightEnemy(Entity enemy) //Held greift an
        {

            if(enemy != null)
            {
                int calculatedDamageHero = player.getStats().getStrength()/enemy.getStats().getArmor(); //Schaden den der Held macht

                if(gotHit(enemy.getStats().getDexterity()) == true)
                {
                    if(criticalHit(player.getStats().getDexterity(),player.getStats().getPerception()) == true)
                    {
                        gui.getInstance().addToStory("Kritisch getroffen!");
                        enemy.getStats().setCurrHp((int)(enemy.getStats().getCurrHp()-(calculatedDamageHero*1.5f)));
                        gui.getInstance().addToStory("Schaden an dem Gegner:" + String.valueOf(calculatedDamageHero*1.5f));

                    }
                    else
                    {
                        enemy.getStats().setCurrHp(enemy.getStats().getCurrHp()-calculatedDamageHero);
                        gui.getInstance().addToStory("Schaden an dem Gegner:" + String.valueOf(calculatedDamageHero));
                    }
                }
                else{
                    gui.getInstance().addToStory("Held hat verfehlt!");
                    calculatedDamageHero = 0;
                    gui.getInstance().addToStory("Schaden an dem Gegner:" + String.valueOf(calculatedDamageHero));

                }
                if(enemy.getStats().getCurrHp() <=0)//wenn gegner tot ist verschwindet er und der spieler bekommt gold/exp
                {
                    player.getStats().setPerception(player.getStats().getPerception()+ enemy.getStats().getPerception());
                        gui.getInstance().addToStory("players perception is now big dick");

                    player.getCurrency().setGold((int)Math.round(enemy.getStats().getPerception()*0.5));
                }
            }
        }

    /**
     * @param dex
     * @param perception
     * @return
     */
        private boolean criticalHit(int dex,int perception) //Methode um zu bestimmen ob Kritisch getroffen wurde
        {
            if(dex <=0)
            {
                return false;
            }

            int critChance = randomNumGenerator(1,100);
            int luck = (int) (dex*((float)(perception+1)/5));

            if(luck > 35)
            {
                luck = 35;
            }

            if(luck > critChance)
            {

                return true;

            }

            return false;

        }

    /**
     * @param dex
     * @return hit
     */
        private boolean gotHit(int dex) //Methode um zu bestimmen ob überhaupt getroffen wurde
        {
            if(dex <=0)
            {
                return false;
            }

            int hitChance = randomNumGenerator(1, 100);
            float dodge = (dex*1.5f)/2;

            if(dodge > 35.0f)
            {
                dodge = 35.0f;
            }

            if(hitChance < dodge)
            {
                System.out.println("Daneben");
                return false;
            }
            System.out.println("Getroffen");
            return true;
        }


    /**
     * @param min
     * @param max
     * @return
     */
        public static int randomNumGenerator(int min, int max) // Zufallszahlengenerator mit min-max range
        {
            Random rnd = new Random();
            int randomNumber = rnd.nextInt((max - min) + 1) + min;
            return randomNumber;
        }


       /* public void trap()//Ein zufälliger Zustand tritt ein wenn ein Feld mit einer Falle betreten wird
        {
            int rndTrap = randomNumGenerator(1, 5);

            switch(rndTrap)
            {
                case 2:
                    player.getStats().state = State.BLEEDING;
                    break;
                case 3:
                    player.getStats().state = State.BURNING;
                    break;
                case 4:
                    player.getStats().state = State.POISONED;
                    break;
                case 5:
                    player.getStats().state = State.STUNNED;
                    break;
                default:
                    player.getStats().state = State.NORMAL;
                    break;
            }
            player.getStats().characterStatus();
        }*/


}

