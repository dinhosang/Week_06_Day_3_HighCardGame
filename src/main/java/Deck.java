import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        createDeck();
    }

    private void createDeck() {
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        int indexSuit;
        int indexRank;
        for (indexSuit = 0; indexSuit < suits.length; indexSuit += 1) {
            for (indexRank = 0; indexRank < ranks.length; indexRank += 1) {
                Card card = new Card(suits[indexSuit], ranks[indexRank]);
                cards.add(card);
            }

        }
    }


    public int getSize() {
        return this.cards.size();
    }

    public Card findSpecificCard(int index) {
        return cards.get(index);
    }


    public void randomOrder() {
        Collections.shuffle(this.cards);
    }

    public Card removeCard() {
        return this.cards.remove(0);

    }

    public void resetDeck() {
        cards.removeAll(cards);
        createDeck();
    }
}
