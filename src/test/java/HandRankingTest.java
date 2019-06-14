import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HandRankingTest {

    HandRanking handRanking;
    Player player;
    Deck deck;
    Dealer dealer;
    Card two;
    Card three;
    Card four;
    Card five;

    @Before
    public void before(){
        player = new Player("Gary");
        dealer = new Dealer("Jim");
        deck = new Deck();
        dealer.addPlayer(player);
        deck.populate();
        two = new Card(SuitType.HEARTS, RankType.TWO);
        three = new Card(SuitType.HEARTS, RankType.THREE);
        four = new Card(SuitType.HEARTS, RankType.FOUR);
        five = new Card(SuitType.HEARTS, RankType.FIVE);
    }

    @Test
    public void canIdentifyFlush(){
        dealer.dealCards(deck, 5);
        player.orderHandByRank();
        ArrayList<Card> hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertEquals(HandRankType.FLUSH, handRanking.checkIsFlush());
    }

    @Test
    public void canIdentifyStraight(){
        dealer.dealCards(deck, 5);
        player.orderHandByRank();
        ArrayList<Card> hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertEquals(HandRankType.STRAIGHT, handRanking.checkIsStraight());
    }

    @Test
    public void canIdentifyStraightFlush(){
        dealer.dealCards(deck, 5);
        player.orderHandByRank();
        ArrayList<Card> hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertEquals(HandRankType.STRAIGHTFLUSH, handRanking.checkIsStraightFlush());
    }

    @Test
    public void canIdentifyFourOfAKind(){
        ArrayList<Card> hand = new ArrayList<Card>();
        player.getCard(two);
        player.getCard(two);
        player.getCard(two);
        player.getCard(two);
        player.getCard(three);
        hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertEquals(HandRankType.FOUROFAKIND, handRanking.checkIsFourOfAKind());
    }

    @Test
    public void canIdentifyFullHouse(){
        ArrayList<Card> hand = new ArrayList<Card>();
        player.getCard(three);
        player.getCard(three);
        player.getCard(two);
        player.getCard(two);
        player.getCard(two);
        hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertEquals(HandRankType.FULLHOUSE, handRanking.checkIsFullHouse());
        player.orderHandByRank();
        assertEquals(HandRankType.FULLHOUSE, handRanking.checkIsFullHouse());
    }

    @Test
    public void canIdentifyThreeOfAKind(){
        ArrayList<Card> hand = new ArrayList<Card>();
        player.getCard(two);
        player.getCard(two);
        player.getCard(two);
        player.getCard(three);
        player.getCard(three);
        hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertEquals(HandRankType.THREEOFAKIND, handRanking.checkIsThreeOfAKind());
    }

    @Test
    public void canIdentifyTwoPair(){
        ArrayList<Card> hand = new ArrayList<Card>();
        player.getCard(two);
        player.getCard(two);
        player.getCard(four);
        player.getCard(three);
        player.getCard(three);
        hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertEquals(HandRankType.TWOPAIR, handRanking.checkIsTwoPair());
        player.orderHandByRank();
        assertEquals(HandRankType.TWOPAIR, handRanking.checkIsTwoPair());
    }

    @Test
    public void canIdentifyOnePair(){
        ArrayList<Card> hand = new ArrayList<Card>();
        player.getCard(two);
        player.getCard(five);
        player.getCard(four);
        player.getCard(three);
        player.getCard(three);
        hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertEquals(HandRankType.ONEPAIR, handRanking.checkIsOnePair());
        player.orderHandByRank();
        assertEquals(HandRankType.ONEPAIR, handRanking.checkIsOnePair());
    }

    @Test
    public void canRateHand(){
        deck.shuffle();
        dealer.dealCards(deck, 5);
        player.orderHandByRank();
        ArrayList<Card> hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertNotEquals(null, handRanking.rateHand());
    }
}
