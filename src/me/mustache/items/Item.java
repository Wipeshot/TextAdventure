package me.mustache.items;

public abstract class Item {

	protected String name;
	protected String desc;
	protected int id;
	protected EquipSlot slot;
	public enum EquipSlot            // Enum-Typ
	{
		UNEQUIPPABLE,
		WEAPON,
		HELMET,
		CHEST,
		LEGS,
		BOOTS
	}

	/**
	 * @param name 
	 * @param desc
	 * @param id
	 */
	public Item(String name, String desc, int id, EquipSlot slot) {

		this.name = name;
		this.desc = desc;
		this.id = id;
		this.slot = slot;


	}

	/**
	 * @return name
	 */
	public String getName(){
		return name;
	}

	/**
	 * @return description
	 */
	public String getDesc(){
		return desc;
	}

	/**
	 * @return id
	 */
	public int getId(){
		return id;
	}
	public EquipSlot getSlot(){return slot;}

}
