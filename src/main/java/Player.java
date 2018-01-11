import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;
    private String name;

    public Player(String name) {
        hand = new ArrayList<>();
        this.name = name;
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


    public String getName() {
        String copyName = this.name;
        return copyName;
    }

    public String getHand() {
        String handDetails = "Your Hand consists of the:";
        if (hand.size() == 1) {
            Card card = hand.get(0);
            handDetails += String.format(" %s of %s.", card.getRankString(), card.getSuitString());
        } else {
            for(int cardIndexNumber = 0; cardIndexNumber < hand.size(); cardIndexNumber += 1){
                Card card = hand.get(cardIndexNumber);
                if(cardIndexNumber != hand.size()-1){
                    handDetails += String.format(" %s of %s,", card.getRankString(), card.getSuitString());
                } else {
                    handDetails += String.format(" %s of %s.", card.getRankString(), card.getSuitString());
                }
            }
        }
        handDetails += String.format("\nYour total hand value is %d.", getHandValue());
        return handDetails;
    }

    public void clearHand() {
        this.hand.removeAll(hand);
    }
}
