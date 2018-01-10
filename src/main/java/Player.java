import java.lang.reflect.Array;
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

    public int getHandValue() {
        int totalHandValue = 0;
        // below is the foreach style of for loop, to show the difference from the standard style of for loop
        // shown in the deck class file under the createDeck() method.
        for(Card card: this.hand){
            int valueOfCard = card.getRank().getValue();
            totalHandValue += valueOfCard;
        }
        return totalHandValue;
    }



}
