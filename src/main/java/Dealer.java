public class Dealer {


    public void dealCard(Deck deck, Player player) {
        Card card = deck.removeCard();
        player.takeCard(card);
    }

    public void shuffleDeck(Deck deck) {
        deck.randomOrder();
    }
}
