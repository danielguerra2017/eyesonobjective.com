//**********************************************************
// IdealWeight.java
// Author: Daniel S. Guerra
// Date: 2 Feb 2012
// Purpose: To compute the ideal weight for males/females
//**********************************************************

import java.util.Scanner;

public class IdealWeight
{
	public static void main (String[] args)
	{

		//***********
		// Variables
		//***********

		double enteredHeight;
		double maleHeight = 60;
		double maleWeight = 106;
		double femaleHeight = 60;
		double femaleWeight = 100;
		double maleFunction, femaleFunction;

		//********************
		// User inputs height
		//********************

		Scanner scan = new Scanner (System.in);

		System.out.print ("Enter your height in inches: ");
		enteredHeight = scan.nextDouble();

		//************************************
		// Functions to calculate ideal weight
		//************************************

		maleFunction = maleWeight + (6 * (enteredHeight - maleHeight));
		femaleFunction = femaleWeight + (5 * (enteredHeight - femaleHeight));

		//**************
		// Final output
		//**************

		System.out.println ("Your ideal weight is " + maleFunction + " if you are a male.");
		System.out.println ("Your ideal weight is " + femaleFunction + " if you are a female.");

	}

}