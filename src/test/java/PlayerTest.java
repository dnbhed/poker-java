import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Card card;

    @Before
    public void before(){
        player = new Player("Gary");
        card = new Card(SuitType.HEARTS, RankType.TWO);
    }

    @Test
    public void playerHasName(){
        assertEquals("Gary", player.getName());
    }

    @Test
    public void playerHasAnEmptyHand(){
        assertEquals(0, player.getNumOfCards());
    }

    @Test
    public void playerCanRequestCard(){
        player.requestCard(card);
        assertEquals(1, player.getNumOfCards());
    }

    @Test
    public void playerCanCheckCardValue(){
        player.requestCard(card);
        assertEquals(2, player.checkCardValue());
    }

}
