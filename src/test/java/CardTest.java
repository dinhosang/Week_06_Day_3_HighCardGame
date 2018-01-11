import static org.junit.Assert.*;
import org.junit.*;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(Suit.HEARTS, Rank.KING);
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.HEARTS,card.getSuit());
    }

    @Test
    public void canGetRank() { assertEquals(Rank.KING, card.getRank());}

    @Test
    public void jackValueIs11() {
        card = new Card(Suit.CLUBS, Rank.JACK);
        int value = card.getRank().getValue();
        assertEquals(11, value);
    }

    @Test
    public void getRankAsString(){
        assertEquals("King", card.getRankString());
    }
    @Test
    public void getSuitAsString(){
        assertEquals("Hearts", card.getSuitString());
    }

}