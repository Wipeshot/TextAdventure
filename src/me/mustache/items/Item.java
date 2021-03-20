package me.mustache.items;

public abstract class Item {

	protected String name;
	protected String desc;
	protected int id;

	public Item(String pName,String pDesc, int pId) {

		name = pName;
		desc = pDesc;
		id = pId;


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
