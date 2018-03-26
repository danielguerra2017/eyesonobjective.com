// Project 2
// A 2-D Rubik's Cube application

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class Project2_panel extends JPanel implements MouseListener {

   private Rubik cube;
   int count;

   // w: width
   // h: height
   public Project2_panel(int w, int h)
   {
   		// create a rubik cube
   		cube = new Rubik(w, h);
   		// set panel layout
        this.setLayout( new BorderLayout() );
        // add cube to the panel
        this.add( cube, BorderLayout.CENTER );
   		// add mouse listener
   		addMouseListener(this);
   		// set size
   		setPreferredSize(new Dimension(w, h));
   }

// MouseListener event handlers

   // handle event when mouse released immediately after press
   public void mouseClicked( MouseEvent event )
   {

     if (count == 0){
	cube.Turn(Rubik.LEFT);
     }

     if (count == 1){
     cube.Turn(Rubik.RIGHT);
     }

     if (count == 2){
     cube.Turn(Rubik.UP);
     }

     if (count == 3){
     cube.Turn(Rubik.DOWN);
     }

     if (count == 4){
     cube.Twist(Rubik.LEFT,0);
     }

     if (count == 5){
     cube.Twist(Rubik.RIGHT,1);
     }

     if (count == 6){
     cube.Twist(Rubik.UP,2);
     }

     if (count == 7){
     cube.Twist(Rubik.DOWN,0);
     }

     if (count == 8){
     cube.Twist(Rubik.LEFT,2);
     }

     if (count == 9){
     cube.Twist(Rubik.RIGHT,2);
     }

     if (count == 10){
     cube.Twist(Rubik.UP,0);
     }

     if (count == 11){
     cube.Twist(Rubik.DOWN,1);
     }

     if (count == 12){
     cube.Twist(Rubik.LEFT,2);
     }

     if (count == 13){
     cube.Twist(Rubik.RIGHT,0);
     }

     if (count == 14){
     cube.Twist(Rubik.UP,1);
     }

     if (count == 15){
     cube.Twist(Rubik.DOWN,2);
     }

     if (count == 16){
     cube.Reset();
     }

     if (count == 17){
     cube.Scramble();
     }

     if (count == 18){
     cube.Reset();
     }

     count++;

   }

   // handle event when mouse pressed
   public void mousePressed( MouseEvent event ) { }

   // handle event when mouse released after dragging
   public void mouseReleased( MouseEvent event ) { }

   // handle event when mouse enters area
   public void mouseEntered( MouseEvent event ) { }

   // handle event when mouse exits area
   public void mouseExited( MouseEvent event ) { }




}  // end class Project1



