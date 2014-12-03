/**
Collin Turner  
CS 110
Player class to hold information 
about the players in the game
*/

public class Player
{
   private int points;     //holds the number of points that the player has
   private String name;    //holds the name of player  
   
   
   /*
   Constructor with no-args
   */
   public Player()
   {
      points = 0;
      name = "Player";
   }

   /*
   Constructor with string arg for name
   */
   public Player(String n)
   {
      points = 0;
      name = n;
   }


   /*
   Constructor with name and points params
   */
   public Player(int p, String n)
   {
      points = p;
      name = n;
   }

   /*
   method to get the player name
   */
   public String getName()
   {
      return name;
   }
   
   /*
   method to set name
   */
   public void setName(String n)
   {
      name = n;
   }

   /*
   method to get the points player has
   */
   public int getPoints()
   {
      return points;
   }

   /*
   method to set the points for player
   */
   public void setPoints(int p)
   {
      points = p;
   }

   /*
   method to add point to total points
   */
   public void addPoint()
   {
      points++;
   }

   /*
   Method to subtract a point from the total
   */
   public void subPoint()
   {
      points--;
   }
}