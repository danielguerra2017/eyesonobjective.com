//**************************************************
//  guessing.java
//  Author: Daniel S. Guerra
//  Date: 27 March 2012
//  Purpose: To create an interactive guessing game
//**************************************************

import java.util.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class guessing
{

	public static void main(String[] args)
	{
		Random generator = new Random();
		Scanner in = new Scanner(System.in);

//***********
// Variables
//***********

		int random = generator.nextInt(100) + 1;
		String input1;
		double guess;
		int count = 0;

//****************
// Program begins
//****************

		do
		{
		input1=JOptionPane.showInputDialog("Guess a number from 1 to 100:" + "\n(Enter 0 if you wish to quit)");
		guess = Double.parseDouble(input1);
		count ++;

			if(guess == 0)
			{
			JOptionPane.showMessageDialog(null, "You have chosen to quit. I guess your scared I'll beat you.");
			System.exit(0);
			}

				else if(guess > random)
				{
				JOptionPane.showMessageDialog(null, "Incorrect! Your guess was too HIGH!");
				}

					else if(guess == random)
					{
					JOptionPane.showMessageDialog(null, "CONGRADULATIONS! You guessed the correct number!\n\n" +
														"It only took you " + count + " times!");
					}

						else if(guess < random)
						{
						JOptionPane.showMessageDialog(null, "Incorrect! Your guess was too LOW!");
						}

		}while (guess != 0);
	}
}