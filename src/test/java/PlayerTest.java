import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.debugger.cdbg.Sym;

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
        player.getCard(card);
        assertEquals(1, player.getNumOfCards());
    }

    @Test
    public void playerCanCheckCardValue(){
        player.getCard(card);
        assertEquals(2, player.checkCardValue());
    }

    @Test
    public void playerCanShowHand(){
        player.getCard(card);
        assertEquals(card, player.showHand().get(0));
    }


}
