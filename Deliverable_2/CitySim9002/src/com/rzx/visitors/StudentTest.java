package com.rzx.visitors;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;


public class StudentTest {
	@Test
	public void Studentest() {
		
		Student s = new Student(1);
		assertEquals(s.type(), "Student");
	}
}