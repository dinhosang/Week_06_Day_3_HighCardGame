import java.util.Collection;
import java.util.HashMap;

public class Adjudicator {

    public String decideResult(Player playerHuman, Player playerComputer) {

        String resultString;
        int playerHumanHandValue = playerHuman.getHandValue();
        int playerComputerHandValue = playerComputer.getHandValue();
        if (playerHumanHandValue == playerComputerHandValue) {
            resultString = "The game is a draw!";
        } else if (playerHumanHandValue > playerComputerHandValue) {
            resultString = "You won the game!";
        } else {
            resultString = "You lost the game!";
        }
        return resultString;
    }

}
