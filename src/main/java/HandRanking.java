import java.util.ArrayList;
import java.util.Collections;

public class HandRanking {

    private ArrayList<Card> hand;
    private HandRankType rank;

    public HandRanking(ArrayList<Card> hand){
        this.hand = hand;
        this.rank = HandRankType.HIGHCARD;
    }

    public HandRankType checkIsFlush(){
        SuitType suit = this.hand.get(0).getSuit();
        for(Card card : this.hand) {
           if (card.getSuit() == suit) {
               this.rank = HandRankType.FLUSH;
            } else {
               this.rank = HandRankType.HIGHCARD;
           }
        }
        return this.rank;
    }

    public HandRankType checkIsStraight() {

        int card1value = this.hand.get(0).getRank().getValue();
        int card2value = this.hand.get(1).getRank().getValue();
        int card3value = this.hand.get(2).getRank().getValue();
        int card4value = this.hand.get(3).getRank().getValue();
        int card5value = this.hand.get(4).getRank().getValue();

        if (card2value == card1value + 1
                &&
                card3value == card2value + 1
                &&
                card4value == card3value + 1
                &&
                card5value == card4value + 1
        ){
            this.rank = HandRankType.STRAIGHT;
        }
        return this.rank;
    }

    public HandRankType checkIsStraightFlush() {
        HandRankType flush = checkIsFlush();
        HandRankType straight = checkIsStraight();
        if (flush != HandRankType.HIGHCARD && straight != HandRankType.HIGHCARD){
            this.rank = HandRankType.STRAIGHTFLUSH;
        }
        return this.rank;
    }

    public HandRankType checkIsFourOfAKind() {

        int card1value = this.hand.get(0).getRank().getValue();
        int card2value = this.hand.get(1).getRank().getValue();
        int card4value = this.hand.get(3).getRank().getValue();
        int card5value = this.hand.get(4).getRank().getValue();

        if(card1value == card4value || card2value == card5value){
            this.rank = HandRankType.FOUROFAKIND;
        }

        return this.rank;
    }

    public HandRankType checkIsThreeOfAKind() {

        int card1value = this.hand.get(0).getRank().getValue();
        int card2value = this.hand.get(1).getRank().getValue();
        int card3value = this.hand.get(2).getRank().getValue();
        int card4value = this.hand.get(3).getRank().getValue();
        int card5value = this.hand.get(4).getRank().getValue();

        if(card1value == card3value || card3value == card5value || card2value == card4value){
            this.rank = HandRankType.THREEOFAKIND;
        }

        return this.rank;
    }

    public HandRankType checkIsTwoPair() {

        int card1value = this.hand.get(0).getRank().getValue();
        int card2value = this.hand.get(1).getRank().getValue();
        int card3value = this.hand.get(2).getRank().getValue();
        int card4value = this.hand.get(3).getRank().getValue();
        int card5value = this.hand.get(4).getRank().getValue();

        if((card1value == card2value && card3value == card4value)
            ||
                (card2value == card3value && card4value == card5value)
                ||
                (card1value == card2value && card4value == card5value)
        ){
            this.rank = HandRankType.TWOPAIR;
        }
        return this.rank;
    }

    public HandRankType checkIsOnePair() {

        int card1value = this.hand.get(0).getRank().getValue();
        int card2value = this.hand.get(1).getRank().getValue();
        int card3value = this.hand.get(2).getRank().getValue();
        int card4value = this.hand.get(3).getRank().getValue();
        int card5value = this.hand.get(4).getRank().getValue();

        if(card1value == card2value || card2value == card3value || card3value == card4value || card4value == card5value){
            this.rank = HandRankType.ONEPAIR;
        }
        return this.rank;
    }

    public HandRankType checkIsFullHouse() {

        int card1value = this.hand.get(0).getRank().getValue();
        int card2value = this.hand.get(1).getRank().getValue();
        int card3value = this.hand.get(2).getRank().getValue();
        int card4value = this.hand.get(3).getRank().getValue();
        int card5value = this.hand.get(4).getRank().getValue();

        if ((card1value == card2value && card3value == card5value) || (card1value == card3value && card4value == card5value)) {
        this.rank = HandRankType.FULLHOUSE;
        }

        return this.rank;
    }

    public HandRankType rateHand() {
        if(checkIsStraightFlush() != null){
            return checkIsStraightFlush();
        } else if(checkIsFourOfAKind() != null){
            return checkIsFourOfAKind();
        } else if(checkIsFullHouse()!= null){
            return checkIsFullHouse();
        } else if(checkIsFlush() != null){
            return checkIsFlush();
        } else if(checkIsStraight() != null){
            return checkIsStraight();
        } else if(checkIsThreeOfAKind() != null){
            return checkIsThreeOfAKind();
        } else if (checkIsTwoPair() != null){
            return checkIsTwoPair();
        } else if (checkIsOnePair() != null){
            return checkIsOnePair();
        }
        return this.rank;
    }
}
