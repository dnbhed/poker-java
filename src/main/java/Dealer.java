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

    public Player checkWhoWins() {
        Player winner = players.get(0);
        for(Player player: players){
            HandRanking currentWinnerRanking = new HandRanking(winner.showHand());
            HandRanking playerHandRanking = new HandRanking(player.showHand());
            if(playerHandRanking.rateHand().getValue() < currentWinnerRanking.rateHand().getValue()){
                winner = player;
            }
//            if(playerHandRanking.rateHand().getValue() == currentWinnerRanking.rateHand().getValue()){
//                winner = checkWhoWinsEqualHands();
//            }
        }
        return winner;
    }

    public Player checkWhoWinsHighCard() {
        Player winner = players.get(0);
        for(Player player: players){
            int currentWinnerRanking = winner.checkLastCardValue();
            int playerHandRanking = player.checkLastCardValue();
            if(playerHandRanking > currentWinnerRanking){
                winner = player;
            }
        }
        return winner;
    }

//    public Player checkWhoWinsOnePair() {
//        Player winner = players.get(0);
//        for(Player player: players){
//
//        }
//
//
//
//        return winner;
//    }


//    public Player checkWhoWinsFullHouse() {
//
//
//        return winner;
//    }
}
