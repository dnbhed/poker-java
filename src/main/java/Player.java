import java.util.ArrayList;
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


    public ArrayList showHand() {
        return this.hand;
    }
}
