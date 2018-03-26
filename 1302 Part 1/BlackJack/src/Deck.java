// Deck.java
// By: Brian Dix
// CSCI 1302
// Project 6
// 27 April 2013

public class Deck {
	
	private Card[] cards;
	private int nextCard = 0;
	
	public Deck()
	{
		cards = new Card[52];
		for (int x = 0; x < 52; x++)
			cards[x] = new Card(x);
	}
	
	public Card deal()
	{
		Card yourCard = cards[nextCard];
		nextCard++;
		if (nextCard>=52)
		{
			nextCard = 0;
			shuffle();
		}
		return yourCard;
	}
	
	public void shuffle()
	{
		for (int x = 0; x < 52; x++)
		{
			Card temp = cards[x];               // pick up card x
			int n = (int)(Math.random()*52);    // pick a new position
			cards[x] = cards[n];                // swap cards
			cards[n] = temp;
		}

		
	}
	
	public String toString(){
		String wholeDeck = "";
		for (int x = 0; x < 52; x++)
			wholeDeck += cards[x] + "\n";
		return wholeDeck;
	}

}
