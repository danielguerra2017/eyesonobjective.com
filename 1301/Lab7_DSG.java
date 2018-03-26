//*******************************************
// Lab7_DSG.java
// Author: Daniel S. Guerra
// April 3, 2012
// Purpose: To compute APR CD for customers
//*******************************************

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.text.DecimalFormat;


public class Lab7_DSG
{
	public static void main (String[] args)
	{
//***********
// Variables
//***********

String input1, input2, input3;
double amount = 0;
double cd = 0;
double years = 0;
double percentage, interest, investment = 0;

//*************
// User Inputs
//*************

input1=JOptionPane.showInputDialog("Please enter Amount to Invest (between $100 - $100000):");
amount = Double.parseDouble(input1);

if (amount < 100 || amount > 100000)
{
JOptionPane.showMessageDialog(null, "Welcome to Guerra Investment\nInvalid Choice");
System.exit(0);
}

	else
	{
	input2=JOptionPane.showInputDialog("Please enter your choice of CD\'s (1 for 5%, 2 for 7.5% and 3 for 10%):");
	cd = Double.parseDouble(input2);

		if (cd < 1 || cd > 3)
		{
		JOptionPane.showMessageDialog(null, "Welcome to Guerra Investment\nInvalid Choice");
		System.exit(0);
		}

			else
			{
			input3=JOptionPane.showInputDialog("Please enter Years for Investment (between 2 and 20): ");
			years = Double.parseDouble(input3);

				if (years < 2 || years > 20)
				{
				JOptionPane.showMessageDialog(null, "Welcome to Guerra Investment\nInvalid Choice");
				System.exit(0);
				}

					else
					{
					}
			}
	}

if (cd == 1)
{
cd = .05;
}

	else
	{
		if (cd == 2)
		{
		cd = .075;
		}

			else
			{
			cd = .1;
			}
	}

//***************
//  Final Output
//***************

NumberFormat fmt = NumberFormat.getCurrencyInstance();
NumberFormat fmt2 = NumberFormat.getPercentInstance();
DecimalFormat fmt3 = new DecimalFormat ("#");

System.out.println ("Investment Amount: " + fmt.format(amount) + "\tInvestment Choice: " + fmt2.format(cd) + " APR CD\tFor: " +
fmt3.format(years) + " years");

for ( int cycle=1; cycle < years + 1 ; cycle++)
{
interest = amount * cd;
investment = amount + interest;
amount = amount + interest;

System.out.println ("Invest after " + cycle + " year is = " + fmt.format(interest) + "\tInvestment after " + cycle +
" year = " + fmt.format(investment));
}

System.out.println ("Happy Investing");
System.out.println ();
System.out.println ();

	}
}