import java.util.HashMap;

public class Adjudicator {

    public HashMap<Player,GameResultType> decideResult(Player player1, Player player2) {
        HashMap<Player, GameResultType> outcome;
        outcome = new HashMap<>();
        if (player1.getHandValue() == player2.getHandValue()){
            outcome.put(player1, GameResultType.DRAW);
            outcome.put(player2, GameResultType.DRAW);
        } else if (player1.getHandValue() > player2.getHandValue()){
            outcome.put(player1, GameResultType.WIN);
            outcome.put(player2, GameResultType.LOSE);
        } else {
            outcome.put(player1, GameResultType.LOSE);
            outcome.put(player2, GameResultType.WIN);
        }

        return outcome;
    }


}
