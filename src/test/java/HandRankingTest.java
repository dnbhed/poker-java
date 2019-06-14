import org.junit.Before;

public class HandRankingTest {

    HandRanking handRanking;
    Player player;
    Dealer dealer;

    @Before
    public void before(){
        handRanking = new HandRanking();
        player = new Player("Gary");
        dealer = new Dealer("Jim");
    }


}
