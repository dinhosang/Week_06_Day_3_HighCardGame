import java.util.HashMap;

public class Game {

    HashMap<Player, String> outcome;

    public Game(){
        outcome = new HashMap<>();
    }

    public HashMap<Player,String> decideResult(Player player1, Player player2) {

        if (player1.getHandValue() == player2.getHandValue()){
            this.outcome.put(player1, "Draw");
            this.outcome.put(player2, "Draw");
        } else if (player1.getHandValue() > player2.getHandValue()){
            this.outcome.put(player1, "Win");
            this.outcome.put(player2, "Lose");
        } else {
            this.outcome.put(player1, "Lose");
            this.outcome.put(player2, "Win");
        }

        return outcome;
    }


}
