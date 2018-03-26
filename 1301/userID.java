//****************************************************************
// userID.java
// Author: Daniel S. Guerra
// Date: Feb 23, 2012
// Purpose: To receive a person's name and then create a username
//****************************************************************

import java.util.Scanner;
import java.util.Random;

public class userID
 {

 public static void main (String[] args)
  {

  Scanner scan = new Scanner (System.in);
  Random generator = new Random();

  //******************
  // Variables
  //******************

  String firstName, lastName;
  String mutation1, mutation2, mutation3, mutation4;
  int random1, random2, random3, random4;

  //********************
  // Receive user input
  //********************

  System.out.print ("Please enter your first name: ");
  firstName = scan.nextLine();

  System.out.print ("Please enter your last name: ");
  lastName = scan.nextLine();

  //***********
  // Mutations
  //***********

  mutation1 = firstName.toLowerCase ();
  mutation2 = mutation1.substring (0, 1);
  mutation3 = lastName.toLowerCase ();
  mutation4 = mutation3.substring (0, 4);

  //**************************
  // Random number generators
  //**************************

  random1 = generator.nextInt(9) + 1;
  random2 = generator.nextInt(9) + 1;
  random3 = generator.nextInt(9) + 1;
  random4 = generator.nextInt(9) + 1;

  //**************
  // Final output
  //**************

  System.out.println ("Welcome to the Ulitmate-System "+ lastName + ", " + firstName + ".\nYour new user name is " +
  mutation2 + mutation4 + random1 + random2 + random3 + random4);

  }

 }