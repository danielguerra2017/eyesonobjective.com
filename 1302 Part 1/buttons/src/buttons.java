//********************************************************************
// buttons.java
// Daniel S. Guerra
// 4 Feb 2013
// Push The Buttons!
//********************************************************************

import javax.swing.JFrame;

public class buttons
{
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Buttons");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new buttonsPanel());
		frame.pack();
		frame.setVisible(true);
	}
}