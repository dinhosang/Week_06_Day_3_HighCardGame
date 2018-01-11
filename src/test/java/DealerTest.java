import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Dealer dealer;
    Player player1;
    Player player2;
    Deck deck;

    @Before
    public void before(){
        dealer = new Dealer("The dealer");
        player1 = new Player("Zsolt");
        player2 = new Player("John");
        deck = new Deck();
        dealer.shuffleDeck(deck);
    }

    @Test
    public void canDealDifferentCardsToPlayers(){
        assertEquals(0, player1.getNumberOfCards());
        dealer.dealCard(deck, player1);
        assertEquals(1, player1.getNumberOfCards());
        assertEquals(51, deck.getSize());
        System.out.println(deck.findSpecificCard(0).getRank());
    }

    @Test
    public void canDealMultipleCards(){
        dealer.dealMultipleCards(deck, player1, 2);
        assertEquals(2, player1.getNumberOfCards());
        assertEquals(50, deck.getSize());

    }

    @Test
    public void canGetDealerName(){
        assertEquals("The dealer", dealer.getName());
    }

}
