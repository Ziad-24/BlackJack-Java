package blackjack;

public class Card {

    private int suit;
    private int rank;
    private int value;

    public Card(int suit, int rank, int value)
    {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    public Card(Card c)
    {
        this.suit = c.suit;
        this.rank = c.rank;
        this.value = c.value;
    }
    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                ", value=" + value +
                '}';
    }
}
