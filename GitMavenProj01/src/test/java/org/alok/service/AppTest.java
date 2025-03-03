package org.alok.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

	@Test
   public void testPositiveNumber()
   {
	   ArithematicService ar = new ArithematicService();
	   int expected = 20;
	   int actual = ar.sub(40, 20);
	   assertEquals(expected, actual);
   }
	
	 @Test
	   public void testNegativeNumber()
	   {
		   ArithematicService ar = new ArithematicService();
		   int expected = -40;
		   int actual = ar.sub(-60, -20);
		   assertEquals(expected, actual);
	   }
	 
	 @Test
	   public void testZero()
	   {
		   ArithematicService ar = new ArithematicService();
		   int expected = 0;
		   int actual = ar.sub(0,0);
		   assertEquals(expected, actual);
	   }
	 
	@Test
	public void testWithMixed()
	{
		 ArithematicService ar = new ArithematicService();
		   int expected =-500;
		   int actual = ar.sub(-300,200);
		   assertEquals(expected, actual);
	}
	 
	 
	 
	
}
