//******************************************************************************
// Lab6_DSG.java
// Author: Daniel S. Guerra
// Date: March 20, 2012
// Purpose: To receive a person's name and favorite month and perform an output
//******************************************************************************

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab6_DSG
 {

 public static void main (String[] args)
  {

  Scanner scan = new Scanner (System.in);

  //******************
  // Variables
  //******************

  String fullName, leapYear = "", leapYearPhrase ="";
  int days;
  int favoriteMonth;
  String monthName = "";

  days = 0;

  //********************
  // Receive user input
  //********************



  System.out.print ("Please enter your full name: ");
  fullName = scan.nextLine();

  System.out.print ("Please enter your favorite month (1 for Jan, 2 for Feb. etc): ");
  favoriteMonth = scan.nextInt();



  if (favoriteMonth == 2)
  {
	  System.out.print ("Please enter Yes if the year is a Leap year: ");
	  leapYear = scan.next();

	  if (leapYear.equalsIgnoreCase("Yes"))
	  {
		  monthName = "February";
		  days = 29;
		  leapYearPhrase = ", because this is a Leap Year";
	  }

	  else
	  {
		  monthName = "February";
		  days = 28;
		  leapYearPhrase = "";
	  }
  }

  else
			if (favoriteMonth == 1)
			{
				monthName = "January";
				days = 31;
				leapYearPhrase = "";
			}

			if (favoriteMonth == 3)
			{
				monthName = "March";
				days = 31;
				leapYearPhrase = "";
			}

			if (favoriteMonth == 4)
			{
				monthName = "April";
				days = 30;
				leapYearPhrase = "";
			}

			if (favoriteMonth == 5)
			{
				monthName = "May";
				days = 31;
				leapYearPhrase = "";
			}

			if (favoriteMonth == 6)
			{
				monthName = "June";
				days = 30;
				leapYearPhrase = "";
			}

			if (favoriteMonth == 7)
			{
				monthName = "July";
				days = 31;
				leapYearPhrase = "";
			}

			if (favoriteMonth == 8)
			{
				monthName = "August";
				days = 30;
				leapYearPhrase = "";
			}

			if (favoriteMonth == 9)
			{
				monthName = "September";
				days = 30;
				leapYearPhrase = "";
			}

			if (favoriteMonth == 10)
			{
				monthName = "October";
				days = 31;
				leapYearPhrase = "";
			}

			if (favoriteMonth == 11)
			{
				monthName = "November";
				days = 30;
				leapYearPhrase = "";
			}

			if (favoriteMonth == 12)
			{
				monthName = "December";
				days = 31;
				leapYearPhrase = "";
			}

  //**************
  // Final output
  //**************

  JOptionPane.showMessageDialog(null, "\nHello " + fullName + "\n\nYour Favorite Month is: " +
  monthName + "\n\nYour Favorite Month has: " + days + " days" + leapYearPhrase +
  "\n\n\n                                                        Designed by: Daniel S. Guerra");

  }

 }