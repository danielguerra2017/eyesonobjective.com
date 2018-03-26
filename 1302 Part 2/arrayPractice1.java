import java.util.*;

public class arrayPractice1
{
	public static void main (String args[])
	{
		int[] list = new int [20];

		for (int i=0; i < list.length, i++)
		{
			int num = i + 1;

			System.out.print("Please enter your number " + num + ": ");
			int input = scan.nextInt();
		}

		for (int index=0; index<list.length-1; index++)
		{
			int min=index;

			for (switchIt=index+1, switchIt<list.lenth; switchIt++)
			{
				if ( list[switchIt] < list[min])
					min = switchIt;

			temp = list[min];
			list[min] = list[index];
			list[index] = temp;







