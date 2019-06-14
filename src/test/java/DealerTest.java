import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DealerTest {

    Dealer dealer;
    Player player1;
    Player player2;
    Deck deck;
    Card card;

    @Before
    public void before(){
        dealer = new Dealer("Ben");
        player1 = new Player("Gazza");
        player2 = new Player("Jim");
        deck = new Deck();
        card = new Card(SuitType.HEARTS, RankType.KING);

    }

    @Test
    public void canAddPlayer(){
        dealer.addPlayer(player1);
        assertEquals(1, dealer.getNumOfPlayers());
    }

    @Test
    public void canDealHandToPlayer(){
        deck.populate();
        dealer.addPlayer(player1);
        dealer.dealCards(deck, 1);
        assertEquals(1, player1.getNumOfCards());
    }

    @Test
    public void cardToPlayer(){
        deck.populate();
        dealer.addPlayer(player1);
        dealer.dealCards(deck, 1);
        assertEquals(51, deck.getNumOfCards());

    }

    @Test
    public void cardsToPlayers(){
        deck.populate();
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        dealer.dealCards(deck, 1);
        assertEquals(50, deck.getNumOfCards());
    }



    @Test
    public void dealerCanCheckWhoWins(){
        deck.populate();
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        dealer.dealCards(deck, 5);
        assertNotEquals(null, dealer.checkWhoWins());
    }

}
