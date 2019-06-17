import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public String getName() {
        return this.name;
    }

    public int getNumOfCards() {
        return this.hand.size();
    }

    public void getCard(Card card){
        this.hand.add(card);
    }

    public int checkCardValue() {
        return this.hand.get(0).getValueFromEnum();
    }

    public int checkLastCardValue() {
        return this.hand.get(4).getValueFromEnum();
    }

    public ArrayList showHand() {
        return this.hand;
    }

    public void orderHandByRank() {
        ArrayList<Card> sortedHand = new ArrayList<Card>();
        int cardRank = 1;
        for (Card card : this.hand) {
            cardRank = card.getRank().getValue();
            if(sortedHand.isEmpty()){
                sortedHand.add(0, card);
            } else if (cardRank < sortedHand.get(0).getRank().getValue()){
                sortedHand.add(0, card);
            } else if (sortedHand.size() == 1){
                sortedHand.add(1, card);
            } else if (cardRank < sortedHand.get(1).getRank().getValue()){
                sortedHand.add(1, card);
            } else if (sortedHand.size() == 2){
                sortedHand.add(2, card);
            } else if (cardRank < sortedHand.get(2).getRank().getValue()){
                sortedHand.add(2, card);
            } else if (sortedHand.size() == 3){
                sortedHand.add(3, card);
            } else if(cardRank < sortedHand.get(3).getRank().getValue()){
                sortedHand.add(3, card);
            } else {
                sortedHand.add(4, card);
            }
        }
        this.hand = sortedHand;
    }
}
