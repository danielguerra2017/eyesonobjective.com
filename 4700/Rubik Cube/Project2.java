// Project 2 Demo
// A 2-D Rubik's Cube application

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class Project2
{


   // execute application
   public static void main( String args[] )
   {
      JFrame applicationWindow = new JFrame("Rubik's Cube Demo");
      applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );

      // add Project1_panel
      Project2_panel proj2_panel = new Project2_panel(300, 300);

      applicationWindow.getContentPane().add(proj2_panel);


      applicationWindow.pack();
      applicationWindow.setVisible(true);

   }


}  // end class Project2



