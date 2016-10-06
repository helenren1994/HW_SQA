package com.rzx.visitors;

import com.rzx.citysim.CitySim9002;

public class BusinessPerson extends Visitor{
	
	public BusinessPerson(int id){
		this.id = id;
		this.type = CitySim9002.visitors[2];
		System.out.println("Visitor " + id + " is a Business Person.");
		//Business Person likes Squirrel Hill and Downtown
		this.like.put(CitySim9002.locations[0], false);
		this.like.put(CitySim9002.locations[1], true);
		this.like.put(CitySim9002.locations[2], false);
		this.like.put(CitySim9002.locations[3], true);
	
	}
}