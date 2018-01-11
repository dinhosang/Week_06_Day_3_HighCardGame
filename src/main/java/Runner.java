import com.sun.xml.internal.xsom.impl.Ref;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Game game;
        Boolean newPlayer;
        Boolean newOpponent;

        while (true) {
            TerminalHelper.flushMacScreen();
            game = new Game();
            newPlayer = false;
            game.setupPlayer();
            TerminalHelper.flushMacScreen();
            while(!newPlayer) {
                newOpponent = false;
                game.setupOpponent();
                TerminalHelper.flushMacScreen();
                game.welcomeAndSetupReport();
                TerminalHelper.flushMacScreen();
                while(!newOpponent) {
                    game.PlayersReceiveCards(2);
                    game.PlayersReviewCards();
                    TerminalHelper.flushMacScreen();
                    game.determineWinner();
                    System.out.println("\n");
                    game.resetGame();
                    game.playAgainQuery();
                    newPlayer = game.checkIfNewPlayerDesired();
                    if(newPlayer) {
                        newOpponent = true;
                    } else {
                        newOpponent = game.checkIfNewOpponentDesired();
                    }
                    TerminalHelper.flushMacScreen();
                }
            }
        }
    }
}
