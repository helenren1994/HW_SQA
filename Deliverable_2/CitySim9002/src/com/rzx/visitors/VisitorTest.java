package com.rzx.visitors;

/**
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;


public class VisitorTest {
	
	//Test that student will like Squirrel Hill, Downtown, and The Point
	//and dislike The Cathedral of Learning
	@Test
	public void testProfessorLikes(){
		Visitor v = new Professor(3);
		assertFalse(v.likeOrNot("The Cathedral of Learning"));
		assertTrue(v.likeOrNot("The Point"));
		assertTrue(v.likeOrNot("Squirrel Hill"));
		assertTrue(v.likeOrNot("Downtown"));
	}
	
	//Test that type() method will return a visitor's type correctly
	@Test
	public void testVisitorType(){
		Visitor v = new BusinessPerson(1);
		assertEquals(v.type(), "BusinessPerson");
	}
}
