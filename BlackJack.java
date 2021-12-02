package blackjack;
import java.util.*;
public class BlackJack {

     static Game game = new Game();
    public static void main(String [] Args)
    {
        GUI gui = new GUI();

        game.startTheGame();
        gui.runGUI( game.gameCards, game.players[0].cards, game.players[1].cards, game.players[2].cards, game.players[3].cards );
        //-------------------------------------------------------------------------------------------
            Scanner in = new Scanner(System.in);
            //hit or stand for all players except dealer
        for(int i = 0 ; i < 3 ; i++)
        {
            System.out.println("It's " + game.players[i].getName()+" turn to play , your current score is " + game.players[i].score);
            int cardindex = 2;
            while(true)
            {
                System.out.println("Press 1 to hit\nPress 2 to Stand");
                int choice = in.nextInt();
                if(choice==1)
                {

                    //pull a card then show the new score and check his status
                    game.players[i].cards[cardindex] = game.pullCard();
                    game.players[i].score += game.players[i].cards[cardindex].getValue();
                    System.out.println(game.players[i].getName()+ " New Score is " + game.players[i].score);
//                    Check high score after each pull
                    game.checkHighScore();

                    //add to gui
                    gui.updatePlayerHand(game.players[i].cards[cardindex], i);
                    cardindex++;
                    if(game.players[i].score < 21)
                    {
                        continue;
                    }
                    else if(game.players[i].score == 21)
                    {
                        game.players[i].setBlackjack(true);
                        break;
                    }
                    else
                    {
                       game.players[i].setLoss(true);
                        System.out.println(game.players[i].getName() + " Busted");
                       break;
                    }
                }
                else if(choice==2)
                {
                    break;
                }
            }
        }

        //-------------------------------------------------------------------------------------------
        // Dealer's turn
        System.out.println("It's " + game.players[3].getName()+" turn to play , your current score is " + game.players[3].score);
        int cardindex = 2;
        while(true) {
            //check conditions
            //win
            if (game.players[0].score > 21 && game.players[1].score > 21 && game.players[2].score > 21) {
                game.setHighscore(game.players[3].score);
                game.checkTheWinner();
                break;
            } else if ((game.players[3].score < 21 && game.players[3].score > game.getHighscore()) || game.players[3].score == 21) {
                game.players[3].setBlackjack(true);
                game.checkTheWinner();
                break;
            }
            //loop again
            else if (game.players[3].score < 21 && game.players[3].score <= game.getHighscore()) {
                if (cardindex == 2) {
                    gui.updateDealerHand(game.players[3].cards[1], game.gameCards);
                }
                game.players[3].cards[cardindex] = game.pullCard();
                game.players[3].score += game.players[3].cards[cardindex].getValue();
                System.out.println(game.players[3].getName() + " New Score is " + game.players[3].score);
                //Update the GUI for the dealer
                gui.updateDealerHand(game.players[3].cards[cardindex], game.gameCards);
                if (game.players[3].score > 21) {
                    game.players[3].isLoss(true);
                    System.out.println(game.players[3].getName() + " Lost");
                    game.checkTheWinner();
                    break;
                }
                cardindex++;
                continue;
            }

            //lose
//            else
//            {
//                game.players[3].isLoss(true);
//                System.out.println(game.players[3].getName() + " Lost");
//                game.checkTheWinner();
//                break;
//            }

        }

        //-------------------------------------------------------------------------------------------

        //Finish the game and show the final results
        //game.checkTheWinner();

//
    }
}
