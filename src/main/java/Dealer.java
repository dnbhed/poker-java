import java.util.ArrayList;

public class Dealer {

    private ArrayList<Player> players;

    public Dealer(String name){
        this.players = new ArrayList<Player>();
    }

    public void dealCards(Deck deck, int num) {
        for(int i = 0; i < num; i++) {
            for (Player player : this.players) {
                Card card = deck.deal();
                player.getCard(card);
            }
        }
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public int getNumOfPlayers() {
        return this.players.size();
    }

    public String checkWhoWins() {
        String winner = null;
        for(Player player: players){
            HandRanking handRanking = new HandRanking(player.showHand());

        }

        return winner;
    }



}
