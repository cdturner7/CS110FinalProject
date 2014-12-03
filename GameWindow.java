/**
Collin Turner
CS110
Final Project
game window class that creates 
the game window in a class
*/

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame
{
      
   /**
   Constructor
   */   
   public GameWindow()
   {
      
      //set the background color of board
      getContentPane().setBackground(Color.getHSBColor(0.3f, 1.0f, 0.5f));
      
      //set title of the window
      setTitle("Game of War");
      
      //Set layout to a BorderLayout...HOR and VERT gaps in between(int horz, int vert)
      setLayout(new BorderLayout(200, 100));
      
      //set the exit on close buton
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
///////////////////////////////////////////////////////////////////////////////////      
      
      //Create all of the Panels...
      JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 10));
      north.setBackground(Color.getHSBColor(0.3f, 1.0f, 0.5f));
      
      JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER, 250, 10));
      south.setBackground(Color.getHSBColor(0.3f, 1.0f, 0.6f));
      
      JPanel east = new JPanel();
      east.setBackground(Color.getHSBColor(0.3f, 1.0f, 0.5f));
      
      JPanel west = new JPanel();
      west.setBackground(Color.getHSBColor(0.3f, 1.0f, 0.5f));
      
      JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 80));
      center.setBackground(Color.getHSBColor(0.3f, 1.0f, 0.5f));
      
/////////////////////////////////////////////////////////////////////
////////////Labels, Panels, Buttons, and images used/////////////////
/////////////////////////////////////////////////////////////////////
      
      //Create the title label for the board for North
      JLabel titleLabel = new JLabel("WAR");
      titleLabel.setFont(new Font("Serif", Font.BOLD, 50));
      
      //player name inputs for North
      JTextField play1 = new JTextField("Player One", 10);
      JTextField play2 = new JTextField("Player Two", 10);
      
////      
      //Battle button created for the Center
      //BattleButton battle = new BattleButton();
      JButton battle = new JButton("Battle");
      battle.addActionListener(new BattleButtonListener());
      
////      
      //War button created in South
      //WarButton war = new WarButton();
      JButton war = new JButton("War!");
      war.setBackground(Color.RED);
      war.addActionListener(new WarButtonListener());
      
      //Label that has player1 points
      JLabel points1 = new JLabel("Player One Cards: ");//, deck1.cardsRemaining()
      points1.setFont(new Font("Serif", Font.BOLD, 20));
      points1.setForeground(Color.WHITE);
      
      //Label that has player2 points
      JLabel points2 = new JLabel("Player Two Cards: ");//, deck2.cardsRemaining()
      points2.setFont(new Font("Serif", Font.BOLD, 20));
      points2.setForeground(Color.WHITE);
      
      //Button for the exit game and display winner
      JButton done = new JButton("Done");
      done.addActionListener(new DoneButtonListener());
      
      
      
      
      
////      
      //Image for player one deck in West
      ImageIcon backW = new ImageIcon("back.jpg");
      JLabel backWest = new JLabel(backW);
      
      
      
      
      
////      
      //Image for player two deck in East
      ImageIcon backE = new ImageIcon("back.jpg");
      JLabel backEast = new JLabel(backE);
      
      
      
      
      
      
/////////////////////////////////////////////////////////////////////      
      
      //create the north panel by adding components
      north.add(play1);
      north.add(titleLabel);
      north.add(play2);
      
      //create the South panel by adding components
      south.add(points1);
      south.add(war);
      south.add(points2);
      
      
      //create the West panel by adding components
      west.add(backWest);
      
      //create the East panel by adding components
      east.add(backEast);
      
      //create the Center panel by adding components
      center.add(battle);
      center.add(done);
      
      
      
      
///////////////////////////////////////////////////////////////////      
      
      
      //add north panel to the North of borderlayout
      add(north, BorderLayout.NORTH);
      
      //add panels to the South of borderlayout
      add(south, BorderLayout.SOUTH);
      
      //add panels to the Center of window
      add(center, BorderLayout.CENTER);
      
      //add panels to the West
      add(west, BorderLayout.WEST);
      
      //add panels to the East
      add(east, BorderLayout.EAST);
      
      //pack and display the window
      pack();
      
      setVisible(true);
   
   }
   
////////////////////////////////////////////////////////////////   
   /**
   inner class for when the Battle button is clicked
   */
   class BattleButtonListener implements ActionListener
   {
      public void actionPerformed (ActionEvent e) 
      {
         //When the button is pushed, the cards
         //for each player are flipped
         
         ImageIcon one = new ImageIcon("10d.jpg");
         JLabel flip1 = new JLabel(one);         
         //west.add(flip1);
         ImageIcon two = new ImageIcon("2d.jpg");
         JLabel flip2 = new JLabel(two);
         //east.add(flip1);
      }
   }
   
//////////////////////////////////////////////////////////////////////////////


   private class WarButtonListener implements ActionListener
   {
      public void actionPerformed (ActionEvent e) 
      {
         //When the button is pushed, the cards
         //for each player are flipped one down and 
         //one up which is compared again for WAR
         
         ImageIcon one = new ImageIcon("back.jpg");
         JLabel flip1 = new JLabel(one);         
         //Display it on the left side of screen
         ////west.add(flip1);
         
         ImageIcon up1 = new ImageIcon("10d.jpg");
         JLabel flip12 = new JLabel(up1);         
         //Display it on the left side of screen
         ////west.add(flip12);

         ImageIcon two = new ImageIcon("back.jpg");
         JLabel flip2 = new JLabel(two);
         //Display on the right side
         ////east.add(flip2);
         
         ImageIcon up2 = new ImageIcon("2d.jpg");
         JLabel flip22 = new JLabel(up2);
         //Display on the right side
         ////east.add(flip22);
         
      }
   }

/////////////////////////////////////////////////////////////

   private class DoneButtonListener implements ActionListener
   {
      public void actionPerformed (ActionEvent e) 
      {
         //Display the winner in JOptionPane
         JOptionPane.showMessageDialog(null, "The winner is: "/*Winner name*/);
         
         //north.setBackground(Color.RED);
         System.exit(0);      
      }
   }
}