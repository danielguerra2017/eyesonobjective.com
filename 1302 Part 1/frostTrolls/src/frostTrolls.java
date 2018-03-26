import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

//********************************************************
//  frostTrolls.java
//  Authors: Daniel S. Guerra & Brian Dix & Darryl Hardy
//  Begin Date: 1 May 2013
//  Last Modified: 18 May 2013
//  Purpose: First edition of game
//********************************************************

public class frostTrolls
{
	//*******************
	//  Static variables
	//*******************
	
	static int compLevel = 1;
	static int playerLevel = 1;
	
	static int compDamage;
	static int playerDamage;
	
	static int playerHealth = 50;
	static int compHealth = 50;
	static int playerLvlHealth;
	static int compLvlHealth;
	
	static int compRandDiff;
	static int playerRandDiff;
	
	static int playerXP = 250;
	
	static String yourChar;
	
	//**********************************************
	//  Create computer and player level difficulty
	//**********************************************
	
	public static void level()
	{
		//*******************
		//  Random Generator
		//*******************
				
		Random generator = new Random();
				
		if (playerLevel == 1)
		{
			//*********************
			//  Health for Level 1
			//*********************
			
			playerLvlHealth = playerHealth;
			compLvlHealth = compHealth;
			
			//*******************************
			//  Computer doing damage to you	
			//*******************************
			
			compRandDiff = generator.nextInt(5) + 1;
			compDamage = compRandDiff;
			
			int compGiveDamage = playerLvlHealth;
			playerLvlHealth = compGiveDamage - compDamage;
			
			//*******************************
			//  You doing damage to computer
			//*******************************
			
			playerRandDiff = generator.nextInt(5) + 1;
			playerDamage = playerRandDiff;
			
			int playerGiveDamage = compLvlHealth;
			compLvlHealth = playerGiveDamage - playerDamage;
		}
		
			if (playerLevel == 2)
			{
				//*********************
				//  Health for Level 2
				//*********************
				
				playerLvlHealth = playerHealth + 5;
				compLvlHealth = compHealth + 5;
				
				//*******************************
				//  Computer doing damage to you	
				//*******************************
			
				compRandDiff = generator.nextInt(8) + 3;
				compDamage = compRandDiff;
			
				int compGiveDamage = playerLvlHealth;
				playerLvlHealth = compGiveDamage - compDamage;
			
				//*******************************
				//  You doing damage to computer
				//*******************************
			
				playerRandDiff = generator.nextInt(8) + 3;
				playerDamage = playerRandDiff;
			
				int playerGiveDamage = compLvlHealth;
				compLvlHealth = playerGiveDamage - playerDamage;
			}
	}
	
	//******************************
	//  Give player XP to buy items
	//******************************
	
	public static void XP()
	{
		
	}

