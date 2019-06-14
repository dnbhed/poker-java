import java.util.ArrayList;
import java.util.Collections;

public class HandRanking {

    private ArrayList<Card> hand;

    public HandRanking(ArrayList<Card> hand){
        this.hand = hand;
    }

    public String checkIsFlush(){
        String result = null;
        SuitType suit = this.hand.get(0).getSuit();
        for(Card card : this.hand) {
           if (card.getSuit() == suit) {
                result = "Flush";
            }
        }
        return result;
    }

    public String checkIsStraight() {
        String result = null;

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
            result = "Straight";
        }
        return result;
    }

    public String checkIsStraightFlush() {
        String result = null;
        String flush = checkIsFlush();
        String straight = checkIsStraight();
        if (flush != null && straight != null){
            result = "Straight Flush";
        }
        return result;
    }

    public String checkIsFourOfAKind() {
        String result = null;
        int card1value = this.hand.get(0).getRank().getValue();
        int card2value = this.hand.get(1).getRank().getValue();
        int card4value = this.hand.get(3).getRank().getValue();
        int card5value = this.hand.get(4).getRank().getValue();

        if(card1value == card4value || card2value == card5value){
            result = "Four of a Kind";
        }

        return result;
    }

    public String checkIsThreeOfAKind() {
        String result = null;
        int card1value = this.hand.get(0).getRank().getValue();
        int card2value = this.hand.get(1).getRank().getValue();
        int card3value = this.hand.get(2).getRank().getValue();
        int card4value = this.hand.get(3).getRank().getValue();
        int card5value = this.hand.get(4).getRank().getValue();

        if(card1value == card3value || card3value == card5value || card2value == card4value){
            result = "Three of a Kind";
        }

        return result;
    }

    public String checkIsTwoPair() {
        String result = null;
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
            result = "Two Pair";
        }
        return result;
    }

    public String checkIsOnePair() {
        String result = null;
        int card1value = this.hand.get(0).getRank().getValue();
        int card2value = this.hand.get(1).getRank().getValue();
        int card3value = this.hand.get(2).getRank().getValue();
        int card4value = this.hand.get(3).getRank().getValue();
        int card5value = this.hand.get(4).getRank().getValue();

        if(card1value == card2value || card2value == card3value || card3value == card4value || card4value == card5value){
            result = "One Pair";
        }
        return result;
    }

    public String checkIsFullHouse() {
        String result = null;
        int card1value = this.hand.get(0).getRank().getValue();
        int card2value = this.hand.get(1).getRank().getValue();
        int card3value = this.hand.get(2).getRank().getValue();
        int card4value = this.hand.get(3).getRank().getValue();
        int card5value = this.hand.get(4).getRank().getValue();

        if ((card1value == card2value && card3value == card5value) || (card1value == card3value && card4value == card5value)) {
        result = "Full House";
        }

        return result;
    }

    public String rateHand() {
        String result = null;
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
        } else result = "High Card";
        return result;
    }
}
