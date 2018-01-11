import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {


    Deck deck;
    Player player;
    Dealer dealer;


    @Before
    public void before(){
        deck = new Deck();
        player = new Player("Colin");
        dealer = new Dealer("Joker");
    }

    @Test
    public void deckHas52Cards(){
        assertEquals(52, deck.getSize());
    }

    @Test
    public void lastCardInDeckIsKingOfDiamonds() {
        Card card = deck.findSpecificCard(51);
        assertEquals(Suit.DIAMONDS, card.getSuit());
        assertEquals(Rank.KING, card.getRank());
    }

    @Test
    public void deckCanReset(){
        dealer.dealMultipleCards(this.deck, this.player, 3);
        assertEquals(49, deck.getSize());
        deck.resetDeck();
        assertEquals(52, deck.getSize());
    }


}
