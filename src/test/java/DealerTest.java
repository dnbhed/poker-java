import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DealerTest {

    Dealer dealer;
    Player player1;
    Player player2;
    Player player3;
    Deck deck;
    Card card;
    Card two;
    Card three;
    Card four;
    Card five;
    Card six;
    Card seven;

    @Before
    public void before(){
        dealer = new Dealer("Ben");
        player1 = new Player("Gazza");
        player2 = new Player("Jim");
        player3 = new Player("Joe");
        deck = new Deck();
        card = new Card(SuitType.SPADES, RankType.KING);
        two = new Card(SuitType.HEARTS, RankType.TWO);
        three = new Card(SuitType.HEARTS, RankType.THREE);
        four = new Card(SuitType.HEARTS, RankType.FOUR);
        five = new Card(SuitType.HEARTS, RankType.FIVE);
        six = new Card(SuitType.HEARTS, RankType.SIX);
        seven = new Card(SuitType.HEARTS, RankType.SEVEN);
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
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        player1.getCard(two);
        player1.getCard(two);
        player1.getCard(two);
        player1.getCard(two);
        player1.getCard(card);
        player2.getCard(two);
        player2.getCard(two);
        player2.getCard(two);
        player2.getCard(card);
        player2.getCard(card);
        assertEquals(player1, dealer.checkWhoWins());
    }

    @Test
    public void dealerCanCheckWhoWinsWith3Players(){
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        dealer.addPlayer(player3);
        player1.getCard(two);
        player1.getCard(two);
        player1.getCard(two);
        player1.getCard(two);
        player1.getCard(card);
        player2.getCard(two);
        player2.getCard(two);
        player2.getCard(two);
        player2.getCard(card);
        player2.getCard(card);
        player3.getCard(two);
        player3.getCard(three);
        player3.getCard(four);
        player3.getCard(five);
        player3.getCard(six);
        assertEquals(player3, dealer.checkWhoWins());
    }

    @Test
    public void dealerCanCheckWhoWinsHighCard(){
        dealer.addPlayer(player1);
        dealer.addPlayer(player2);
        player1.getCard(two);
        player1.getCard(three);
        player1.getCard(four);
        player1.getCard(five);
        player1.getCard(seven);
        player2.getCard(two);
        player2.getCard(three);
        player2.getCard(four);
        player2.getCard(five);
        player2.getCard(card);
        player1.orderHandByRank();
        player2.orderHandByRank();
        assertEquals(player2, dealer.checkWhoWinsHighCard());
    }

//    @Test
//    public void canCheckWhoWinsHigherPair(){
//        dealer.addPlayer(player1);
//        dealer.addPlayer(player2);
//        player1.getCard(two);
//        player1.getCard(three);
//        player1.getCard(four);
//        player1.getCard(seven);
//        player1.getCard(seven);
//        player2.getCard(two);
//        player2.getCard(three);
//        player2.getCard(four);
//        player2.getCard(card);
//        player2.getCard(card);
//        player1.orderHandByRank();
//        player2.orderHandByRank();
//        assertEquals(player2, dealer.checkWhoWinsOnePair());
//    }
//    @Test
//    public void dealerCanCheckWhoWinsForHigherFullHouse(){
//        player1.getCard(two);
//        player1.getCard(two);
//        player1.getCard(three);
//        player1.getCard(three);
//        player1.getCard(three);
//        player2.getCard(two);
//        player2.getCard(two);
//        player2.getCard(two);
//        player2.getCard(card);
//        player2.getCard(card);
//        assertEquals(player1, dealer.checkWhoWinsFullHouse());
//    }

}
