//**********************************************************
// IdealWeight.java
// Author: Daniel S. Guerra
// Date: 2 Feb 2012
// Purpose: To compute the ideal weight for males/females
//**********************************************************

import java.util.Scanner;

public class PlayFile
{
	public static void main (String[] args)
	{
		int category;

		//*********************
		// Variables for males
		//*********************

		double maleHeight = 60;
		double maleWeight = 106;
		double maleEnteredHeight, maleTotalHeight;
		double maleEnteredWeight, maleTotalWeight, maleFunction, maleLastConversion;

		//***********************
		// Variables for females
		//***********************

		double femaleHeight = 60;
		double femaleWeight = 100;
		double femaleEnteredHeight, femaleTotalHeight;
		double femaleEnteredWeight, femaleTotalWeight,femaleFunction, femaleLastConversion;

		int male = 1;
		int female = 2;
		int gender = male/1 + female/1;

		//*****************
		// Gender decision
		//*****************

		Scanner scan = new Scanner (System.in);

		System.out.print ("Enter 1 for male, or 2 for female: ");
		gender = scan.nextInt();

		category = gender / 1;

		switch (category)
		{
			case 1:

		//****************
		// Male functions
		//****************

		System.out.print ("Enter your height in inches: ");
		maleEnteredHeight = scan.nextDouble();

		System.out.print ("Enter your weight in pounds: ");
		maleEnteredWeight = scan.nextDouble();

		maleTotalHeight = maleEnteredHeight - maleHeight;
		maleTotalWeight = maleEnteredWeight - maleHeight;
		maleFunction = maleWeight + (6 * (maleEnteredHeight - maleHeight));
		maleLastConversion= maleEnteredWeight - maleFunction;

		//*******************
		// Male final output
		//*******************

		System.out.println ("Your ideal weight is: " + maleFunction);

		//**********************
		// Male "if" statements
		//**********************

		if (maleEnteredWeight > maleFunction)
			System.out.println ("You are overweight by " + maleLastConversion + " pound(s)!\nConsider eating less!");

		if (maleEnteredWeight < maleFunction)
			System.out.println ("You are underweight by " +maleLastConversion + " pound(s)\nYou need to eat more!");

		if (maleEnteredWeight == maleFunction)
			System.out.println ("You meet ideal weight for your height!\nCongradulations, your on target!");

				break;

			case 2:

		//****************
		// Female functions
		//****************

		System.out.print ("Enter your height in inches: ");
		femaleEnteredHeight = scan.nextDouble();

		System.out.print ("Enter your weight in pounds: ");
		femaleEnteredWeight = scan.nextDouble();

		femaleTotalHeight = femaleEnteredHeight - femaleHeight;
		femaleTotalWeight = femaleEnteredWeight - femaleHeight;
		femaleFunction = femaleWeight + (5 * (femaleEnteredHeight - femaleHeight));
		femaleLastConversion= femaleEnteredWeight - femaleFunction;

		//*******************
		// Female final output
		//*******************

		System.out.println ("Your ideal weight is: " + femaleFunction);

		//**********************
		// Female "if" statements
		//**********************

		if (femaleEnteredWeight > femaleFunction)
			System.out.println ("You are overweight by " + femaleLastConversion + " pound(s)!\nConsider eating less!");
		if (femaleEnteredWeight < femaleFunction)
			System.out.println ("You are underweight by " +femaleLastConversion + " pound(s)\nYou need to eat more!");

		if (femaleEnteredWeight == femaleFunction)
			System.out.println ("You meet ideal weight for your height!\nCongradulations, your on target!");

				break;

		}

	}

}
