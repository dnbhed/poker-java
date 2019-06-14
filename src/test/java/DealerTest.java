import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Dealer dealer;
    Player player;
    Deck deck;
    Card card;

    @Before
    public void before(){
        dealer = new Dealer("Ben");
        player = new Player("Gazza");
        deck = new Deck();
        card = new Card(SuitType.HEARTS, RankType.KING);

    }

    @Test
    public void canAddPlayer(){
        dealer.addPlayer(player);
        assertEquals(1, dealer.getNumOfPlayers());
    }

    @Test
    public void canDealHandToPlayer(){
        deck.populate();
        dealer.addPlayer(player);
        dealer.dealCards(deck, 1);
        assertEquals(1, player.getNumOfCards());
    }

    @Test
    public void cardToPlayer(){
        deck.populate();
        dealer.addPlayer(player);
        dealer.dealCards(deck, 1);
        assertEquals(51, deck.getNumOfCards());

    }

    @Test
    public void cardsToPlayers(){
        deck.populate();
        dealer.addPlayer(player);
        dealer.addPlayer(player);
        dealer.dealCards(deck, 1);
        assertEquals(50, deck.getNumOfCards());
    }



//    @Test
//    public void dealerCanCheckWhoWins(){
//        deck.populate();
//        dealer.addPlayer(player);
//        dealer.dealCards(deck);
//        System.out.println(dealer.checkCardValue());
//        System.out.println(player.checkCardValue());
//        assertEquals("Ben", dealer.checkWhoWins());
//    }

}
