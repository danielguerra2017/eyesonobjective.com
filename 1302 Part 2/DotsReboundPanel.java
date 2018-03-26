import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; //  get the time functionality

public class DotsReboundPanel extends JPanel
{
   private final int SIZE = 6;  // radius of each dot

   private Timer timer; // timer for our animation

   private final int DELAY = 33; //  30 fps, 33ms delay

   private ArrayList<Point> pointList;

   private int[] xvel = new int[1000], yvel = new int [1000]; // velocity x, y

   private Color[] col = new Color[1000];


   //-----------------------------------------------------------------
   //  Constructor: Sets up this panel to listen for mouse events.
   //-----------------------------------------------------------------
   public DotsReboundPanel()
   {
      pointList = new ArrayList<Point>();

      //  initialize my velocity vectors
      for(int i=0; i < 1000; i++)
      {
		  xvel[i] = (int) Math.round(Math.random()*10 - 5); //  random velocity vectors
		  yvel[i] = (int) Math.round(Math.random()*10 - 5);

		  col[i] = new Color(
			  (int) (Math.random() * 255),
			  (int) (Math.random() * 255),
			  (int) (Math.random() * 255));
}

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

      int i=0;
      for (Point spot : pointList)
      {
		  page.setColor (col[i]);
         page.drawRect (spot.x-SIZE, spot.y-SIZE, SIZE*2, SIZE*4);
         i++;
	 }

	  page.setColor(Color.red);
      page.drawString ("Count: " + pointList.size(), 5, 15);
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

      public void mouseReleased (MouseEvent event)
      {
		  pointList.add(event.getPoint());
		  repaint();
	  }
      //--------------------------------------------------------------
      //  Provide empty definitions for unused event methods.
      //--------------------------------------------------------------
      public void mouseClicked (MouseEvent event) {}
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
			int i = 0;
			for (Point spot : pointList)
			{
				spot.x += xvel[i];
				spot.y += yvel[i];

				// bounce dots around
				if ((spot.x + SIZE) > getWidth() || spot.x < 0)
				xvel[i] = -xvel[i];

				if (spot.y > getHeight() || spot.y < 0)
				yvel[i] = -yvel[i];

				i++;
			}

            repaint();
         }

	 }

}