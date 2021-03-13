package me.mustache.character;

public class Mana {


    protected int maxMana = 100;
    protected int Mana = 100;

    public Mana() {

    }


    //Set-Operationen

    public void setMana(int pMana){
        Mana = pMana;
    }

    //Get-Operationen
    public int getMaxMana(){
        return maxMana;
    }

    public int getMana(){
        return Mana;
    }

}
