import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.xsom.impl.Ref;

import java.io.Console;
import java.io.IOException;
import java.util.*;

import static jdk.nashorn.internal.parser.TokenType.OR;

public class Game {


    private Player playerHuman;
    private Player playerComputer;
    private Dealer dealer;
    private ArrayList<String> dealerNames;
    private Deck deck;
    private ArrayList<String> computerOpponents;
    private Adjudicator adjudicator;


    public Game(){
        this.deck = new Deck();

        this.dealerNames = new ArrayList<>();
        dealerNames.addAll(Arrays.asList("Hong", "Joker", "Dijkstra", "Gaunter"));
        Collections.shuffle(dealerNames);

        this.dealer = new Dealer(dealerNames.get(0));

        computerOpponents = new ArrayList<>();
        computerOpponents.addAll(Arrays.asList("alex", "colin", "craig", "zsolt", "john"));
        adjudicator = new Adjudicator();
    }

    public void setupPlayer() {
        Boolean acceptedResponse = false;
        while(!acceptedResponse) {
            System.out.println("Type 'quit' and then press ENTER at any time to leave the game.\n");
            System.out.print("Please enter your name: ");
            String playerName = TerminalHelper.getInput();
            if (!playerName.isEmpty()) {
                    if (Character.isLetter(playerName.charAt(0))) {
                        int lengthPlayerName = playerName.length();
                        String playerNameCapitalised = playerName.substring(0, 1).toUpperCase() + playerName.substring(1, lengthPlayerName);
                        playerHuman = new Player(playerNameCapitalised);
                        acceptedResponse = true;
                    } else {
                        playerHuman = new Player(playerName);
                        acceptedResponse = true;
                    }
                } else {
                TerminalHelper.flushMacScreen();
                System.out.println("Please enter a name.\n\n");
            }
        }
    }

    public void setupOpponent() {
       System.out.println("Who would you like as your opponent?");

       while (true) {
           System.out.print("Alex, Colin, Craig, Zsolt, or John: ");
           String opponentName = TerminalHelper.getInput();

           if(computerOpponents.contains(opponentName)){
               int lengthOpponentName = opponentName.length();
               String opponentNameCapitalised = opponentName.substring(0,1).toUpperCase() + opponentName.substring(1, lengthOpponentName);
               playerComputer = new Player(opponentNameCapitalised);
               break;
           } else {
               TerminalHelper.flushMacScreen();
               System.out.println("Please choose one of the names from the list:" + "\n");
           }
       }
   }


    public void welcomeAndSetupReport() {
        System.out.println(String.format("Welcome, %s, to 'Highest Value Hand of Cards Wins' - the game.\n", playerHuman.getName()));
        System.out.println(String.format("Your opponent will be %s, and Dealer %s has been assigned as your dealer for this game.\n\n",  playerComputer.getName(), dealer.getName()));
        System.out.println("Press ENTER to begin.\nOr, type 'quit' and then press enter to leave the game.");
        TerminalHelper.getInput();
    }


    public void PlayersReceiveCards(int numberOfCards) {
        dealer.shuffleDeck(this.deck);
        dealer.dealMultipleCards(this.deck, this.playerHuman, numberOfCards);
        dealer.dealMultipleCards(this.deck, this.playerComputer, numberOfCards);
    }

    public void PlayersReviewCards() {
        System.out.println(String.format("Dealer %s deals you and %s two cards each.", this.dealer.getName(), this.playerComputer.getName()));
        showPlayerTheirHand();
        Boolean determineWinner = false;
        while(!determineWinner){
            String response = TerminalHelper.getInput();
            if(response.contains("continue")) {
                determineWinner = true;
            } else if(response.contains("hand")){
                TerminalHelper.flushMacScreen();
                showPlayerTheirHand();
            } else {
                TerminalHelper.flushMacScreen();
                System.out.println("Please only enter 'continue' to determine a winner, 'hand' to view your hand again, or 'quit' to leave the game.");
            }
        }
    }

    public void showPlayerTheirHand(){
        System.out.println(this.playerHuman.getHand());
        System.out.println("\n");
        System.out.println("If you wish to view your hand again please type 'hand'.\nIf you are ready to determine a winner, please type 'continue'.");
    }


    public void determineWinner() {
        String resultString;
        HashMap<Player, GameResultType> adjudicationResultHash;

        int playerHumanHandValue = this.playerHuman.getHandValue();
        int playerComputerHandValue = this.playerComputer.getHandValue();
        String opponentName = this.playerComputer.getName();

        System.out.println(String.format("Your hand has a value of %d, %s's hand has a value of %d.\n", playerHumanHandValue, opponentName, playerComputerHandValue));

        adjudicationResultHash = adjudicator.decideResult(this.playerHuman, this.playerComputer);
        GameResultType playerHumanResult = adjudicationResultHash.get(this.playerHuman);

        if (playerHumanResult.equals(GameResultType.DRAW)){
            resultString = "The game is a draw!";
        } else if (playerHumanResult.equals(GameResultType.WIN)) {
            resultString = "You won the game!";
        } else {
            resultString = String.format("You lost the game, %s had a better hand.", opponentName);
        }

        System.out.println(resultString);
    }

    public void playAgainQuery() {
        String response;
        while(true) {
            System.out.print("Start another game?\n(Y)es/(N)o: ");
            response = TerminalHelper.getInput();
            if(response.contains("n") || response.contains("no")){
                TerminalHelper.flushMacScreen();
                System.exit(0);
            } else if (response.contains("y") || response.contains("yes")){
                break;
            } else {
                TerminalHelper.flushMacScreen();
                System.out.println("Please enter only yes, no, or quit.\n\n");
            }
        }
    }


    public Boolean checkIfNewPlayerDesired() {
        String response;
        Boolean newPlayer = false;
        Boolean acceptedResponse = false;
        while(!acceptedResponse) {
            System.out.print("New player?\n(Y)es/(N)o: ");
            response = TerminalHelper.getInput();
            if(response.contains("n") || response.contains("no")){
                newPlayer = false;
                acceptedResponse = true;
            } else if (response.contains("y") || response.contains("yes")){
                newPlayer = true;
                acceptedResponse = true;
            } else {
                TerminalHelper.flushMacScreen();
                System.out.println("Please enter only yes, no, or quit.\n\n");
            }
        }
        return newPlayer;
    }


    public Boolean checkIfNewOpponentDesired() {
        String response;
        Boolean newOpponent = false;
        Boolean acceptedResponse = false;
        while(!acceptedResponse) {
            System.out.print("Choose new opponent?\n(Y)es/(N)o: ");
            response = TerminalHelper.getInput();
            if(response.contains("n") || response.contains("no")){
                newOpponent = false;
                acceptedResponse = true;
            } else if (response.contains("y") || response.contains("yes")){
                newOpponent = true;
                acceptedResponse = true;
            } else {
                TerminalHelper.flushMacScreen();
                System.out.println("Please enter only yes, no, or quit.\n\n");
            }
        }
        return newOpponent;
    }

    public void resetGame() {
        this.playerHuman.clearHand();
        this.playerComputer.clearHand();
        this.deck.resetDeck();
    }
}
