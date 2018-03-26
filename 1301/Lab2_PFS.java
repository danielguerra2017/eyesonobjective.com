//********************************************************************
//  Lab2_PFS.java
//  Written by: Pieter Smuts
//  Date Written: 2/7/12
//  CS 1301
//  Lab 2
//  Pay Calculator
//********************************************************************

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JApplet;
import java.awt.*;


public class Lab2_PFS extends JApplet
{
   //-----------------------------------------------------------------
   //  Pay Calculator for MySuper Computer Store
   //
   //-----------------------------------------------------------------

     public void paint (Graphics page)
     {
	   page.drawRect (20, 20, 500, 420);    // square outline for app
	   page.drawLine (50, 180, 360, 180);

       String emp1, emp2, emp3, emp4, input1, input2, input3, input4, text1, text2, text3;
       double emp1p, emp2p, emp3p, emp4p, hours_worked1, hours_worked2, hours_worked3, hours_worked4, pay1, pay2, pay3, pay4  ;
       int change, ten, five, one, quarter, dime, nickle, penny, leftOver;

       emp1="Adam Smith";
       emp2="John Doe";
       emp3="Marry Adams";
       emp4="Sarah James";
       emp1p=10.40;
       emp2p=11.50;
       emp3p=12.50;
       emp4p=15.20;
       text1="MySuper Computer Store";
       text2="Employee Pay Summery";
       text3="Week of 5-11 Febuary 2012"; //Enter date of pay peroid


       input1=JOptionPane.showInputDialog("Enter hours worked by: "+emp1); // Manager enters amount of hours worked by employees here
       hours_worked1 = Double.parseDouble(input1);

       input2=JOptionPane.showInputDialog("Enter hours worked by: "+emp2); // Manager enters amount of hours worked by employees here
       hours_worked2 = Double.parseDouble(input2);

       input3=JOptionPane.showInputDialog("Enter hours worked by: "+emp3); // Manager enters amount of hours worked by employees here
       hours_worked3 = Double.parseDouble(input3);

       input4=JOptionPane.showInputDialog("Enter hours worked by: "+emp4); // Manager enters amount of hours worked by employees here
       hours_worked4 = Double.parseDouble(input4);


	   pay1= emp1p * hours_worked1;
	   pay2= emp2p * hours_worked2;
	   pay3= emp3p * hours_worked3;
	   pay4= emp4p * hours_worked4;


page.drawString ("\n\n\n\n\t\t\t"+text1,120,70);
page.drawString ("\n\n\t\t\t"+text2,120,100);
page.drawString ("\n\n\t\t\t"+text3,120,130);
page.drawString ("\n\nEmployee Name         Rate    Hours    Pay", 60, 170);
page.drawString (""+emp1+"                  "+emp1p+"      "+hours_worked1+"        "+pay1, 60, 200);
page.drawString (""+emp2+"                       "+emp2p+"      "+hours_worked2+"        "+pay2, 60, 220);
page.drawString (""+emp3+"                 "+emp3p+"      "+hours_worked3+"        "+pay3, 60, 240);
page.drawString (""+emp4+"                "+emp4p+"      "+hours_worked4+"        "+pay4, 60, 260);




}
  }

