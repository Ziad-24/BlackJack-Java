package blackjack;

public class Player {
    private String name;
    public int score;
    public Card [] cards = new Card[11];
    private boolean blackjack;
    private boolean loss;

    public Player(String name, int score, Card[] cards) {
        this.name = name;
        this.score = score;
        this.cards = cards;
        this.blackjack = false;
        this.loss = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public boolean isLoss(boolean b) {
        return loss;
    }

    public void setLoss(boolean loss) {
        this.loss = loss;
    }
}
