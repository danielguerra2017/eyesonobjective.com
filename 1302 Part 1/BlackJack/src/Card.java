// Card.java
// By: Brian Dix
// CSCI 1302
// Project 6
// 27 April 2013

import javax.swing.*;

public class Card {
	private String[] suits = {"clubs", "spades", "hearts", "diamonds"};
	private String[] faces = {"ace", "king", "queen", "jack", "ten", "nine", "eight",
			"seven", "six", "five", "four", "three", "two"};
	private int[] values = {1, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2};

	// face
	private String face;
	
	// suite
	private String suit;
	
	// value
	private int value;
	
	private ImageIcon image;
	
	public Card(int index)
	{
		// index is the number of card from 0-51, AC -> 2D
		face = faces  [index/4];
		suit = suits  [index%4];
		value = values[index/4];
		image = new ImageIcon("deck/" + (index+1) + ".png");
	}
	
	// value
	
	public String toString() {
		return face + " of " + suit;
	}
	
	public int getValue()
	{
		return value;
	}
}
