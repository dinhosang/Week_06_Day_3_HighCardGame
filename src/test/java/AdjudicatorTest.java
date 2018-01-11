import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class AdjudicatorTest {


//    Dealer dealer;
//    Deck deck;
    Adjudicator adjudicator;
    Player player1;
    Player player2;
    Card card1;
    Card card2;
    Card card3;


    @Before
    public void before(){
        adjudicator = new Adjudicator();
        player1 = new Player("Craig");
        player2 = new Player("Alex");
        card1 = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.FOUR);
        card3 = new Card(Suit.HEARTS, Rank.THREE);
        player1.takeCard(card1);
        player2.takeCard(card2);
    }

    @Test
    public void checkPlayer1Loses(){
        String results = adjudicator.decideResult(player1, player2);
        assertEquals("You lost the game!", results);
    }

    @Test
    public void checkGameIsADraw(){
        player1.takeCard(card3);
        String results = adjudicator.decideResult(player1, player2);
        assertEquals("The game is a draw!", results);
    }
}
