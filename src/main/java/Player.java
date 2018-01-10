import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }


    public int getNumberOfCards() {
        return hand.size();
    }

    public void takeCard(Card card) {
        hand.add(card);
    }
}
