package com.rzx.citysim;

/**
 * 
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.*;
import org.mockito.Mock;  
import org.mockito.MockitoAnnotations;

import com.rzx.visitors.BusinessPerson;
import com.rzx.visitors.Visitor;

import org.mockito.ArgumentCaptor;  
import static org.mockito.Mockito.*; 


public class CitySim9002Test {
	
	@Mock
	CitySim9002 cs = Mockito.mock(CitySim9002.class);
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(cs);		
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	//Test when input is 10 as a edge case
	@Test
	public void testcheckInputWrongInteger(){
		Mockito.when(cs.checkInput(new String[]{"10"})).thenCallRealMethod();
		assertFalse(cs.checkInput(new String[]{"10"}));
	}
	
	//Test when input is not an integer as a failure mode
	@Test
	public void testcheckInputNotInteger(){
		Mockito.when(cs.checkInput(new String[]{"a"})).thenCallRealMethod();
		assertFalse(cs.checkInput(new String[]{"a"}));
	}
	
	//Test that business person will go to downtown and like it using doubles and stub
	@Test
	public void testRightLocationAndRightLike(){
		Visitor v = Mockito.mock(BusinessPerson.class);
		String loc ="Downtown";
		Mockito.when(v.likeOrNot(loc)).thenReturn(true);
		//CallRealMethod() is used to mock some methods without mocking others
		Mockito.when(cs.visit(v, loc)).thenCallRealMethod();
		assertTrue(cs.visit(v, loc));
	}


}
