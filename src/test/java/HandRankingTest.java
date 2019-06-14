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
        assertEquals("Flush", handRanking.checkIsFlush());
    }

    @Test
    public void canIdentifyStraight(){
        dealer.dealCards(deck, 5);
        player.orderHandByRank();
        ArrayList<Card> hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertEquals("Straight", handRanking.checkIsStraight());
    }

    @Test
    public void canIdentifyStraightFlush(){
        dealer.dealCards(deck, 5);
        player.orderHandByRank();
        ArrayList<Card> hand = player.showHand();
        handRanking = new HandRanking(hand);
        assertEquals("Straight Flush", handRanking.checkIsStraightFlush());
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
        assertEquals("Four of a Kind", handRanking.checkIsFourOfAKind());
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
        assertEquals("Full House", handRanking.checkIsFullHouse());
        player.orderHandByRank();
        assertEquals("Full House", handRanking.checkIsFullHouse());
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
        assertEquals("Three of a Kind", handRanking.checkIsThreeOfAKind());
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
        assertEquals("Two Pair", handRanking.checkIsTwoPair());
        player.orderHandByRank();
        assertEquals("Two Pair", handRanking.checkIsTwoPair());
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
        assertEquals("One Pair", handRanking.checkIsOnePair());
        player.orderHandByRank();
        assertEquals("One Pair", handRanking.checkIsOnePair());
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
