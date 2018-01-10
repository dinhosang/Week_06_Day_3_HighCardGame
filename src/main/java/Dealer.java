public class Dealer {


    public void dealCard(Deck deck, Player player) {
        Card card = deck.removeCard();
        player.takeCard(card);
    }

    public void shuffleDeck(Deck deck) {
        deck.randomOrder();
    }

    public void dealMultipleCards(Deck deck, Player player, int numberOfCards) {
        for (int cardsDealt = 0; cardsDealt < numberOfCards; cardsDealt +=1){
            Card card = deck.removeCard();
            player.takeCard(card);
        }

    }
}
