import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {

    Deck deck;
    Card card;

    @Before
    public void before(){
        deck = new Deck();
        card = new Card(SuitType.HEARTS, RankType.ACE);
    }

    @Test
    public void deckStartsEmpty(){
        assertEquals(0, deck.getNumOfCards());
    }

    @Test
    public void canPopulateDeck(){
        deck.populate();
        assertEquals(52, deck.getNumOfCards());
    }

    @Test
    public void firstCardBeforeShuffle(){
        deck.populate();
        assertEquals(card.getRank(), deck.getFirstCard().getRank());
        assertEquals(card.getSuit(), deck.getFirstCard().getSuit());
    }

    @Test
    public void canDealCard(){
        deck.populate();
        deck.shuffle();
        deck.deal();
        assertEquals(51, deck.getNumOfCards());
    }

    @Test
    public void canDealTwoCards(){
        deck.populate();
        deck.shuffle();
        deck.deal();
        deck.deal();
        assertEquals(50, deck.getNumOfCards());
    }
}
