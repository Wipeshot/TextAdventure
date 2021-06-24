package me.mustache.items;

public abstract class Item {

	protected String name;
	protected String desc;
	protected int id;

	/**
	 * @param name 
	 * @param desc
	 * @param id
	 */
	public Item(String name, String desc, int id) {

		this.name = name;
		this.desc = desc;
		this.id = id;


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


}
