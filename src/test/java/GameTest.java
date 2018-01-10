import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GameTest {


//    Dealer dealer;
//    Deck deck;
    Game game;
    Player player1;
    Player player2;
    Card card1;
    Card card2;
    Card card3;


    @Before
    public void before(){
        game = new Game();
        player1 = new Player();
        player2 = new Player();
        card1 = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.FOUR);
        card3 = new Card(Suit.HEARTS, Rank.THREE);
        player1.takeCard(card1);
        player2.takeCard(card2);
//        dealer = new Dealer();
//        deck = new Deck();
//        dealer.shuffleDeck(deck);
//        dealer.dealCard(deck, player1);
//        dealer.dealCard(deck, player2);
    }

    @Test
    public void checkPlayer2WinsPlayer1Loses(){
        HashMap<Player, String> results = game.decideResult(player1, player2);
        assertEquals("Lose", results.get(player1));
        assertEquals("Win", results.get(player2));


    }

    @Test
    public void checkGameIsADraw(){
        player1.takeCard(card3);
        HashMap<Player, String> results = game.decideResult(player1, player2);
        assertEquals("Draw", results.get(player1));
        assertEquals("Draw", results.get(player2));
    }
}
