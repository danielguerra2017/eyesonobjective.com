//*************************************************************************
//  characterChart.java
//  Author: Daniel S. Guerra
//  Date: April 11, 2012
//  Purose:To display characters and count vowels and consonants in phrase
//*************************************************************************

import java.util.Scanner;
import java.lang.Character;
import javax.swing.JOptionPane;

public class characterChart
{
	public static void main (String[] args)
	{

		Scanner scan = new Scanner(System.in);

		//************
		//  Variables
		//************

		final int PER_LINE = 5;
		int first = 32, last = 126, counter = 0;
		int aCounter = 0, eCounter = 0, iCounter = 0, oCounter = 0, uCounter = 0, consCounter = 0;
		String quit = "stop";

		System.out.println ();

		for (int i = 32; i <= last; i+=1)
		{
			System.out.println(i + " : " + (char)i + "\t");
			counter++;

				if (i % PER_LINE == 0)
				System.out.println();
		}

		//*************
		//  User Input
		//*************

		String phrase = JOptionPane.showInputDialog("Please enter a phrase\n(Enter STOP to quit) ");

		for(int i = 0; i < phrase.length(); i++)
		{
			if (phrase.charAt(i) == '0');

				if (phrase.charAt(i) == 'a')
				{
					aCounter++;
				}

					if (phrase.charAt(i) == 'e')
					{
						eCounter++;
					}

						if (phrase.charAt(i) == 'i')
						{
							iCounter++;
						}

							if (phrase.charAt(i) == 'o')
							{
								oCounter++;
							}

								if (phrase.charAt(i) == 'u')
								{
									uCounter++;
								}

									if (phrase.charAt(i) != 'a' || phrase.charAt(i) != 'e' ||
										phrase.charAt(i) != 'i' || phrase.charAt(i) != 'o' ||
										phrase.charAt(i) != 'u' || phrase.charAt(i) != ' ')
									{
										consCounter++;
									}

										if (quit.equalsIgnoreCase(phrase))
										{
											JOptionPane.showMessageDialog(null, "YOU HAVE CHOSEN TO QUIT THE PROGRAM", "Exiting Program",
											JOptionPane.ERROR_MESSAGE);
											System.exit(0);
										}
		}

		//***************
		//  Final Output
		//***************

		JOptionPane.showMessageDialog(null, "A printed " + aCounter + " times!\n" +
											"E printed " + eCounter + " times!\n" +
											"I printed " + iCounter + " times!\n" +
											"O printed " + oCounter + " times!\n" +
											"U printed " + uCounter + " times!\n" +
											"Consonants printed " + consCounter + " times!");
	}
}
