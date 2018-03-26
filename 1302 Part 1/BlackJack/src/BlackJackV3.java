// BlackJackV3.java
// By: Brian Dix
// CSCI 1302
// Project 6
// 27 April 2013

import java.util.Scanner;

public class BlackJackV3 {
	
	
	public static int getHandValue(Card[] hand)
	{
		int total = 0;               // initial hand value
		boolean hasAce = false;      // decides if the hand an ace
		for (int x = 0; x < hand.length; x++)
		{
			if (hand[x] != null)
			{
				total += hand[x].getValue();
				if (hand[x].getValue()==1)
					hasAce = true;
			}
		}
		if (hasAce && total+10 <= 21)
			total += 10;               // sets ace = 11 if hand total is less than 21
		
		return total;
	}
	public static void main(String[] args){
		int z = 1;
		double playerbal = 100;
		Scanner scan = new Scanner(System.in);
		while (z == 0)
		{
			System.exit(0);
		}
		while (z >= 1)
		{
		Deck myDeck = new Deck();
		myDeck.shuffle();
		
		// set up an array for house[] and player[]
		Card[] player = new Card[9]; // hand can hold 9 cards because player can hit till bust
		Card[] house  = new Card[9];
		int playerTotal = 0;
		int houseTotal  = 0;
		
		// "deal" cards to the house and player
		player[0] = myDeck.deal();
		house [0] = myDeck.deal();
		player[1] = myDeck.deal();
		house [1] = myDeck.deal();
		
		// show the cards to the player
		System.out.println("Player: " + player[0] + ", " + player[1]);
		System.out.println("House: "  + house [0] + ", " + house [1]);
		
		// show the house and player's balances
		System.out.println("Your current balance: " + playerbal + " credits.");
		
		int numCards = 2;
		
		// show the values of each
		// Player values
		playerTotal = getHandValue(player);
		System.out.println("Player's total: " + playerTotal);
		
		// House values
		houseTotal =  getHandValue(house);
		System.out.println("House total: " + houseTotal);
		
		System.out.println("[H]it or [S]tand?");
        
		while( scan.next().equalsIgnoreCase("h"))
		{
			player[numCards] = myDeck.deal();
			numCards++;
			
			// print out the player's hand
			System.out.print("Player: ");
			for (int x = 0; x < numCards; x++)
				System.out.print(player[x] + " ");
			System.out.println();
			
			if (numCards > 9) 
				break;
			
			// Player values
			playerTotal = getHandValue(player);
			System.out.println("Player's total: " + playerTotal);
			houseTotal = getHandValue(house);
			System.out.println("House's total: " + houseTotal);
			
			if (playerTotal > 21)
				break;
			
			// ask hit or stand
			System.out.println("[H]it or [S]tand?");
			
		}
		
		// get the value of the house's hand
		while(houseTotal < 17) // house must hit if their total is less than 17
		{
			house[numCards] = myDeck.deal();
			numCards++;
			
			// print out the house's hand
			System.out.print("House: ");
			for (int x = 0; x < numCards; x++)
				System.out.print(house[x] + " ");
			System.out.println();
			
			if (numCards > 9) 
				break;
			houseTotal = getHandValue(house);
			
			// House values
			//houseTotal = getHandValue(house);
			//System.out.println("House total: " + houseTotal);
			
		}
		
		// handle a player "bust"
		houseTotal = getHandValue(house);
		System.out.println("House's total: " + houseTotal);
		if (getHandValue(player) > 21)
			System.out.println("You busted.");
		// handle a house "bust"
		else if (getHandValue(house) > 21)
			System.out.println("House busts, you win.");
		// or check to see if you win otherwise
		else if (getHandValue(player) > getHandValue(house))
			System.out.println("You win!");
		else if (getHandValue(house) > getHandValue(player))
			System.out.println("You lose!");
		else 
			System.out.println("It's a Push - no winner.");
		
		// Handles betting for the player
		if (getHandValue(player) > 21) // player bust
			playerbal = playerbal-5;
		else if (getHandValue(house) > 21) // house bust
			playerbal = playerbal+5;
		else if (getHandValue(player) > getHandValue(house)) // player's hand wins
			playerbal = playerbal+5;
		else if (getHandValue(player) == 21) // special case, blackjack gets x1.5 points
			playerbal = playerbal +7.5;
		else if (getHandValue(house) > getHandValue(player)) // house's hand wins
			playerbal = playerbal-5;
		else 
			playerbal = playerbal; // push, or tie; no credits are lost
		
		// print out player's balance
		System.out.println("Your current balance: " + playerbal + " credits.");
		
		// Asks player to play again.
		System.out.println("Play again? Enter [y]es or [n]o.");
			if( scan.next().equalsIgnoreCase("y"))
			{
				//playerTotal = 0;
				//houseTotal  = 0;
				z++;
			}
			else if( scan.next().equalsIgnoreCase("n"))
			{
				z = 0;
			}
			
		}
		
	}

}
