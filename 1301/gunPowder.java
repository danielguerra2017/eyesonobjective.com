//********************************************************
// gunPowder.java
// Author: Daniel S. Guerra
// March 18, 2012
// Purpose: Calculate grain for reloading particular ammo
//********************************************************

import java.util.Scanner;
import javax.swing.JOptionPane;


public class gunPowder
{

	public static void main (String[] args)
	{

		Scanner scan = new Scanner (System.in);

		//***********
		// Variables
		//***********

		String pw = "CREATOR";
		String agreement = "I Agree";

		//*************
		// First Input
		//*************

		String userpw = JOptionPane.showInputDialog("Please enter your password:\n(Password is case sensitive)",
													"PASSWORD");


		if (pw.equals(userpw))
		{
			String useragreement = JOptionPane.showInputDialog("The information contained within this program is to \n" +
											   			"be used at your own risk. Any destruction to property, \n" +
											  			"injury, or fatality that comes as a result of the use \n" +
											 			"of the information found within is at the sole \n" +
														"responsibility of the user. The maker of this program \n" +
											   			"does not accept any responsiblity that may result from \n" +
											   			"using the information within. By entering \"I AGREE\" \n" +
											   			"you wave your right to legally pursue the makers of \n" +
											   			"this program for any reason.\n\n" +
											   			"Only if you agree to the Terms and Conditions should you \n" +
											   			"enter \"I Agree\". If you disagree, enter anything else to exit.",
											   			"Type \"I Agree\" to continue");

			if (agreement.equalsIgnoreCase(useragreement))
			{
				JOptionPane.showMessageDialog(null, "User Agreement Accepted");
			}

			else
			{
				JOptionPane.showMessageDialog(null, "You have chosen to not accept the agreement.", "Agreement Declined", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}

		}

		else
		{
			JOptionPane.showMessageDialog(null, "The password you entered is INVALID.", "ALERT", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

	}
}

