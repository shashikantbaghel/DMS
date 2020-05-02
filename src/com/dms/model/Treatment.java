package com.dms.model;

public class Treatment {
	
	private String name;
	private String time;
	private int cost;
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Treatment [name=" + name + ", time=" + time + ", cost=" + cost + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

}
