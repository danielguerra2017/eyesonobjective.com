//********************************************************************
//  PP2_4.java       Author: Daniel S. Guerra
//
//  Demonstrates the basic structure of a Java application.
//********************************************************************

import java.util.Scanner;

public class PP2_4
{
   //-----------------------------------------------------------------
   //  Prints a presidential quote.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
	  float num1, num2;
	  float sum, difference, product;

	  Scanner scan = new Scanner (System.in);

      System.out.print ("Enter your first number: ");
      num1 = scan.nextFloat();

	  System.out.print ("Enter your second number: ");
	  num2 = scan.nextFloat();

	  sum = num1 + num2;
	  difference = num1 - num2;
	  product = num1 * num2;

	  System.out.println (num1 + " + " + num2 + " = " + sum);
	  System.out.println (num1 + " - " + num2 + " = " + difference);
	  System.out.println (num1 + " * " + num2 + " = " + product);

   }
}
