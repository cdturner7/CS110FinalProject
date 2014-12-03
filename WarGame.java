
import java.util.ArrayList;
import java.util.Scanner;

public class WarGame
{
   public static void main(String[] args)
   {
      
      //Initialize
      Card flip1;          //holds the card that is flipped by player 1
      Card flip2;          //holds the card that is flipped by player 2
      Card win;            //holds the card that is greater 
      
      Card down1;          //holds the facedown card of player1 
      Card down2;          //holds the facedown card of player2
      
      Card up1;            //Holds the next card drawn if there is a war for Player1
      Card up2;            //Holds the next card drawn if there is a war for Player2

      String input;        //holds the user input of another game or not
      char answer;         //gets char of the input
      boolean newRound;    //true makes flip for new round
      
      
      
      //deck created and shuffled for player 1
      Deck deck1 = new Deck();
      deck1.shuffle();
      
      //deck created and shuffled for player 2
      Deck deck2 = new Deck();
      deck2.shuffle();
      
      //get the players names
      System.out.print("Player one name: ");
      Scanner keyboard = new Scanner(System.in);
      String play1 = keyboard.nextLine();
      System.out.print("Player two name: ");
      String play2 = keyboard.nextLine();
      //Create players
      Player player1 = new Player(play1);
      Player player2 = new Player(play2);
      
            
      do
      {
      //flip a card from both players
      flip1 = deck1.dealCard();
      flip2 = deck2.dealCard();
      
      //Display the cards flipped
      System.out.println(player1.getName() + " Card: " + flip1.toString());
      System.out.println(player2.getName() + " Card: " + flip2.toString());
            
      
////////////////////////////////////////////////////////////      
      
      if(!flip1.equals(flip2))
      {
         //compare the cards and determine who won the game
         win = Deck.highCard(flip1, flip2);
      
         //Depending on who won add the points to the players points
         if(win == flip1)
         {
            System.out.println(player1.getName() + " won the round");
            //add both of the flipped cards to player1 for winning
            deck1.add(flip1);
            deck1.add(flip2);
            System.out.println(player1.getName() + ": " + deck1.cardsRemaining());
         }   
         
         else if(win == flip2)
         {
            System.out.println(player2.getName() + " won the round");
            //add both cards to second player since they won
            deck2.add(flip1);
            deck2.add(flip2);
            System.out.println(player2.getName() + ": " + deck2.cardsRemaining());
         }
         
      }
/////////////////////////////////////////////////////////////////      
      
      //if there is a tie then one more card 
      //will be turned over to decide winner of war
      if(flip1.equals(flip2))
      {
         //Its WAR
         System.out.println("WAR!");
         //Another card needs to be flipped for each player. One facedown and then
         System.out.println("FaceDownCardsPlaced");
         down1 = deck1.dealCard();
         down2 = deck2.dealCard();
         up1 = deck1.dealCard();
         up2 = deck2.dealCard();
         
         //Show the next two cards faceup
         System.out.println(up1.toString());
         System.out.println(up2.toString());
         
         //compare the cards and determine who won the game
         win = Deck.highCard(up1, up2);
         
         //Depending on who won add the points to the players points
         if(win == up1)
         {
            System.out.println(player1.getName() + " won the round");
            //add all of the cards to player1 for winning
            deck1.add(flip1);
            deck1.add(flip2);
            deck1.add(down1);
            deck1.add(down2);
            deck1.add(up1);
            deck1.add(up2);
            System.out.println(player1.getName() + ": " + deck1.cardsRemaining());
         }   
         
         else
         {
            System.out.println(player2.getName() + " won the round");
            //add all of the cards to second player since they won
            deck2.add(flip1);
            deck2.add(flip2);
            deck2.add(down1);
            deck2.add(down2);
            deck2.add(up1);
            deck2.add(up2);
            System.out.println(player2.getName() + ": " + deck2.cardsRemaining());
         }
      }
      
      
///////////////////////////////////////////////////////////      
      
      //Ask the users if they're redy to flip for a new round.
      System.out.print("Flip cards for the next round? (y/n) ");
      input = keyboard.nextLine();
      answer = input.charAt(0);
      while(answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n')
      {
         System.out.print("Invalid Input\n");
         System.out.print("Flip cards for the next round? (y/n) ");
         input = keyboard.nextLine();
         answer = input.charAt(0);
      } 
      if(answer == 'Y' || answer == 'y')
         newRound = true;
      else
         newRound = false;
      
      }  //continue to do while more cards to play
      while(newRound && !deck1.isEmpty() && !deck2.isEmpty());
       
///////////////////////////////////////////////////////////////      
      
      //If someone runs out then that  player loses and other player wins
      if(deck1.isEmpty())
      {
         System.out.println(player1.getName() + " ran out of cards. " +
                            player2.getName() + " Wins!");
      }
      
      else if(deck2.isEmpty())
      {
         System.out.println(player2.getName() + " ran out of cards. " +
                            player1.getName() + " Wins!");
      }
      
      else
      {
         int indeck1 = deck1.cardsRemaining();
         int indeck2 = deck2.cardsRemaining();
      
         if(indeck1 > indeck2)
         {
            System.out.println(player1.getName() + " Wins!");
            System.out.println(deck1.cardsRemaining());
         }
         else if(indeck1 < indeck2)
         {
            System.out.println(player2.getName() + " Wins!");    
            System.out.println(deck2.cardsRemaining());
         }
         else
         {
            System.out.println("Game is a tie");
         }  
      }
   }
}