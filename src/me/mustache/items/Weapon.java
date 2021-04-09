package me.mustache.items;

public  abstract class Weapon extends Item {

	protected double damage;
	
	public Weapon(String pName, String pDesc, int pID, double pDamage) {
		super(pName, pDesc, pID);

		damage = pDamage;
		
	}

	public void setDamage(double pDamage){
		damage = pDamage;
	}

	public double getDamage(){
		return damage;
	}

}
