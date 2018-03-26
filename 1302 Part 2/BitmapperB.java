//************************
//  BitmapperB.java
//  By: Daniel S. Guerra
//  CSCI 1302
//  Project 1
//  12 September 2012
//************************

import java.io.*;
import javax.swing.JOptionPane;

public class BitmapperB
{

	public static void main(String[] args) throws IOException
	{
		// Handling binary (not text) data, so use FileInputStream
		FileInputStream in  = new FileInputStream("input.bmp");
		FileOutputStream out = new FileOutputStream("output.bmp");

		int[] image = new int [5000000];

		int i = 0;
		int max = 0;
		int min = 255;

		int b = 0;
		int g = 0;
		int r = 0;

		int counter = 0;

		while((b=in.read())!=-1)
		{
			i = b; //  Handle the headers

			if (++counter>54) //  Skip past Bitmap headers
			{
				g = in.read();
				r = in.read();

				i = ((b+g+r)/3);

				image[counter] = i;
				image[counter+1] = i;
				image[counter+2] = i;

				counter+=2; //  Count the g and r pixel components

				for (int value = 0; value < 1; value++) //  Make loop once
				{
					if (max<i)
						max=i;


					if (min>i)
						min=i;
				}

			}

			if (counter > 54)
			{
				out.write(i);
				out.write(i);
			}


			out.write(i);
		}

		JOptionPane.showMessageDialog(null, "Min: " + min + "\nMax: " + max); // Output min and max value

		in.close();
		out.close();
	}
}

