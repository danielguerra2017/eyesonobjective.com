//********************************************************************
// buttonsPanel.java
// Daniel S. Guerra
// 4 Feb 2013
// Push The Buttons!
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class buttonsPanel extends JPanel
{	
	private JButton butt1;
	private JButton butt2;
	private JButton butt3;
	private JButton butt4;
	
	private JLabel label;
	
	public buttonsPanel ()
	{		
		butt1 = new JButton ("Click Here!");
		butt1.addActionListener (new ButtonListener());
		
		butt2 = new JButton ("Not Here!");
		butt2.addActionListener (new ButtonListener2());
		
		butt3 = new JButton ("Not Here!");
		butt3.addActionListener (new ButtonListener2());
		
		butt4 = new JButton ("Not Here!");
		butt4.addActionListener (new ButtonListener2());
		
		label = new JLabel (" ");
		
		add (butt1);
		add (butt2);
		add (butt3);
		add (butt4);
		add (label);
		
		setPreferredSize (new Dimension(200, 100));
		setBackground (Color.cyan);
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			label.setText("Good job! Do it again!");
		}
	}
	
	private class ButtonListener2 implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			label.setText("Wrong. Try Again!");
		}
	}
}