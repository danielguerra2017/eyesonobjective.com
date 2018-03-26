
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DvdOrder extends JPanel
{
	private JLabel exiting;
	private JTextField textField;
	private JTextField txtAddressLine;
	private JTextField txtAddressLine_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public static void main(String[] args)
	{
	JFrame frame = new JFrame("Telephone");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(new DvdOrder());
	frame.pack();
	frame.setVisible(true);
	}
	
public DvdOrder()
{
	setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	
	JPanel center = new JPanel();
	add(center);
	center.setLayout(new GridLayout(0, 2, 0, 0));
	
	JLabel lblNewLabel = new JLabel("Name");
	center.add(lblNewLabel);
	
	textField = new JTextField();
	textField.setText("");
	center.add(textField);
	textField.setColumns(16);
	
	JLabel lblNewLabel_1 = new JLabel("Address");
	center.add(lblNewLabel_1);
	
	txtAddressLine = new JTextField();
	txtAddressLine.setText("Address Line 1");
	center.add(txtAddressLine);
	txtAddressLine.setColumns(16);
	
	JLabel label = new JLabel("");
	center.add(label);
	
	txtAddressLine_1 = new JTextField();
	txtAddressLine_1.setText("Address Line 2");
	center.add(txtAddressLine_1);
	txtAddressLine_1.setColumns(16);
	
	JLabel lblCity = new JLabel("City");
	center.add(lblCity);
	
	textField_1 = new JTextField();
	center.add(textField_1);
	textField_1.setColumns(10);
	
	JLabel lblState = new JLabel("State");
	center.add(lblState);
	
	textField_2 = new JTextField();
	center.add(textField_2);
	textField_2.setColumns(10);
	
	JLabel lblZipCode = new JLabel("Zip Code");
	center.add(lblZipCode);
	
	textField_3 = new JTextField();
	center.add(textField_3);
	textField_3.setColumns(10);
	
	JLabel label_10 = new JLabel("");
	center.add(label_10);
	
	JLabel label_8 = new JLabel("");
	center.add(label_8);
	
	JLabel label_7 = new JLabel("");
	center.add(label_7);
	
	JLabel label_12 = new JLabel("");
	center.add(label_12);
	
	JLabel lblMovies = new JLabel("Movies");
	center.add(lblMovies);
	
	JLabel label_6 = new JLabel("");
	center.add(label_6);
	
	JLabel label_11 = new JLabel("");
	center.add(label_11);
	
	JRadioButton rdbtnGridiron = new JRadioButton("Employee of the Month");
	center.add(rdbtnGridiron);
	
	JLabel label_9 = new JLabel("");
	center.add(label_9);
	
	JRadioButton rdbtnBlah = new JRadioButton("Gridiron Gang");
	center.add(rdbtnBlah);
	
	JLabel label_2 = new JLabel("");
	center.add(label_2);
	
	JRadioButton rdbtnBhahaha = new JRadioButton("Seven Swords");
	center.add(rdbtnBhahaha);
	
	JLabel label_4 = new JLabel("");
	center.add(label_4);
	
	JLabel label_1 = new JLabel("");
	center.add(label_1);
	
	Button button = new Button("Submit");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JLabel lblThankYou = new JLabel("Thank you " + textField + "! You have ordered a movie!");
			add(lblThankYou);
			
		}
	});
	center.add(button);
	
	JLabel label_5 = new JLabel("");
	center.add(label_5);
	
	JLabel lblThankYou = new JLabel("Thank You!");
	center.add(lblThankYou);
	
	JLabel label_3 = new JLabel("");
	center.add(label_3);
	
}
}