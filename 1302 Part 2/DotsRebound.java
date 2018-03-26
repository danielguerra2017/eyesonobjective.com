import javax.swing.JFrame;

public class DotsRebound
{
   //-----------------------------------------------------------------
   //  Creates and displays the application frame.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Dots");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add (new DotsReboundPanel());

      frame.pack();
      frame.setVisible(true);
   }
}
