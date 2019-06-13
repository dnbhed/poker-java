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
        dealer.addPlayer(player);
        card = new Card(SuitType.HEARTS, RankType.QUEEN);

    }

    @Test
    public void dealerHasEmptyHandBeforeHeDealsTheCards(){
        assertEquals(0, dealer.getNumOfCards());
    }

    @Test
    public void canAddPlayer(){
        assertEquals(1, dealer.getNumOfPlayers());
    }

    @Test
    public void canDealHandToPlayer(){
        deck.populate();
        dealer.dealCards(deck);
        assertEquals(1, player.getNumOfCards());
    }

    @Test
    public void canDealHandToSelf(){
        deck.populate();
        dealer.dealCards(deck);
        assertEquals(1, dealer.getNumOfCards());
    }

    @Test
    public void firstCardToPlayer(){
        deck.populate();
        dealer.dealCards(deck);
        System.out.println(deck.getFirstCard().getRank());
        assertEquals(card.getRank(), deck.getFirstCard().getRank());
        assertEquals(card.getSuit(), deck.getFirstCard().getSuit());
    }

    @Test
    public void dealerCanCheckValueOfCard(){
        deck.populate();
        dealer.dealCards(deck);
        assertEquals(10, dealer.checkCardValue());
    }

    @Test
    public void dealerCanCheckWhoWins(){
        deck.populate();
        dealer.addPlayer(player);
        dealer.dealCards(deck);
        System.out.println(dealer.checkCardValue());
        System.out.println(player.checkCardValue());
        assertEquals("Ben", dealer.checkWhoWins());
    }

}
