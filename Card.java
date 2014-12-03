/*Collin Turner
CS 110
10/06/14
Assignment #5, this is a prgoram that creates
a class with cards. Each card has a suit and rank
*/

public class Card
{
   //Initializ suits
   public static int SPADES = 1, HEARTS = 2, CLUBS = 3, DIAMONDS = 4; 
               
   //Initialize ranks
   public static int ACE = 14, TWO = 2, THREE = 3, FOUR = 4, FIVE = 5, SIX = 6, SEVEN = 7, 
                     EIGHT = 8, NINE = 9, TEN = 10, JACK = 11, QUEEN = 12, KING = 13;
                     
   private int rank, suit;
   
   
   
   /** Constructor that initiates and sets the rank and
   the suit to the inputs and arguements
   @param rnk is the the number value given to the individual card
   @param st is the suit given to the card
   */
   
   public Card(int rnk, int st)
   {
      rank = rnk;
      suit = st;
   }
   
   //Method that return the value of the suit, 100-400.
   public int getSuit()
   {
      return suit;
   }
   
   //Method used to return the rank or value of the card, 1-13.
   public int getRank()
   {
      return rank;
   }
   
   //Method that return the rank of the card in a string 
   //So it says what type of card, ace, king, jack, two, three, etc.
   public String toString()
   {
      switch(rank)
      {
         case 1:
            return "ACE";
         case 2:
            return "Two";
         case 3:
            return "Three";
         case 4:
            return "Four";
         case 5:
            return "Five";
         case 6:
            return "Six";
         case 7:
            return "Seven";
         case 8:
            return "Eight";
         case 9:
            return "Nine";
         case 10:
            return "Ten";
         case 11:
            return "Jack";
         case 12:
            return "Queen";
         case 13:
            return "King";
         default:
            return "Ace";   
      }
   }
   
   //method that returns the suit of the card in a string
   public String suitToString()
   {
      switch(suit)
      {
         case 1:
            return "Spades";
         case 4:
            return "Diamonds";
         case 2:
            return "Hearts";
         case 3:
            return "Clubs";
         default:
            return "Spades";
         
      }
   }
   
   //method that tests if two cards that are created 
   //are the same by testing if the ranks value of both cards equal
   public boolean equals(Card otherCard)
   {
      if(rank == otherCard.rank)
         return true;
      else
         return false;
   }

   
   //Test
   public static void main(String [] args)
   {
      Card card1 = new Card(Card.FOUR, Card.SPADES);
      int ranks = card1.getRank();
      System.out.println(ranks);
      
      int suits = card1.getSuit();
      System.out.println(suits);
      
      Card card2 = new Card(Card.ACE, Card.DIAMONDS);
      System.out.println(card1.equals(card2));
      System.out.println(card1.toString());
      System.out.println(card1.suitToString());
      
   }
      

}