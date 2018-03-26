//********************************************************
// superhero.java
// Author: Daniel S. Guerra
// 1 May 2013
// Purpose: Superhero battles
//********************************************************

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	public class superheroPanel extends JFrame
	{
		public superheroPanel()
		{	
		
		int z = 1;
		
		while (z == 0)
		{
			System.exit(0);
		}
		 while (z == 2)
		 {
			 System.out.println("weird");
		 }
				
		JFrame frame = new JFrame ("DC vs Marvel");
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setPreferredSize (new Dimension(695, 725));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//***********
		// Variables
		//***********
		
		Random generator = new Random();
		
		String badName;
		String moveName;
		String theirMoveName;
		String yourChar;
		
		int easyRand;
		int easyGiveRand;
		int normRand;
		int normGiveRand;
		int hardRand;
		int hardGiveRand;
		
		int compDiff;
		int damageOutput;
		
		int i = 0;
		int u = 0;
		
		int badGuyRand;
		int movesRand;
		int theirMovesRand;
		
		//*******************
		// Marvel Characters
		//*******************
		
		String[] marvel = {"Hulk", "Ironman", "Spiderman", "Thor"};
		
		badGuyRand = generator.nextInt(4);
		int badGuyChoice = badGuyRand;
		
		if (badGuyChoice == 0)
		{
			badName = marvel[0];
		}
		
			else if (badGuyChoice == 1)
			{
				badName = marvel[1];
			}
		
				else if (badGuyChoice == 2)
				{
					badName = marvel[2];
				}
		
					else
					{
						badName = marvel[3];
					}		

		//**************
		// User Choices
		//**************
		
		Object[] options = {"Easy", "Normal", "Hard"};
		
		int difficulty = JOptionPane.showOptionDialog(frame,
				"Choose Difficulty",
				"DC vs MARVEL",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
		
		Object[] optionsTwo = {"Superman",
		        "Batman", "The Flash", "Green Lantern"};
				
		int superheroPick = JOptionPane.showOptionDialog(frame,
				"Choose the superhero you wish to play as!",
				"DC vs MARVEL",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				optionsTwo,  //the titles of buttons
				optionsTwo[0]); //default button title
		
		Object[] optionsThree = {"Offensive",
		        "Defensive"};
				
		int fightStyle = JOptionPane.showOptionDialog(frame,
				"Choose your fighting style!",
				"DC vs MARVEL",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				optionsThree,  //the titles of buttons
				optionsThree[0]); //default button title
		
		//********************************
		// Superhero selection connection
		//********************************
		
		while (z == 1)
		{
			
			int health = 100;
			int badHealth = 100;
			int dead = 0;
		
		if (superheroPick == 0)
		{
			yourChar = "Superman";
		}
		
			else if (superheroPick == 1)
			{
				yourChar = "Batman";
			}
		
				else if (superheroPick == 2)
				{
					yourChar = "The Flash";
				}
		
					else
					{
						yourChar = "Green Lantern";
					}
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.BLUE);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Georgia", Font.BOLD, 11));
		textArea.setColumns(250);
		textArea.setRows(250);
		textArea.setTabSize(250);
		textArea.setText("");
		textArea.setBounds(10, 11, 500, 800);
		
		//**************
		// Main Program
		//**************
		
		while (health > dead && badHealth > dead)
		{
					
			if (difficulty == 0)
			{
				
				//*******************
				// Style of fighting
				//*******************
				
				if (fightStyle == 0)
				{
					//******************************
					// Computer doing damage to you	
					//******************************
					
					easyRand = generator.nextInt(5);
					compDiff = easyRand * 4;
					
					int recDamage = health;
					health = recDamage - compDiff;
					
					//******************************
					// You doing damage to computer
					//******************************
					
					easyGiveRand = generator.nextInt(6) + 1;
					damageOutput = easyGiveRand * 4;
					
					int giveDamage = badHealth;
					badHealth = giveDamage - damageOutput;
				}
				
					else if (fightStyle == 1)
					{
					
						//******************************
						// Computer doing damage to you	
						//******************************
					
						easyRand = generator.nextInt(5);
						compDiff = easyRand * 4;
					
						//************************************
						// You shielding damage from computer
						//************************************
					
						easyGiveRand = generator.nextInt(6);
						damageOutput = easyGiveRand * 4;
					
						int shield = compDiff - damageOutput;
					
							if (shield >= 0 )
							{
								int recDamage = health;
								health = recDamage - shield;
							}
					
								else
								{
									int giveDamage = badHealth;
									badHealth = giveDamage + shield;
								}
				
					}				
				
				//*******
				// Moves
				//*******
				
				String[] yourMoves = {"punched", "kicked", "threw", "headbutt"};
				String[] theirMoves = {"kicked", "threw", "headbutt", "punched"};
				
				movesRand = generator.nextInt(4);
				int chosenMove = movesRand;
				
				theirMovesRand = generator.nextInt(4);
				int theirChosenMove = theirMovesRand;
				
				if (chosenMove == 0)
				{
					moveName = yourMoves[0];
				}
				
					else if (chosenMove == 1)
					{
						moveName = yourMoves[1];
					}
			
						else if (chosenMove == 2)
						{
							moveName = yourMoves[2];
						}
				
							else
							{
								moveName = yourMoves[3];
							}
				
				//**************************************************
				//**************************************************
				//**************************************************
				
				if (theirChosenMove == 0)
				{
					theirMoveName = theirMoves[0];
				}
				
					else if (theirChosenMove == 1)
					{
						theirMoveName = theirMoves[1];
					}
				
						else if (theirChosenMove == 2)
						{
							theirMoveName = theirMoves[2];
						}
					
							else
							{
								theirMoveName = theirMoves[3];
							}
				
				//************
				// HP output
				//************
				
				if (health <= 0)
				{
					textArea.append(badName + " " + theirMoveName +  " " + yourChar + ". " + yourChar + " has been defeated!\n");
					u++;
					z++;
				}
				
					else if (badHealth <= 0)
					{
						textArea.append(yourChar + " " + moveName + " " + badName + ". " + badName + " has been defeated!\n");
						i++;
						z++;
					}
				
						else
						{
							textArea.append(yourChar + " " + moveName + " " + badName + ". " + badName + " has " + badHealth + " hp left.\n");
							textArea.append(badName + " " + theirMoveName +  " " + yourChar + ". " + yourChar + " has " + health + " hp left.\n\n");
						}
			}
		
				else if (difficulty == 1)
				{
					//*******************
					// Style of fighting
					//*******************
				
					if (fightStyle == 0)
					{
						///******************************
						// Computer doing damage to you	
						//******************************
					
						normRand = generator.nextInt(5) + 3;
						compDiff = normRand * 4;
					
						int recDamage = health;
						health = recDamage - compDiff;
					
						//******************************
						// You doing damage to computer
						//******************************
					
						normGiveRand = generator.nextInt(5) + 3;
						damageOutput = normGiveRand * 4;
					
						int giveDamage = badHealth;
						badHealth = giveDamage - damageOutput;
					}
				
						else if (fightStyle == 1)
						{
							//******************************
							// Computer doing damage to you	
							//******************************
					
							easyRand = generator.nextInt(5) + 3;
							compDiff = easyRand * 4;
					
							//************************************
							// You shielding damage from computer
							//************************************
					
							easyGiveRand = generator.nextInt(5) + 2;
							damageOutput = easyGiveRand * 4;
					
							int shield = compDiff - damageOutput;
					
							if (shield >= 0 )
							{
								int recDamage = health;
								health = recDamage - shield;
							}
					
								else
								{
									int giveDamage = badHealth;
									badHealth = giveDamage + shield;
								}
				
						}
						
				//*******
				// Moves
				//*******
				
				String[] yourMoves = {"punched", "kicked", "threw", "headbutt"};
				String[] theirMoves = {"kicked", "threw", "headbutt", "punched"};
				
				movesRand = generator.nextInt(4);
				int chosenMove = movesRand;
				
				theirMovesRand = generator.nextInt(4);
				int theirChosenMove = theirMovesRand;
				
				if (chosenMove == 0)
				{
					moveName = yourMoves[0];
				}
				
					else if (chosenMove == 1)
					{
						moveName = yourMoves[1];
					}
				
						else if (chosenMove == 2)
						{
							moveName = yourMoves[2];
						}
				
							else
							{
								moveName = yourMoves[3];
							}
				
				//**************************************************
				//**************************************************
				//**************************************************
				
				if (theirChosenMove == 0)
				{
					theirMoveName = theirMoves[0];
				}
				
					else if (theirChosenMove == 1)
					{
						theirMoveName = theirMoves[1];
					}
				
						else if (theirChosenMove == 2)
						{
							theirMoveName = theirMoves[2];
						}
				
							else
							{
								theirMoveName = theirMoves[3];
							}
					
				//************
				// HP output
				//************
				
				if (health <= 0)
				{
					textArea.append(badName + " " + theirMoveName +  " " + yourChar + ". " + yourChar + " has been defeated!\n");
					u++;
					z++;
				}
				
					else if (badHealth <= 0)
					{
						textArea.append(yourChar + " " + moveName + " " + badName + ". " + badName + " has been defeated!\n");
							i++;
							z++;
					}
				
						else
						{
							textArea.append(yourChar + " " + moveName + " " + badName + ". " + badName + " has " + badHealth + " hp left.\n");
							textArea.append(badName + " " + theirMoveName +  " " + yourChar + ". " + yourChar + " has " + health + " hp left.\n\n");
						}
				
				}
		
					else
					{
				
						//*******************
						// Style of fighting
						//*******************
				
						if (fightStyle == 0)
						{
							//******************************
							// Computer doing damage to you	
							//******************************
							
							hardRand = generator.nextInt(5) + 6;
							compDiff = hardRand * 4;
					
							int recDamage = health;
							health = recDamage - compDiff;
					
							//******************************
							// You doing damage to computer
							//******************************
					
							hardGiveRand = generator.nextInt(5) + 5;
							damageOutput = hardGiveRand * 4;
					
							int giveDamage = badHealth;
							badHealth = giveDamage - damageOutput;
						}
				
							else if (fightStyle == 1)
							{
								
								//******************************
								// Computer doing damage to you	
								//******************************
					
								easyRand = generator.nextInt(5) + 6;
								compDiff = easyRand * 4;
					
								//************************************
								// You shielding damage from computer
								//************************************
					
								easyGiveRand = generator.nextInt(5) + 4;
								damageOutput = easyGiveRand * 4;
					
								int shield = compDiff - damageOutput;
					
								if (shield >= 0 )
								{
									int recDamage = health;
									health = recDamage - shield;
								}
					
									else
									{
										int giveDamage = badHealth;
										badHealth = giveDamage + shield;
									}
				
							}
				
				//*******
				// Moves
				//*******
				
				String[] yourMoves = {"punched", "kicked", "threw", "headbutt"};
				String[] theirMoves = {"kicked", "threw", "headbutt", "punched"};
				
				movesRand = generator.nextInt(4);
				int chosenMove = movesRand;
				
				theirMovesRand = generator.nextInt(4);
				int theirChosenMove = theirMovesRand;
				
				if (chosenMove == 0)
				{
					moveName = yourMoves[0];
				}
				
					else if (chosenMove == 1)
					{
						moveName = yourMoves[1];
					}
				
						else if (chosenMove == 2)
						{
							moveName = yourMoves[2];
						}
				
							else
							{
								moveName = yourMoves[3];
							}
				
				//**************************************************
				//**************************************************
				//**************************************************
				
				if (theirChosenMove == 0)
				{
					theirMoveName = theirMoves[0];
				}
				
					else if (theirChosenMove == 1)
					{
						theirMoveName = theirMoves[1];
					}
				
						else if (theirChosenMove == 2)
						{
							theirMoveName = theirMoves[2];
						}
				
							else
							{
								theirMoveName = theirMoves[3];
							}
				
				//************
				// HP output
				//************
				
				if (health <= 0)
				{
					textArea.append(badName + " " + theirMoveName +  " " + yourChar + ". " + yourChar + " has been defeated!\n");
					u++;
					z++;
				}
				
					else if (badHealth <= 0)
					{
						textArea.append(yourChar + " " + moveName + " " + badName + ". " + badName + " has been defeated!\n");
						i++;
						z++;
					}
				
						else
						{
							textArea.append(yourChar + " " + moveName + " " + badName + ". " + badName + " has " + badHealth + " hp left.\n");
							textArea.append(badName + " " + theirMoveName +  " " + yourChar + ". " + yourChar + " has " + health + " hp left.\n\n");
						}
				}
			
		}
		
		frame.pack();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.RED);
		frame.getContentPane().add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 63, 5));
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		resetButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		
		resetButton.setBackground(Color.YELLOW);
		
		northPanel.add(resetButton);
		
		JButton instructButton = new JButton("Instructions");
		instructButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		instructButton.setBackground(Color.YELLOW);
		instructButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent instructions) 
			{
				JOptionPane.showMessageDialog(null, "Instructions for DC vs MARVEL Game" +
													"\n\nChoose your level of difficulty, the character you wish to\n" +
													"play as, and the fighting style you wish to fight with (Note: Different\n" +
													"fighting styles have different ways of dealing damage and will produce\n" +
													"different results).\n\n" +
													"The RESET button will reset the entire program, allowing the user to\n" +
													"choose different settings.\n\n " + "" +
													"The BATTLE AGAIN button will use the same settings and battle the same\n" + 
													"characters again.\n\n" +
													"The QUIT button will exit the program entirely.");
			}
		});
		
		northPanel.add(instructButton);
		
		JButton battleAgainButton = new JButton("Battle Again");
		battleAgainButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		battleAgainButton.setBackground(Color.YELLOW);
		northPanel.add(battleAgainButton);
		
		final JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent quit) 
			{
				if (quit.getSource() == quitButton)
				{
					new superheroPanel();
				}
			}
		});
		quitButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		quitButton.setBackground(Color.YELLOW);
		northPanel.add(quitButton);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.RED);
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerPanelNorth = new JPanel();
		centerPanelNorth.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(64, 64, 64), null));
		centerPanelNorth.setBackground(Color.RED);
		centerPanel.add(centerPanelNorth, BorderLayout.NORTH);		
		
		if (superheroPick == 0)
		{
			JLabel yourLabel = new JLabel("SUPERMAN");
			yourLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
			yourLabel.setForeground(Color.WHITE);
			centerPanelNorth.add(yourLabel);
		}

			else if (superheroPick == 1)
			{
				JLabel yourLabel = new JLabel("BATMAN");
				yourLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
				yourLabel.setForeground(Color.WHITE);
				centerPanelNorth.add(yourLabel);
			}

				else if (superheroPick == 2)
				{
					JLabel yourLabel = new JLabel("THE FLASH");
					yourLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
					yourLabel.setForeground(Color.WHITE);
					centerPanelNorth.add(yourLabel);
				}

					else
					{
						JLabel yourLabel = new JLabel("GREEN LANTERN");
						yourLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
						yourLabel.setForeground(Color.WHITE);
						centerPanelNorth.add(yourLabel);
					}
		
		JLabel vsLabel = new JLabel("VS");
		vsLabel.setForeground(Color.BLACK);
		vsLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		centerPanelNorth.add(vsLabel);
		
		if (badGuyChoice == 0)
		{
			JLabel compLabel = new JLabel("HULK");
			compLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
			compLabel.setForeground(Color.WHITE);
			centerPanelNorth.add(compLabel);
		}

			else if (badGuyChoice == 1)
			{
				JLabel compLabel = new JLabel("IRONMAN");
				compLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
				compLabel.setForeground(Color.WHITE);
				centerPanelNorth.add(compLabel);
			}

				else if (badGuyChoice == 2)
				{
					JLabel compLabel = new JLabel("SPIDERMAN");
					compLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
					compLabel.setForeground(Color.WHITE);
					centerPanelNorth.add(compLabel);
				}

					else
					{
						JLabel compLabel = new JLabel("THOR");
						compLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
						compLabel.setForeground(Color.WHITE);
						centerPanelNorth.add(compLabel);
					}
		
		JPanel centerPanelCenter = new JPanel();
		centerPanelCenter.setBackground(Color.BLUE);
		centerPanel.add(centerPanelCenter, BorderLayout.CENTER);
		centerPanelCenter.setLayout(null);
		
		JPanel centerPanelSouth = new JPanel();
		centerPanelSouth.setBackground(Color.BLUE);
		centerPanel.add(centerPanelSouth, BorderLayout.SOUTH);
		centerPanelSouth.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.BLUE);
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("SCORE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
		leftPanel.add(lblNewLabel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.BLUE);
		frame.getContentPane().add(rightPanel, BorderLayout.EAST);
		
		JLabel lblNewLabel_2 = new JLabel("SCORE");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
		rightPanel.add(lblNewLabel_2);
		
		if (i == 0)
		{
			JLabel yourScore = new JLabel("0");
			yourScore.setForeground(Color.YELLOW);
			yourScore.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
			leftPanel.add(yourScore);
		}
	
			else if (i == 1)
			{
				JLabel yourScore = new JLabel("1");
				yourScore.setForeground(Color.YELLOW);
				yourScore.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
				leftPanel.add(yourScore);
			}
		
		if (u == 0)
		{
			JLabel compScore = new JLabel("0");
			compScore.setForeground(Color.YELLOW);
			compScore.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
			rightPanel.add(compScore);
		}
		
			else if (u == 1)
			{
				JLabel compScore = new JLabel("1");
				compScore.setForeground(Color.YELLOW);
				compScore.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
				rightPanel.add(compScore);
			}
		
		centerPanelCenter.add(textArea);
		
		frame.setVisible(true);
			
		}
	}
}