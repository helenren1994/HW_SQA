package com.rzx.visitors;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfessorTest {

	@Test
	public void Bloggertest() {
		
		Blogger p = new Professor(1);
		assertEquals(b.type(), "Professor");
	}

}