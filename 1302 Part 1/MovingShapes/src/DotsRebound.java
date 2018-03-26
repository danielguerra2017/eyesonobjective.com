import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
 import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DotsRebound
{
 private static final DotsReboundPanel panel = new DotsReboundPanel();
 private static JTextField textFieldRadius;
 private static JTextField textFieldSpeed;
    //-----------------------------------------------------------------
    //  Creates and displays the application frame.
    //-----------------------------------------------------------------
   public static void main (String[] args)
    {
      JFrame frame = new JFrame ("Dots");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      JPanel TopPanel = new JPanel();
      frame.getContentPane().add(TopPanel, BorderLayout.NORTH);

      JLabel LabelRadius = new JLabel("Radius:");
      TopPanel.add(LabelRadius);

      textFieldRadius = new JTextField();
      textFieldRadius.setText("10");
      TopPanel.add(textFieldRadius);
      textFieldRadius.setColumns(4);

      JLabel LabelSpeed = new JLabel("Speed:");
      TopPanel.add(LabelSpeed);

      textFieldSpeed = new JTextField();
      textFieldSpeed.setText("30");
      TopPanel.add(textFieldSpeed);
      textFieldSpeed.setColumns(4);

      JButton ButtonChange = new JButton("Change");
      ButtonChange.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent arg0) {
        // add code to change radius of the dots in "panel"
         int mysize = Integer.parseInt(textFieldRadius.getText());
        panel.setRadius(mysize);

        int myspeed = Integer.parseInt(textFieldSpeed.getText());
        panel.setDelay(myspeed);
        
       }
      });
      TopPanel.add(ButtonChange);
      frame.getContentPane().add(panel, BorderLayout.CENTER);

      frame.pack();
       frame.setVisible(true);
   }
}
