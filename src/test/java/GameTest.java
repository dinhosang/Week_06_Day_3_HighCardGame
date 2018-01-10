import org.junit.Before;
import org.junit.Test;

public class GameTest {

    Game game;
    Dealer dealer;
    Player player1;
    Player player2;
    Deck deck;

    @Before
    public void before(){
        game = new Game();
        dealer = new Dealer();
        player1 = new Player();
        player2 = new Player();
        deck = new Deck();

        dealer.shuffleDeck(deck);
        dealer.dealCard(deck, player1);
        dealer.dealCard(deck, player2);
    }

    @Test
    public void decideWinner(){
    }
}
