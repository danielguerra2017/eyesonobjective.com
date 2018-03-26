//************************
//  BitmapperC.java
//  By: Daniel S. Guerra
//  CSCI 1302
//  Project 1
//  12 September 2012
//************************

import java.io.*;

public class BitmapperC
{

	public static void main(String[] args) throws IOException
	{
		// Handling binary (not text) data, so use FileInputStream
		FileInputStream in  = new FileInputStream("input.bmp");
		FileOutputStream out = new FileOutputStream("output.bmp");

		int[] image = new int [5000000];

		int i = 0;

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

				counter+=2; //  Count the g and r pixel components
			}

			if (counter > 54)
			{
				out.write(i);
				out.write(i);
			}

			out.write(i);
		}

		in.close();
		out.close();
	}
}

