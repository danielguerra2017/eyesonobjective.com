//******************************************************
// TelephonePanel.java
//
// Lays out a (functionless) GUI like a telephone keypad with a title.
// Illustrates use of BorderLayout and GridLayout.
//******************************************************
import java.awt.*;
import javax.swing.*;
public class TelephonePanel extends JPanel
{
public TelephonePanel()
{
	setLayout(new BorderLayout(0, 0));
	
	JLabel titleLabel = new JLabel("Your Telephone");
	titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	add(titleLabel, BorderLayout.NORTH);
	
	JPanel keyPanel = new JPanel();
	add(keyPanel, BorderLayout.CENTER);
	keyPanel.setLayout(new GridLayout(0, 3, 0, 0));
	
	JButton button1 = new JButton("1");
	keyPanel.add(button1);
	
	JButton button2 = new JButton("2");
	keyPanel.add(button2);
	
	JButton button3 = new JButton("3");
	keyPanel.add(button3);
	
	JButton button4 = new JButton("4");
	keyPanel.add(button4);
	
	JButton button5 = new JButton("5");
	keyPanel.add(button5);
	
	JButton button6 = new JButton("6");
	keyPanel.add(button6);
	
	JButton button7 = new JButton("7");
	keyPanel.add(button7);
	
	JButton button8 = new JButton("8");
	keyPanel.add(button8);
	
	JButton button9 = new JButton("9");
	keyPanel.add(button9);
	
	JButton buttonStar = new JButton("*");
	keyPanel.add(buttonStar);
	
	JButton button0 = new JButton("0");
	keyPanel.add(button0);
	
	JButton buttonPound = new JButton("#");
	keyPanel.add(buttonPound);

}
}