	public static void main (String[] args) throws IOException
	{		
		//*******************
		//  Random Generator
		//*******************
		
		Random generator = new Random();
		
		//************
		//  Variables
		//************
		
		int backgroundRandom;
		
		//********************
		//  Create New Object
		//********************
				
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame firstFrame = new JFrame("TITAN MOON v1.0");
		firstFrame.setIconImage(new ImageIcon("FrostTrollsLogo.png").getImage());
		firstFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		firstFrame.setPreferredSize (new Dimension (425, 135));
		firstFrame.pack();
		firstFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel firstFrameNorthPanel = new JPanel();
		firstFrameNorthPanel.setBackground(new Color(0, 51, 102));
		firstFrame.getContentPane().add(firstFrameNorthPanel, BorderLayout.NORTH);
		
		JPanel firstFrameSouthPanel = new JPanel();
		firstFrameSouthPanel.setBackground(new Color(0, 51, 102));
		firstFrame.getContentPane().add(firstFrameSouthPanel, BorderLayout.CENTER);
		
		JLabel firstFrameLabel = new JLabel("Choose the character you wish to battle with!");
		firstFrameLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 16));
		firstFrameLabel.setForeground(new Color(255, 255, 255));
		firstFrameLabel.setBackground(new Color(0, 51, 102));
		firstFrameNorthPanel.add(firstFrameLabel);
		
		JButton fireButton = new JButton();
		JButton waterButton = new JButton();
		JButton forestButton = new JButton();
		JButton earthButton = new JButton();
		JButton thunderButton = new JButton();
		JButton windButton = new JButton();
		
		fireButton.setIcon(new ImageIcon("fireButton.jpg"));
		firstFrameSouthPanel.add(fireButton);
		
		waterButton.setIcon(new ImageIcon("waterButton.jpg"));
		firstFrameSouthPanel.add(waterButton);
		
		forestButton.setIcon(new ImageIcon("forestButton.jpg"));
		firstFrameSouthPanel.add(forestButton);
		
		earthButton.setIcon(new ImageIcon("earthButton.jpg"));
		firstFrameSouthPanel.add(earthButton);
		
		thunderButton.setIcon(new ImageIcon("thunderButton.jpg"));
		firstFrameSouthPanel.add(thunderButton);
		
		windButton.setIcon(new ImageIcon("windButton.jpg"));
		firstFrameSouthPanel.add(windButton);
				
		firstFrame.setVisible(true);
				
		//*************
		//  Main panel
		//*************
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("TITAN MOON v1.0");
		frame.setIconImage(new ImageIcon("FrostTrollsLogo.png").getImage());
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize (new Dimension (1100, 720));
		frame.pack();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//*****************************
		//  Choose character for game
		//*****************************
		
		/*
		 */
		Object[] charOption = {"Fire", "Forest", "Wind", "Earth", "Thunder", "Water"};
				
		int charPick = JOptionPane.showOptionDialog(frame,
				"Choose the character you wish to battle with!",
				"frostTrolls v1.0",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				charOption,  //the titles of buttons
				charOption[0]); //default button title
		
		if (charPick == 0)
		{
			yourChar = "Fire";
		}
		
			else if (charPick == 1)
			{
				yourChar = "Forest";
			}
		
				else if (charPick == 2)
				{
					yourChar = "Wind";
				}
		
					else if (charPick == 3)
					{
						yourChar = "Earth";
					}
			
						else if (charPick == 4)
						{
							yourChar = "Thunder";
						}
		
							else if (charPick == 5)
							{
								yourChar = "Water";
							}
		/*
		*/
		
		//********************************
		//  northPanel and its components
		//********************************
		
		JPanel northPanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) northPanel.getLayout();
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		northPanel.setBackground(new Color(0, 51, 102));
		frame.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		JLabel northLabel = new JLabel("TITAN MOON");
		northLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		northLabel.setForeground(new Color(255, 255, 255));
		northLabel.setBackground(new Color(0, 51, 102));
		northPanel.add(northLabel);		
	    
	    //********************************
	    //  southPanel and its components
	    //********************************
		
		JPanel southPanel = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) southPanel.getLayout();
		flowLayout_3.setVgap(0);
		flowLayout_3.setHgap(0);
		frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		//*******************************
		//  leftPanel and its components
		//*******************************
		
		JPanel leftPanel = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) leftPanel.getLayout();
		flowLayout_4.setVgap(0);
		flowLayout_4.setHgap(0);
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		
		//********************************
		//  rightPanel and its components
		//********************************
		
		JPanel rightPanel = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) rightPanel.getLayout();
		flowLayout_5.setVgap(0);
		flowLayout_5.setHgap(0);
		frame.getContentPane().add(rightPanel, BorderLayout.EAST);
		
		//*********************************
		//  centerPanel and its components
		//*********************************
		
		JPanel centerPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) centerPanel.getLayout();
		flowLayout_1.setHgap(0);
		flowLayout_1.setVgap(0);
		centerPanel.setBackground(new Color(0, 51, 102));
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		//************************************
		//  TabbedPane is added to northPanel
		//************************************
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(0, 51, 102));
		tabbedPane.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		tabbedPane.setForeground(new Color(0, 0, 0));
		centerPanel.add(tabbedPane);
				
		//***************************************
		//  First tab is Battle Grounds
		//***************************************
		//  battleGroundPanel and its components
		//***************************************
				
		JPanel battleGroundPanel = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) battleGroundPanel.getLayout();
		flowLayout_6.setVgap(0);
		flowLayout_6.setHgap(0);
		battleGroundPanel.setForeground(new Color(255, 255, 255));
		battleGroundPanel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("BATTLE GROUNDS", null, battleGroundPanel, "Battle opponents");
		tabbedPane.setBackgroundAt(0, new Color(0, 102, 153));
		
		//*****************************************************
		//  Fighting backgrounds being added to battleSubPanel
		//*****************************************************
		//  Random generator will randomly pick background
		//*****************************************************
		
		JPanel battleSubPanel = new JPanel();
		battleGroundPanel.add(battleSubPanel);
		
		backgroundRandom = generator.nextInt(4);
		int backRand = backgroundRandom;
		
		if (backRand == 0)
		{
			BufferedImage snow = ImageIO.read(new File("snowBackground.jpg"));
	        JLabel snowBack = new JLabel(new ImageIcon( snow ));
	        battleSubPanel.add( snowBack );
		}
		
			else if (backRand == 1)
			{
				BufferedImage forest = ImageIO.read(new File("forestBackground.jpg"));
		        JLabel forestBack = new JLabel(new ImageIcon( forest ));
		        battleSubPanel.add( forestBack );
			}
		
				else if (backRand == 2)
				{
					BufferedImage plains = ImageIO.read(new File("plainsBackground.jpg"));
			        JLabel plainsBack = new JLabel(new ImageIcon( plains ));
			        battleSubPanel.add( plainsBack );
				}
		
					else
					{
						BufferedImage wetlands = ImageIO.read(new File("wetlandsBackground.jpg"));
				        JLabel wetlandsBack = new JLabel(new ImageIcon( wetlands ));
				        battleSubPanel.add( wetlandsBack );
					}
				
		//********************************
		//  Second tab is Store
		//********************************
		//  storePanel and its components
		//********************************
				
		JPanel storePanel = new JPanel();
		storePanel.setForeground(new Color(0, 51, 102));
		storePanel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("STORE", null, storePanel, "Buy what you need");
		storePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel storeNorthPanel = new JPanel();
		storePanel.add(storeNorthPanel, BorderLayout.NORTH);
		
		JLabel storeXPLabel = new JLabel("Available XP:");
		storeXPLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		storeNorthPanel.add(storeXPLabel);
		
		JLabel storeXPAmountLabel = new JLabel("" + playerXP);
		storeXPAmountLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		storeNorthPanel.add(storeXPAmountLabel);
		
		JPanel storeSouthPanel = new JPanel();
		storePanel.add(storeSouthPanel, BorderLayout.SOUTH);
		
		JPanel storeWestPanel = new JPanel();
		storePanel.add(storeWestPanel, BorderLayout.WEST);
		
		JPanel storeEastPanel = new JPanel();
		storePanel.add(storeEastPanel, BorderLayout.EAST);
		
		JPanel storeCenterPanel = new JPanel();
		storePanel.add(storeCenterPanel, BorderLayout.CENTER);
		tabbedPane.setBackgroundAt(1, new Color(0, 102, 153));
			
		//***************************************
		//  Third tab is Instructions
		//***************************************
		//  instructionsPanel and its components
		//***************************************
				
		JPanel instructionsPanel = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) instructionsPanel.getLayout();
		flowLayout_7.setVgap(0);
		flowLayout_7.setHgap(0);
		instructionsPanel.setForeground(new Color(0, 51, 102));
		instructionsPanel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("INSTRUCTIONS", null, instructionsPanel, "Learn how to play");
		
		JTextPane txtpnBlahBlahBlah = new JTextPane();
		txtpnBlahBlahBlah.setFont(new Font("Dutch801 XBd BT", Font.PLAIN, 13));
		txtpnBlahBlahBlah.setBackground(Color.LIGHT_GRAY);
		txtpnBlahBlahBlah.setText("BLAH BLAH BLAH BLAH");
		instructionsPanel.add(txtpnBlahBlahBlah);
		tabbedPane.setBackgroundAt(2, new Color(0, 102, 153));
				
		//*******************************
		//  Forth tab is Save
		//*******************************
		//  savePanel and its components
		//*******************************
				
		JPanel savePanel = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) savePanel.getLayout();
		flowLayout_8.setVgap(0);
		flowLayout_8.setHgap(0);
		savePanel.setForeground(new Color(0, 51, 102));
		savePanel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("SAVE", null, savePanel, "Save your progress");
		tabbedPane.setBackgroundAt(3, new Color(0, 102, 153));
				
		//************************************
		//  Add MouseListener to save actions
		//************************************
				
		//*******************************
		//  Fifth tab is Quit
		//*******************************
		//  quitPanel and its components
		//*******************************
				
		JPanel quitPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) quitPanel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
				
		JPanel insideQuit = new JPanel();
		insideQuit.setBackground(Color.LIGHT_GRAY);
		quitPanel.add(insideQuit);
				
		quitPanel.setForeground(new Color(255, 255, 255));
		quitPanel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("QUIT", null, quitPanel, "Quit the game");
		tabbedPane.setBackgroundAt(4, new Color(0, 102, 153));
		insideQuit.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			    
		JButton quitButton = new JButton("Yes");
		quitButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
			    
		JLabel quitLabel = new JLabel("You are about to exit the game. \n" +
			    						"Are you sure you wish to do this?\n\n");
		quitLabel.setFont(new Font("Dutch801 XBd BT", Font.PLAIN, 13));
		quitLabel.setForeground(Color.BLACK);
		insideQuit.add(quitLabel);
		quitPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{insideQuit, quitLabel, quitButton}));
			    
		insideQuit.add(quitButton);
		
		//****************************
		//  Set game frame to visible
		//****************************
		
		// frame.setVisible(true);
		
	}	
}
