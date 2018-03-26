//*****************************************************************************************
// Lab5_DSG.java
// Author: Daniel S. Guerra
// March 6, 2012
// Purpose: To receive a customers gas type and gallons required and calculate the price
//*****************************************************************************************

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Lab5_DSG
{

	public static void main (String[] args)
	{

		//***********
		// Variables
		//***********

		String input1, input2;
		double type, gallons, price;
		double delta = 0;
		String name ="Gas";

		//*************
		// First Input
		//*************

		input1=JOptionPane.showInputDialog("Welcome to Guerra Gas Station\n\n\t1. Regular\n\t2. Super\n\t3. Premium\n\nEnter your choice:");
		type = Double.parseDouble(input1);

		if (type == 1 || type == 2 || type == 3)
		{

			if (type == 1)
			{
			delta=3.43;
			name="Regular";
			}

				else

					if (type == 2)
					{
					delta=3.67;
					name="Super";
					}

							else

								if (type == 3)
								{
								delta=3.98;
								name="Premium";
								}
		}
			else
			{
			JOptionPane.showMessageDialog(null, "Welcome to Guerra Gas Station\nInvalid Choice");
			System.exit(0);
			}

		//**************
		// Second Input
		//**************

		input2=JOptionPane.showInputDialog("Enter the gallons required: ");
		gallons = Double.parseDouble(input2);

		price = delta * gallons;

		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		//***************
		// Final Outcome
		//***************

		System.out.println ("\t\tWelcome to Guerra Gas Station\n\n\tGas Purchased today: " + gallons + " Gallons of " + name + " at " + delta + "\n\n\tPlease pay "
		+ fmt.format(price) + "\n\n\n\t\t\t\tSales Associate: Daniel S. Guerra\n\n");
	}
}