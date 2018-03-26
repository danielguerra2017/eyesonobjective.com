//********************************************************
// superhero.java
// Author: Daniel S. Guerra
// 1 May 2013
// Purpose: Superhero battles
//********************************************************

import javax.swing.JFrame;
import java.awt.*;

public class superhero
{

	public static void main (String[] args)
	{						
		JFrame frame = new JFrame ("DC vs Marvel");
		frame.getContentPane().setBackground(Color.BLUE);
		frame.getContentPane().add(new superheroPanel());
		frame.setPreferredSize (new Dimension(695, 725));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
			
	}

}

