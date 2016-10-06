package com.rzx.visitors;

import com.rzx.citysim.CitySim9002;

public class Professor extends Visitor{
	public Professor(int id){
		this.id = id;
		this.type = CitySim9002.visitors[1];
		System.out.println("Visitor " + id + " is a Professor.");
		//Professor likes all locations
		this.like.put(CitySim9002.locations[0], true);
		this.like.put(CitySim9002.locations[1], true);
		this.like.put(CitySim9002.locations[2], true);
		this.like.put(CitySim9002.locations[3], true);
	}
}