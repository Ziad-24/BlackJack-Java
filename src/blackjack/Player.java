/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package blackjack;

public class Player {
   private String name;
   public int score;
   public Card [] cards = new Card[11];

   public void setName(String name) {
        this.name = name;
    }
   
    public void setScore(int score)
    {
        this.score = score;
    }

    public String getName()
    {
        return name;
    }
    public int getScore() 
    {
        return score;
    }

    public Player(String name, int score , Card[] cards) {
        this.name = name;
        this.score = score;
        this.cards = cards;
    }

}
