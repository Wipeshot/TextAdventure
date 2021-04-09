package me.mustache.items;

public abstract class Item {

	protected String name;
	protected String desc;
	protected int id;

	public Item(String pName, String pDesc, int pID) {

		name = pName;
		desc = pDesc;
		id = pID;


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
