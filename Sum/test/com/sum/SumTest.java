package com.sum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumTest {

	Sum obj=new Sum();
	
	@Test
	void test() {
		//fail("Not yet implemented");
		assertEquals(8,obj.SumArray(new int[] {3,4,1}));
	}
	
	
	@Test
	void test1() {
		//fail("Not yet implemented");
		assertEquals(8,obj.SumArray(new int[] {8}));
	}


}
