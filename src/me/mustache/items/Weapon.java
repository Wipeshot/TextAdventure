package me.mustache.items;

public class Weapon extends Item {

	protected double damage;

	/**
	 * @param name
	 * @param desc
	 * @param id
	 * @param damage
	 */
	public Weapon(String name, String desc, int id, double damage) {
		super(name, desc, id);

		this.damage = damage;
		
	}

	/**
	 * @param damage
	 */
	public void setDamage(double damage){
		this.damage = damage;
	}

	/**
	 * @return damage
	 */
	public double getDamage(){
		return damage;
	}

}
