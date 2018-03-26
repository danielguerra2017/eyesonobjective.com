import java.util.*;

public class projectFour {

	public static void main (String args[]){


		int[] numberArray = new int [10];
		int input;
		int counter = 0;
		int min;
		int temp;

		Scanner scan = new Scanner(System.in);

			for (int i = 0; i < numberArray.length; i++){

			int num = i + 1;
			System.out.print("Please enter number " + num + ": ");
			input = scan.nextInt();

			numberArray[i] = input;
		}

			for (int index = 0; index < numberArray.length-1; index++)
		      {
		         min = index;
		         for (int switchIt = index+1; switchIt < numberArray.length; switchIt++)
		            if (numberArray[switchIt] < numberArray[min])
		               min = switchIt;

		         // Swap the values
		         temp = numberArray[min];
		         numberArray[min] = numberArray[index];
		         numberArray[index] = temp;
		      }



			System.out.print("Your numbers are: ");

			for (counter=0; counter <numberArray.length; counter++){
				System.out.print(numberArray[counter] + " ");
			}






	}

}
