//********************************************************
// userLogin.java
// Author: Daniel S. Guerra
// March 18, 2012
//********************************************************

import java.util.Scanner;
import javax.swing.JOptionPane;


public class userLogin
{

	public static void main (String[] args)
	{

		Scanner scan = new Scanner (System.in);

		//***********
		// Variables
		//***********

		String pw = "CREATOR";

		//*************
		// First Input
		//*************

		String userpw = JOptionPane.showInputDialog("Please enter your password:\n(Password is case sensitive)",
													"PASSWORD");


		if (pw.equals(userpw))
		{
			JOptionPane.showMessageDialog(null, "User Agreement Accepted");
			// Instead of accepted screen, it would go to the next panel

		}

		else
		{
			JOptionPane.showMessageDialog(null, "The password you entered is INVALID.", "ALERT", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			// Eventually add a counter system to allow up to 2 or 3 times to enter the password
		}

	}
}

