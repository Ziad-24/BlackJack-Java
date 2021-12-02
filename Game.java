package blackjack;
import java.util.*;

public class Game {
    public Player [] players = new Player[4];
    public Card [] gameCards = new Card[52];

    private int highscore=0;
    private String topScorerName;

    public int getHighscore() {
        return highscore;
    }
    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
    public String getTopScorerName() {
        return topScorerName;
    }
    public void setTopScorerName(String topScorerName) {
        this.topScorerName = topScorerName;
    }
    public Card[] getGameCards() {
        return gameCards;
    }

    //The function that starts the game
    public void startTheGame()
    {
        this.generateCards();
    }

    public void generateCards()
    {
        //create a deck of card
        //loop for each card suit
        for(int i = 0 ; i < 4 ; i++)
        {
            //each suit has its own rank and value
            for(int j = 0 ; j < 13 ; j++)
            {
                //set rank
                //set suit
                //set value
                if(j<10)
                {
                    this.gameCards[j+(i*13)] = new Card(i,j,j+1);
                }
                //after the card 9 all value are equal 10 { 10 , J , Q , K }
                else
                {
                    this.gameCards[j+(i*13)] = new Card(i,j,10);
                }
                //System.out.println(this.gameCards[j+(i*13)].toString());
            }
        }
        //Call the next function automatically
        this.generatePlayers();
    }

    public Card pullCard()
    {
        Random rand = new Random();
        while(true)
        {
            int randomCard = rand.nextInt(52);
            if(this.gameCards[randomCard] != null)
            {
                
                Card pulledCard = new Card(this.gameCards[randomCard]);

                this.gameCards[randomCard] = null;
                return pulledCard;
            }
            else
            {
                System.out.println("Card already chosen , will choose again");
                continue;
            }
        }
    }


    public void generatePlayers()
    {
        Scanner in = new Scanner(System.in);
        //enter player names
        for(int i = 0 ; i < 4 ; i++)
        {
            String name;
            if(i<3)
            {
                System.out.println("Enter the name of the user number " + (i+1));
                 name = in.next();
            }
            else
            {
                name = "Dealer";
                System.out.println("The name is " + name);
            }
            //assign with constructor
            Card[] card = new Card[11];
            int score=0;

            for(int j = 0 ; j < 2 ; j++)
            {
                //two cards to initialize the player with and score 0
                card[j] = this.pullCard();
                //players[i].cards[i]=pullCard(game);
                score += card[j].getValue();
            }
            //constructor to assign values into the array
            this.players[i] = new Player(name,score,card);

            System.out.println(this.players[i].getName() + " has the score of " + this.players[i].score);
        }
    }

    public void checkHighScore()
    {
        for(int i = 0 ; i < 3 ; i++)
        {
            if((this.players[i].score >= this.getHighscore())&& this.players[i].score <= 21)
            {
                if(this.players[i].score == 21)
                {
                    this.players[i].setBlackjack(true);
                }
                this.setHighscore(this.players[i].score);
                this.setTopScorerName(this.players[i].getName());
            }
            else if(this.players[i].score > 21)
            {
                this.players[i].setLoss(true);
            }

        }
        System.out.println("The top scorer is " + this.getTopScorerName()+ " with the score of " + this.getHighscore());
    }

    public void checkTheWinner()
    {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("The final results are ");
        int counter = 0;
        for (int i = 0 ; i  < 4 ; i++)
        {
            System.out.println("Player name : " + this.players[i].getName() + " With the score of : " + this.players[i].score);
            if(this.players[i].score == this.getHighscore())
            {
                counter++;
            }
        }
        if(this.players[0].isLoss(true) && this.players[1].isLoss(true) && this.players[2].isLoss(true))
        {
            System.out.println("The winner is Dealer");
        }
        else if(counter==1)
        {
            System.out.println("The winner is " + this.getTopScorerName());
        }
        else
        {
            System.out.println("It's a PUSH");
        }
    }
}