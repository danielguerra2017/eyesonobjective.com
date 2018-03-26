import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; //  get the time functionality

public class DotsPanel extends JPanel
{
   private final int SIZE = 6;  // radius of each dot

   private Timer timer; // timer for our animation

   private final int DELAY = 33; //  30 fps, 33ms delay

   private ArrayList<Point> pointList;


   //-----------------------------------------------------------------
   //  Constructor: Sets up this panel to listen for mouse events.
   //-----------------------------------------------------------------
   public DotsPanel()
   {
      pointList = new ArrayList<Point>();

      timer = new Timer (DELAY, new DotTimeListener());

      addMouseListener (new DotsListener());
      setBackground (Color.black);
      setPreferredSize (new Dimension(300, 200));

      timer.start(); //  start timer
   }

   //-----------------------------------------------------------------
   //  Draws all of the dots stored in the list.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent(page);
      page.setColor (Color.blue);

      for (Point spot : pointList)
         page.drawRect (spot.x-SIZE, spot.y-SIZE, SIZE*2, SIZE*4);

      page.drawString ("Count: " + pointList.size(), 150, 100);
   }
//*****************************************************************
   //  Represents the listener for mouse events.
   //*****************************************************************
   private class DotsListener implements MouseListener
   {
      //--------------------------------------------------------------
      //  Adds the current point to the list of points and redraws
      //  the panel whenever the mouse button is pressed.
      //--------------------------------------------------------------
      public void mousePressed (MouseEvent event)
      {
         pointList.add(event.getPoint());
         repaint();
      }
      //--------------------------------------------------------------
      //  Provide empty definitions for unused event methods.
      //--------------------------------------------------------------
      public void mouseClicked (MouseEvent event) {}
      public void mouseReleased (MouseEvent event) {}
      public void mouseEntered (MouseEvent event) {}
      public void mouseExited (MouseEvent event) {}
   }

   //*****************************************************************
      //  Represents the action listener for the timer.
      //*****************************************************************
      private class DotTimeListener implements ActionListener
      {
         //--------------------------------------------------------------
         //  move the dots
         //--------------------------------------------------------------
         public void actionPerformed (ActionEvent event)
         {
			for (Point spot : pointList)
			{
				spot.x += 1;
				spot.y += 1;

				// scroll dots off screen, looping
				if (spot.y > getHeight())
				spot.y = 0;

				if (spot.x > getWidth())
				spot.x = 0;
			}

            repaint();
         }

	 }

}
