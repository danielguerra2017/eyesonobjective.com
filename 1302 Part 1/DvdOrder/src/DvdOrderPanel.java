//*********************************************************
// VoteCounterPanel.java
//
// Demonstrates a graphical user interface and event listeners to
// tally votes for two candidates, Joe and Sam.
//*********************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DvdOrderPanel extends JPanel
{
private String votesForJoe;
private int votesForSam;
private JButton joe;
private JButton sam;
private JLabel labelJoe;
private JLabel labelSam;
private JTextField textField;

//----------------------------------------------
// Constructor: Sets up the GUI.
//----------------------------------------------
public DvdOrderPanel()
{
votesForJoe = ("Welcome");
votesForSam = 0;

joe = new JButton("Vote for Joe");
joe.addActionListener(new JoeButtonListener());

sam = new JButton("Vote for Sam");
sam.addActionListener(new SamButtonListener());

labelJoe = new JLabel("Thank you " + votesForJoe);

add(joe);
add(labelJoe);

labelSam = new JLabel("Votes for Sam: " + votesForSam);

add(sam);
add(labelSam);

setPreferredSize(new Dimension(300, 300));
setBackground(Color.cyan);


textField = new JTextField();
textField.setColumns(10);
add(textField);

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

labelJoe.setText("Thank you " + textField);
}
}

private class SamButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		votesForSam++;
		labelSam.setText("Votes for Sam: " + textField);
	}
}

}