//*********************************************************
// VoteCounterPanel.java
//
// Demonstrates a graphical user interface and event listeners to
// tally votes for two candidates, Joe and Sam.
//*********************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VoteCounterPanel extends JPanel
{
private int votesForJoe;
private int votesForSam;
private JButton joe;
private JButton sam;
private JLabel labelJoe;
private JLabel labelSam;
//----------------------------------------------
// Constructor: Sets up the GUI.
//----------------------------------------------
public VoteCounterPanel()
{
votesForJoe = 0;
votesForSam = 0;

joe = new JButton("Vote for Joe");
joe.addActionListener(new JoeButtonListener());

sam = new JButton("Vote for Sam");
sam.addActionListener(new SamButtonListener());

labelJoe = new JLabel("Votes for Joe: " + votesForJoe);

add(joe);
add(labelJoe);

labelSam = new JLabel("Votes for Sam: " + votesForSam);

add(sam);
add(labelSam);

setPreferredSize(new Dimension(300, 80));
setBackground(Color.cyan);
}
//***************************************************
// Represents a listener for button push (action) events
//***************************************************
private class JoeButtonListener implements ActionListener
{
//----------------------------------------------
// Updates the counter and label when Vote for Joe
// button is pushed
//----------------------------------------------
public void actionPerformed(ActionEvent event)
{
votesForJoe++;
labelJoe.setText("Votes for Joe: " + votesForJoe);
}
}

private class SamButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		votesForSam++;
		labelSam.setText("Votes for Sam: " + votesForSam);
	}
}

}