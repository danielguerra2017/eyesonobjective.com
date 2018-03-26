//*****************************************
// Lab1_DSG.java
// Name: Daniel S. Guerra
// CS1301 L
// Lab 1
// Submitted: January 24, 2012
// Purpose: To print a payment voucher
//*****************************************

public class Lab1_testing
{
    public static void main (String[] args)
    {

//***************
// Preset texts
//***************

/* Headers */

String text1 = "MySuper Computer Store";
String text2 = "Sales and Maintenance of Computers";
String text3 = "Payment Voucher";

/* Body */
String text4 = "Item";
String text5 = "Qty";
String text6 = "Price";
String text7 = "Ideal Home Computer";
String text8 = "Tax @ 6.75%";
String text9 = "Total Due";

/* Close */

String text10 = "Sold by: Daniel Guerra";

//*****************
// Variables
//*****************

double price= 975.95;
double taxrate = 0.0675;
double tax = price * taxrate;
double totaldue = price + tax;

//*****************
// Heading
//*****************

System.out.println("\n\n\t\t\t\t" + text1 + "\n\n\t\t\t" + text2 + "\n\n\t\t\t\t" + text3);

//*****************
// Main Body
//*****************

System.out.println("\n\n\n\t" + text4 + " \t\t\t\t" + text5 + " \t\t\t" + text6);

System.out.println(" \n\t" + text7 + " \t\t" + "1" + "\t\t\t" + "$ " + price);

System.out.println("\t\t\t\t\t\t" + text8 + "\t" + "$ " + tax);

System.out.println("\t\t\t\t\t\t" + text9 + "\t" + "$ " +totaldue);

//*****************
// Closing
//*****************

System.out.println("\n\n\t\t\t\t\t\t" + text10);

    }
}