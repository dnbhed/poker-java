import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public int getNumOfCards() {
        return this.cards.size();
    }

    public void populate() {
        RankType[] rankArray = RankType.values();
        SuitType[] suitArray = SuitType.values();
        for(int i=0;i<suitArray.length; i++){
            for(int j=0; j<rankArray.length; j++){
                Card card = new Card(suitArray[i], rankArray[j]);
                this.cards.add(card);
            }
        }
    }

    public Card getFirstCard() {
        return this.cards.get(0);
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card deal() {
        Card card = getFirstCard();
        this.cards.remove(0);
        return card;
    }
}
