
//**************************************
//  finalProject.java
//  Author: Daniel S. Guerra
//  Date: 19 April 2012
//  Purpose: Display grades for a class
//**************************************

import java.util.Scanner;
import java.lang.Character;
import java.lang.String;

public class finalProject
{

	public static void main (String[] args)
	{

		Scanner userInput = new Scanner (System.in);

		int stuCount;
		int countA=0, countB=0, countC=0, countD=0, countF=0;
		String className = "CSCI 1301 Spring 2012";
		String finalGrade;

		System.out.println("Enter number of students in the class: ");
		stuCount = userInput.nextInt();

		char [] stuGrade = new char [stuCount];

		for (int i=0;i < stuCount;i++)
		{
			System.out.println("Enter student grades (In caps): ");
			finalGrade = userInput.next();

			stuGrade[i] = finalGrade.charAt(0);

			switch (stuGrade[i])
			{
				case 'A':
				countA++;
				break;

				case 'B':
				countB++;
				break;

				case 'C':
				countC++;
				break;

				case 'D':
				countD++;
				break;

				case 'F':
				countF++;
				break;
			}

		}

		System.out.println ("There are " + countA + " A\'s in the class!");
		System.out.println ("There are " + countB + " B\'s in the class!");
		System.out.println ("There are " + countC + " C\'s in the class!");
		System.out.println ("There are " + countD + " D\'s in the class!");
		System.out.println ("There are " + countF + " F\'s in the class!");
	}
}

