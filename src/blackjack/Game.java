/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public Player []players = new Player[4];
    public Card[] deck = new Card[52];
    public int highscore=0;
   
   
    public void generateDeck() {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 13; j++)
            {
                int value = j + 1;
                if (value > 10) {
                    value = 10;
                }
                
               deck[j+(i*13)] = new Card(i, j, value);
           
            }
        } 
}
  
    public Card draw() {
        Random rand= new Random();
       
        while(true)
        {
             int randomindex = rand.nextInt(52);
             if(deck[randomindex]==null)
             {
                 //card is already drawn
                 continue;
             }
             else if(deck[randomindex]!=null)
             {
                 Card newcard = new Card(deck[randomindex]);
                 deck[randomindex] = null;
                 return newcard;
             }
           
        }
    }
    
     public void setPlayers()
     {
         for(int i = 0 ; i < 4 ; i++)
         {
             Scanner input = new Scanner(System.in);
             String name;
             if(i<3)
             {
                 System.out.println("Enter a name for player " + (i+1));
                 name = input.next();
             }
             else
             {
                 name = "Dealer";
             }
             Card[] cardcopy = new Card[11];
             int score=0;
             for(int j = 0 ; j < 2 ; j++)
             {
                 cardcopy[j] = new Card(draw());
                 score += cardcopy[j].getValue();
             }
             players[i] = new Player(name , score , cardcopy);
         }
    }
     
     public void updatePlayersMaximumScore() 
     {
        for(int i = 0 ; i < 4 ; i++)
        {
            if(players[i].getScore() >  highscore && players[i].getScore()<=21)
            {
                highscore = players[i].getScore();
            }

        }
        System.out.println("The max score is " + highscore);
    }
  
    public void TopScorerName()
    {

        System.out.println("-------------------------------------------");
        String winner = "";

        for(int i = 0; i < players.length; i++){
            if(players[i].getScore() == highscore && winner.equals("")){
                winner = players[i].getName();
            }
            else if (players[i].getScore() == highscore && !winner.equals("")){
                System.out.println("It is a tie. No winner");
                return;
            }
        }
    }


    public void checkTheWinner()
    {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("The final results are ");
        int counter = 0;
        int index =0;
        for (int i = 0 ; i  < 4 ; i++)
        {
            System.out.println("Player name : " + this.players[i].getName() + " With the score of : " + this.players[i].score);
            if(this.players[i].score == this.highscore)
            {
                counter++;
                index = i;
            }
        }
        if(this.players[0].score>21 && this.players[1].score>21 && this.players[2].score >21)
        {
            System.out.println("The winner is Dealer");
        }
        else if(counter==1)
        {
            System.out.println("The winner is " + players[index].getName());
        }
        else
        {
            System.out.println("It's a PUSH");
        }
    }
}

   
  

     

        