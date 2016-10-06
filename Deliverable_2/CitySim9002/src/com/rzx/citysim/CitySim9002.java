package com.rzx.citysim;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import com.rzx.visitors.Blogger;
import com.rzx.visitors.BusinessPerson;
import com.rzx.visitors.Professor;
import com.rzx.visitors.Student;
import com.rzx.visitors.Visitor;

public class CitySim9002 {
	
	public final static String[] visitors = new String[]{"Student", "BusinessPerson", "Professor", "Blogger"};
	public final static String[] locations = new String[]{"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown"};
	
	public boolean checkInput(String[] args){
		if(args.length == 1 && args[0].matches("[0-9]+") && Integer.parseInt(args[0])<=9)
			return true;
		else
			return false;
	}
	
	LinkedList<Visitor> visitorlist = new LinkedList<Visitor>();
	
	public Visitor generateVisitor(int type, int id){
		switch(type){
		case 0:
			return new Student(id);
		case 1:
			return new Professor(id);
		case 2:
			return new BusinessPerson(id);
		case 3:
			return new Blogger(id);
		default:
			return null;
		}
	}
	
	public boolean visit(Visitor visitor, String location){
		
		return visitor.likeOrNot(location);
	}
	
	public void run(int seed){
		Random rand = new Random(seed);
		Visitor visitor = null;
		
		for(int i = 1; i <= 5; i++){
			
			int typeOfVisitor = rand.nextInt(4);
			visitor = generateVisitor(typeOfVisitor, i);
			int location = rand.nextInt(4);
			while(location != 4){
				visit(visitor, locations[location]);
				location = rand.nextInt(5);
			}
			visitor.displayleave();
			System.out.println("***");
		}
		
	}
	
	public static void main(String[] args){
		int seed = 0;
		CitySim9002 cs = new CitySim9002();
		
		if(cs.checkInput(args)){
			seed = Integer.parseInt(args[0]);
			System.out.println("Welcome to CitySim! Your seed is " + seed + ".");
		} 
		else {
			System.out.println("Please enter an integer.");
			return;
		}
		
		cs.run(seed);
	}
	
}

