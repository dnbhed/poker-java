import java.util.ArrayList;

public class Dealer {

    private String name;
    private ArrayList<Player> players;
    private ArrayList<Card> hand;

    public Dealer(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.players = new ArrayList<Player>();
    }

    public int getNumOfCards() {
        return this.hand.size();
    }

    public String getName(){
        return this.name;
    }

    public void dealCards(Deck deck) {
        for(Player player: this.players){
            Card card = deck.deal();
            player.requestCard(card);
        }
        Card dealerCard = deck.deal();
        this.hand.add(dealerCard);
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public int getNumOfPlayers() {
        return this.players.size();
    }

    public int checkCardValue() {
        return this.hand.get(0).getValueFromEnum();
    }

    public String checkWhoWins() {
        String winner = "";
        if(checkCardValue() > players.get(0).checkCardValue()){
            winner = getName();
        } else {
            winner = players.get(0).getName();
        }
        return winner;
    }
}
