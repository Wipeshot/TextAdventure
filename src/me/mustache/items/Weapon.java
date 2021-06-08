package me.mustache.items;

public class Weapon extends Item {

	protected double damage;
	
	public Weapon(String name, String desc, int id, double damage) {
		super(name, desc, id);

		this.damage = damage;
		
	}

	public void setDamage(double damage){
		this.damage = damage;
	}

	public double getDamage(){
		return damage;
	}

}
