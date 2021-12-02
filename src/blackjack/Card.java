/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

public class Card {
    
    final private int suit;
      final private int rank;
      final private int value;
          
      
       //con
       public Card(int suit, int rank, int value){
        this.suit = suit;
        this.rank = rank;
        this.value = value;
       }

    //getter

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
       
        public Card (Card cards) {
        this.suit = cards.suit;
        this.rank = cards.rank;
        this.value = cards.value;
    }

    }




