/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.*;

public class BlackJack {
    static Game game = new Game();
    //GUI gui = new GUI();

    public static void main(String[] args) {

        GUI gui = new GUI();
        game.generateDeck();
        game.setPlayers();
        gui.runGUI(game.deck,
                game.players[0].cards,
                game.players[1].cards,
                game.players[2].cards,
                game.players[3].cards);
        playersplay(gui);
        game.updatePlayersMaximumScore();
        dealerturn(gui);
    }

    public static void playersplay(GUI gui) {

        Scanner input = new Scanner(System.in);
        // hit 1, stand 0

        for (int i = 0; i < 3; i++) {
            int numofcard = 2;
            while (true)
            {
                System.out.println("player" + (i + 1) + "{hit / stand}");
                int choice = input.nextInt();
                if (choice == 1)
                {
                    game.players[i].cards[numofcard] = game.draw();
                    game.players[i].score += game.players[i].cards[numofcard].getValue();
                    gui.updatePlayerHand(game.players[i].cards[numofcard], i);
                    numofcard++;
                    System.out.println("Player name : "+game.players[i].getName() +" and the score is "+ game.players[i].score);

                    if (game.players[i].score < 21)
                    {
                        continue;
                    }
                    else if (game.players[i].score == 21)
                    {
                        System.out.println(game.players[i].getName() + " is blackjack");
                        break;
                    }
                    else if (game.players[i].score > 21) {

                        System.out.println(game.players[i].getName() + " is lost");
                        break;
                    }
                    //
                }
                if (choice == 2)
                {
                    break;
                }
            }

        }
    }

    public static void dealerturn(GUI gui) {
        System.out.println("It's " + game.players[3].getName() + " turn to play , your current score is " + game.players[3].score);
        int cardindex = 2;
        while (true) {
            //check conditions
            //win
            if (game.players[0].score > 21 && game.players[1].score > 21 && game.players[2].score > 21) {
                game.highscore = game.players[3].score;
                game.checkTheWinner();
                //winner function
                break;
            }
            else if ((game.players[3].score < 21 && game.players[3].score > game.highscore) || game.players[3].score == 21) {
                game.checkTheWinner();
                //winner function
                break;
            }
            //
            //loop again
            else if (game.players[3].score < 21 && game.players[3].score <= game.highscore)
            {
                if (cardindex == 2)
                {
                    gui.updateDealerHand(game.players[3].cards[1], game.deck);
                }
                game.players[3].cards[cardindex] = game.draw();
                game.players[3].score += game.players[3].cards[cardindex].getValue();
                System.out.println(game.players[3].getName() + " New Score is " + game.players[3].score);
                //Update the GUI for the dealer
                gui.updateDealerHand(game.players[3].cards[cardindex], game.deck);

                if (game.players[3].score > 21)
                {
                    System.out.println(game.players[3].getName() + " Lost");
                     game.checkTheWinner();
                    //winner function
                    break;
                }
                cardindex++;
                continue;
            }
        }
    }

}
   


   
    