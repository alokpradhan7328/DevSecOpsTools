package org.alok.main;

import org.alok.service.ArithematicService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ArithematicService ar = new ArithematicService();
    	System.out.println("The sum of 2 digits is :: "+ar.sum(20, 20));
    	
	
	 }
}
