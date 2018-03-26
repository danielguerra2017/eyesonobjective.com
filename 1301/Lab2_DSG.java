//**********************************************************
// Lab2_DSG.java
// Author: Daniel S. Guerra
// Date: 7 Feb 2012
// CSCI 1301 L
// Lab 2
// Purpose: To compute weekly pay for various employees
//**********************************************************

import java.util.Scanner;

public class Lab2_DSG
{
	public static void main (String[] args)
	{

		//***********
		// Variables
		//***********

		String heading1 = "MySuper Computer Store";
		String heading2 = "Employee Pay Summary";
		String heading3 = "Week Ending January 20, 2012";
		String name = "EmployeeName";
		String rate = "Rate";
		String hour = "Hours";
		String pay = "Pay";
		String done = "Prepared by: Daniel S. Guerra";
		String emp1 = "Adam Smith";
		String emp2 = "John Doe";
		String emp3 = "Mary Adams";
		String emp4 = "Sarah James";

		double emp1Pay, emp2Pay, emp3Pay, emp4Pay;

		double emp1Rate = 10.40;
		double emp2Rate = 11.50;
		double emp3Rate = 12.70;
		double emp4Rate = 15.20;

		int emp1Hours;
		int emp2Hours;
		int emp3Hours;
		int emp4Hours;

		//*********************************
		// User inputs hours for employees
		//*********************************

		Scanner scan = new Scanner (System.in);

		System.out.print ("Please enter hours worked for " + emp1 + ": ");
		emp1Hours = scan.nextInt();

		System.out.print ("Please enter hours worked for " + emp2 + ": ");
		emp2Hours = scan.nextInt();

		System.out.print ("Please enter hours worked for " + emp3 + ": ");
		emp3Hours = scan.nextInt();

		System.out.print ("Please enter hours worked for " + emp4 + ": ");
		emp4Hours = scan.nextInt();

		emp1Pay = emp1Rate * emp1Hours;
		emp2Pay = emp2Rate * emp2Hours;
		emp3Pay = emp3Rate * emp3Hours;
		emp4Pay = emp4Rate * emp4Hours;

		//******
		// Body
		//******

		System.out.println("\n\n\n\t\t" + heading1 + "\n\n\t\t" + heading2 + "\n\n\t\t" + heading3);

		System.out.println("\n\n\t" + name + "\t" + rate + "\t" + hour + "\t" + pay);

		System.out.println("\n\t--------------------------------------");

		System.out.println("\n\t" + emp1 + "\t" + emp1Rate + "\t" + emp1Hours + "\t" + emp1Pay);

		System.out.println("\n\t" + emp2 + "\t" + emp2Rate + "\t" + emp2Hours + "\t" + emp2Pay);

		System.out.println("\n\t" + emp3 + "\t" + emp3Rate + "\t" + emp3Hours + "\t" + emp3Pay);

		System.out.println("\n\t" + emp4 + "\t" + emp4Rate + "\t" + emp4Hours + "\t" + emp4Pay);

		System.out.println("\n\n\t\t\t\t" + done + "\n\n\n");



	}

}