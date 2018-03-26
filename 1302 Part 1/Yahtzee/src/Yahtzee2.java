import java.util.*;


public class Yahtzee2 {

	public static void main(String[] args) {
		
		Dice[] hand = new Dice[5];
		
		for (int x=0; x<5; x++)
		{
			hand[x] = new Dice();
			System.out.println("Dice #" + (x+1) + ": " + 
					hand[x].getValue() );
		}

		int min;
		Dice temp;

		for (int index = 0; index < hand.length-1; index++)
	      {
	         min = index;
	         for (int switchIt = index+1; switchIt < hand.length; switchIt++)
	               min = switchIt;

	         // Swap the values
	         temp = hand[min];
	         hand[min] = hand[index];
	         hand[index] = temp;
	      }
		
		Arrays.sort(hand);
		System.out.println("\n");
		for (int x=0; x<5; x++)
		{
			System.out.println("Dice #" + (x+1) + ": " + hand[x].getValue() );	
		}
		
		if ((hand[0].getValue() == hand[1].getValue() && hand[0].getValue() == hand[2].getValue()) || 
			(hand[1].getValue() == hand[2].getValue() && hand[1].getValue() == hand[3].getValue()) || 
		   ((hand[2].getValue() == hand[3].getValue()) && (hand[2].getValue()) == hand[4].getValue()))
			{
				System.out.println("Congrads! You have three of a kind!");
			}
		

		

	}

}
