//********************************************************
// superhero.java
// Author: Daniel S. Guerra
// 1 May 2013
// Purpose: Superhero battles
//********************************************************

import javax.swing.JFrame;
import java.awt.*;

public class madness
{

	public static void main (String[] args)
	{						
		JFrame frame = new JFrame ("Madness");
		frame.getContentPane().setBackground(Color.BLUE);
		frame.getContentPane().add(new madnessPanel());
		frame.setPreferredSize (new Dimension(695, 725));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
			
	}

}