import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {


    Deck deck;
    Player player1;
    Player player2;


    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
    }

    @Test
    public void deckHas52Cards(){
        assertEquals(52, deck.getSize());
    }

    @Test
    public void lastCardInDeckIsKingOfDiamonds() {
        Card card = deck.getCards(51);
        assertEquals(Suit.DIAMONDS, card.getSuit());
        assertEquals(Rank.KING, card.getRank());
    }

    @Test
    public void canDealDifferentCardsToPlayers(){
        assertEquals(0, player1.getNumberOfCards());
        deck.dealCards(player1);
        assertEquals(1, player1.getNumberOfCards());
        assertEquals(51, deck.getSize());
    }

}
