import java.util.ArrayList;

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
}
