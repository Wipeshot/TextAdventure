package me.mustache.items;

public abstract class Item {

	protected String name;
	protected String desc;
	protected int id;

	public Item(String name, String desc, int id) {

		this.name = name;
		this.desc = desc;
		this.id = id;


	}

	public String getName(){
		return name;
	}

	public String getDesc(){
		return desc;
	}

	public int getId(){
		return id;
	}


}
