package me.mustache.character;

public class Health {


	protected int maxHealth = 100;
	protected int health = 100;
	protected int armor = 0;
	
	public Health() {
		
	}


	//Set-Operationen
	public void setMaxHealth(int pMaxHealth){
		maxHealth = pMaxHealth;
	}

	public void setHealth(int pHealth){
		health = pHealth;
	}

	public void setArmor(int pArmor){
		armor = pArmor;
	}

	//Get-Operationen
	public int getMaxHealth(){
		return maxHealth;
	}

	public int getHealth(){
		return health;
	}

	public int getArmor() {
		return armor;
	}

}
