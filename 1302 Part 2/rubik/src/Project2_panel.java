//****************************************************************
//  Created by Daniel S. Guerra
//  1 May 2013
//  Purpose: To create a rubik cube game and log the user's moves
//****************************************************************

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class Project2_panel extends JPanel implements MouseListener
	{
	
	//************
	//  Variables
	//************
	
	private Rubik cube; 
	int count;
	
	public JButton cubeUp, cubeDown, cubeLeft, cubeRight;
    public JButton columnLeftUp, columnMiddleUp, columnRightUp;
    public JButton columnLeftDown, columnMiddleDown, columnRightDown;
    public JButton topRowLeft, middleRowLeft, bottomRowLeft;
    public JButton topRowRight, middleRowRight, bottomRowRight;
    public JButton quitGame, scrambleCube, resetCube, instructions;
    
    final JFileChooser chooseMYfile = new JFileChooser();
    
    //*****************
    //  Create the log
    //*****************
    
    String filePath;
    File file = null;
    PrintWriter writeMYprinting = null;
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    
    //****************************************************
    //  Starting the main portion of the Rubik Cube Panel
    //****************************************************
    
    public Project2_panel(int w, int h)
    {
    	//********************************************
    	//  Have user save file somewhere to computer
    	//********************************************
    	
    	chooseMYfile.showSaveDialog(this);
		file = new File(chooseMYfile.getSelectedFile().getAbsolutePath());
		
		try
		{
			file.createNewFile();
		}
		
		catch(IOException ex)
		{
			
		}
		
		try
		{
			writeMYprinting = new PrintWriter(file);
		}
		
		catch (IOException e)
		{
			
		}
		
		//*************
		//  Main Panel
		//*************
		
		this.setLayout (new GridLayout(2,1));
   		
		//*******************
		//  Creates the cube
		//*******************
		
   		cube = new Rubik(w, h);
   		
   		//****************************************
   		//  Create Bottom Panel Inside Main Panel
   		//****************************************
   		
   		JPanel bottomPanel = new JPanel();
   		bottomPanel.setLayout (new GridLayout(2,2));
   		
   		//**********************************************
   		//  Create Horizontal Panel inside Bottom Panel
   		//**********************************************
   		
   		JPanel horizontal = new JPanel();
   		horizontal.setLayout(new GridLayout(3,3));
   		
   		//***************************************************
   		//  Create JButtons and JLabels for Horizontal Panel
   		//***************************************************
   		
   		topRowLeft = new JButton ("Rotate Left");
   		horizontal.add (topRowLeft);
   		topRowLeft.addMouseListener(this);
   		
   		JLabel topColumn = new JLabel();
   		horizontal.add(topColumn);
   					
   		topRowRight = new JButton ("Rotate Right");
   		horizontal.add (topRowRight);
   		topRowRight.addMouseListener(this);
   					
   		middleRowLeft = new JButton ("Rotate Left");
   		horizontal.add (middleRowLeft);
   		middleRowLeft.addMouseListener(this);
   					
   		JLabel middleColumn = new JLabel();
   		horizontal.add(middleColumn);
   					
   		middleRowRight= new JButton ("Rotate Right");
   		horizontal.add (middleRowRight);
   		middleRowRight.addMouseListener(this);
   					
   		bottomRowLeft= new JButton ("Rotate Left");
   		horizontal.add (bottomRowLeft);
   		bottomRowLeft.addMouseListener(this);
   					
   		JLabel bottomColumn = new JLabel();
   		horizontal.add(bottomColumn);
   					
   		bottomRowRight = new JButton ("Rotate Right");
   		horizontal.add (bottomRowRight);
   		bottomRowRight.addMouseListener(this);
   		
   		//********************************************
   		//  Create Vertical Panel inside Bottom Panel
   		//********************************************
   		
   		JPanel vertical = new JPanel();
   		vertical.setLayout(new GridLayout(3,3));
   		
   		//*************************************************
   		//  Create JButtons and JLabels for Vertical Panel
   		//*************************************************
   				
   		columnLeftUp = new JButton ("Rotate Up");
   		vertical.add (columnLeftUp);
   		columnLeftUp.addMouseListener(this);
   					
   		columnMiddleUp = new JButton ("Rotate Up");
   		vertical.add (columnMiddleUp);
   		columnMiddleUp.addMouseListener(this);
   					
   		columnRightUp = new JButton ("Rotate Up");
   		vertical.add (columnRightUp);
   		columnRightUp.addMouseListener(this);
   					
   		JLabel leftRow = new JLabel();
   		vertical.add(leftRow);
   				
   		JLabel middleRow = new JLabel();
   		vertical.add(middleRow);
   				
   		JLabel rightRow = new JLabel();
   		vertical.add(rightRow);
   				
   		columnLeftDown = new JButton ("Rotate Down");
   		vertical.add (columnLeftDown);
   		columnLeftDown.addMouseListener(this);
   				
   		columnMiddleDown = new JButton ("Rotate Down");
   		vertical.add (columnMiddleDown);
   		columnMiddleDown.addMouseListener(this);
   				
   		columnRightDown = new JButton ("Rotate Down");
   		vertical.add (columnRightDown);
   		columnRightDown.addMouseListener(this);
   		
   		//********************************************
   		//  Create Rotation Panel Inside Bottom Panel
   		//********************************************
   		
   		JPanel rotation = new JPanel();
   		rotation.setLayout (new GridLayout (3,3));
   		
   		//***************************************************
   		// Create JButtons and JLabels Inside Rotation Panel
   		//***************************************************
   				
   		JLabel blankOne = new JLabel();
   		rotation.add(blankOne);
   					
   		cubeUp = new JButton ("CUBE UP");
   		rotation.add (cubeUp);
   		cubeUp.addMouseListener(this);
   					
   		JLabel blankTwo = new JLabel();
   		rotation.add(blankTwo);
   					
   		cubeLeft = new JButton ("CUBE LEFT");
   		rotation.add (cubeLeft);
   		cubeLeft.addMouseListener(this);
   					
   		JLabel blankThree = new JLabel();
   		rotation.add(blankThree);
   					
   		cubeRight = new JButton ("CUBE RIGHT");
   		rotation.add (cubeRight);
   		cubeRight.addMouseListener(this);
   					
   		JLabel blankFour = new JLabel();
   		rotation.add(blankFour);
   					
   		cubeDown = new JButton ("CUBE DOWN");
   		rotation.add (cubeDown);
   		cubeDown.addMouseListener(this);
   					
   		JLabel blankFive = new JLabel();
   		rotation.add(blankFive);
   		
   		//***********************************************
   		//  Add all components together for Bottom Panel
   		//***********************************************
   					
   		bottomPanel.add (horizontal);
   		bottomPanel.add (cube);
   		bottomPanel.add (rotation);
   		bottomPanel.add (vertical);
   		
   		//*************************************
   		//  Create Top Panel Inside Main Panel
   		//*************************************
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout (new GridLayout());
        
        //********************************************
        //  Create Interactive Panel Inside Top Panel
        //********************************************
        
        JPanel interactive = new JPanel();
        interactive.setLayout (new GridLayout(2,2));
        
        //***************************************
        //  Create Buttons for Interactive Panel
        //***************************************
        
	    quitGame = new JButton ("QUIT GAME");
	    interactive.add (quitGame);
	   	quitGame.addMouseListener(this);
	   					
	   	scrambleCube = new JButton ("SCRAMBLE THE CUBE");
	   	interactive.add (scrambleCube);
	   	scrambleCube.addMouseListener(this);
	   					
	   	resetCube = new JButton ("RESET THE CUBE");
	   	interactive.add (resetCube);
	   	resetCube.addMouseListener(this);
	   				
	   	instructions = new JButton ("GAME INSTRUCTIONS");
	   	interactive.add (instructions);
	   	instructions.addMouseListener(this);
	   				
	   	topPanel.add(interactive, BorderLayout.SOUTH);					

        //**********************
        //  Add it all together
	   	//**********************
	   	
	   	this.add(topPanel);
        this.add(bottomPanel);
   		
        //********************************
        //  Add the MouseListener for log
        //********************************
        
   		addMouseListener(this);
   		
   		setPreferredSize(new Dimension(w, h));
    }
    
    public void mouseClicked( MouseEvent event )
   	{
    	if (event.getSource() == cubeLeft)
   		{
    		cube.Turn(Rubik.RIGHT);
			writeMYprinting.println(dateFormat.format(date) + " >> You turned the cube to the right.");
		}
		
		if (event.getSource() == cubeRight)
		{
			cube.Turn(Rubik.LEFT);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the cube to the left.");
		}
		
		if (event.getSource() == cubeUp)
		{
			cube.Turn(Rubik.DOWN);
			writeMYprinting.println(dateFormat.format(date) + " >> You turned the cube down.");
		}
		
		if (event.getSource() == cubeDown)
		{
			cube.Turn(Rubik.UP);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the cube up.");
		}

		if (event.getSource() == topRowLeft)
		{
   			cube.Twist(Rubik.LEFT,0);
   			writeMYprinting.println(dateFormat.format(date) + " >> You turned the top row left.");
   		}
		     
   		if (event.getSource() == middleRowLeft)
		{
   			cube.Twist(Rubik.LEFT,1);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the middle row left.");
		}
		     
		if (event.getSource() == bottomRowLeft)
		{
			cube.Twist(Rubik.LEFT,2);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the bottom row left.");
		}
		     
		if (event.getSource() == topRowRight)
		{
			cube.Twist(Rubik.RIGHT,0);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the top row right.");
		}
		     
		if (event.getSource() == middleRowRight)
		{
			cube.Twist(Rubik.RIGHT,1);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the middle row right.");
		}
		     
		if (event.getSource() == bottomRowRight)
		{
			cube.Twist(Rubik.RIGHT,2);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the bottom row right.");
		}
   		
   		if (event.getSource() == columnLeftUp)
		{
   			cube.Twist(Rubik.UP,0);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the left column up.");
		}
   		
   		if (event.getSource() == columnMiddleUp)
		{
   			cube.Twist(Rubik.UP,1);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the middle column up.");
		}
   		
   		if (event.getSource() == columnRightUp)
		{
   			cube.Twist(Rubik.UP,2);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the right column up.");
		}
   		
   		if (event.getSource() == columnLeftDown)
		{
   			cube.Twist(Rubik.DOWN,0);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the left column down.");
		}
   		
   		if (event.getSource() == columnMiddleDown)
		{
   			cube.Twist(Rubik.DOWN,1);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the middle column down.");
		}
   		
   		if (event.getSource() == columnRightDown)
		{
   			cube.Twist(Rubik.DOWN,2);
		    writeMYprinting.println(dateFormat.format(date) + " >> You turned the right column down.");
		}
   		
     	if (event.getSource() == resetCube)
     	{
     		cube.Reset();
		    writeMYprinting.println(dateFormat.format(date) + " >> You reset the cube.");    
		}
     	
     	if (event.getSource() == scrambleCube)
		{
     		cube.Scramble();
		    writeMYprinting.println(dateFormat.format(date) + " >> You scrambled the cube.");
		}
     	
     	if (event.getSource()== quitGame)
		{
     		writeMYprinting.println(dateFormat.format(date) + " >> You quit the Rubik Cube Game.");
		    writeMYprinting.close();	  
		    System.exit( 0 );
		}
     	
     	if (event.getSource()== instructions)
		{
     		writeMYprinting.println(dateFormat.format(date) + " >> You clicked on the instructions.");
		    JOptionPane.showMessageDialog(null, "Instructions for Rubik Cube" +
					"\n\nIn order to move the pieces of the cube, press the buttons on the\n" +
					"bottom half of the screen. The buttons directly to the left of the cube\n" +
					"will rotate rows horizontally on the cube. The buttons directly below the\n" +
					"cube will rotate rows vertically on the cube. The buttons in the bottom\n" +
					"left corner will rotate to various cube faces, depending which way you\n" +
					"decide to rotate it.\n\n" +
					"The SCRAMBLE button will randomly scramble the cube for you to solve.\n\n" + 
					"The RESET button will reset the cube so that it is properly put back together.\n\n" +
					"The QUIT button will exit the program entirely.");
		}
     	
   	}
    
    //******************
    //  Not used events
    //******************
    
    public void mousePressed( MouseEvent event ) { }
    public void mouseReleased( MouseEvent event ) { }
    public void mouseEntered( MouseEvent event ) { }
    public void mouseExited( MouseEvent event ) { }
 
}  



