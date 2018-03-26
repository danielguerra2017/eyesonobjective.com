//****************************************************************
// userID.java
// Author: Daniel S. Guerra
// Date: Feb 23, 2012
// Purpose: To create panels with the devil image
//****************************************************************

import java.awt.*;
import javax.swing.*;

public class Devil

{

	public static void main (String[] args)

	{

		JFrame frame = new JFrame ("Label Demo");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		ImageIcon icon = new ImageIcon ("devil.gif");
		JLabel label1, label2, label3, label4;

		//******************
		// Assigning labels
		//******************

		label1 = new JLabel ("Devil Left", icon, SwingConstants.CENTER);

		label2 = new JLabel ("Devil Right", icon, SwingConstants.CENTER);
		label2.setHorizontalTextPosition (SwingConstants.LEFT);
		label2.setVerticalTextPosition (SwingConstants.BOTTOM);

		label3 = new JLabel ("Devil Above", icon, SwingConstants.CENTER);
		label3.setHorizontalTextPosition (SwingConstants.CENTER);
		label3.setVerticalTextPosition (SwingConstants.BOTTOM);

		label4 = new JLabel ("Devil Below", icon, SwingConstants.CENTER);
		label4.setHorizontalTextPosition (SwingConstants.CENTER);
		label4.setVerticalTextPosition (SwingConstants.TOP);

		//***********************
		// Setting up the window
		//***********************

		JPanel panel = new JPanel();
		panel.setBackground (Color.orange);
		panel.setPreferredSize (new Dimension (130, 330));
		panel.add (label1);
		panel.add (label2);
		panel.add (label3);
		panel.add (label4);

		//frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

		   }

		}

