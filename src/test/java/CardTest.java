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

//    @Test
//    public void canGetAllSuits(){
//        // Suit[] is saying a primitive array of suits
//        // Suit.values() is a default method for return primitive array of
//        // the suits in the Suit enum
//        Suit[] suits = Suit.values();
//        // for some reason curly braces are used to represent literal arrays, but we declare
//        // using [], literal arrays as in literally displaying an array
//        // for example a variable of type string is not a literal but “rosie” is
//        Suit[] expected = {Suit.SPADES, Suit.HEARTS, Suit.CLUBS, Suit.DIAMONDS};
//        assertEquals(4, suits.length);
//        assertArrayEquals(expected, suits);
//        Rank[] ranks = Rank.values();
//        System.out.println(ranks[0]);
//        System.out.println(suits);
//    }

}