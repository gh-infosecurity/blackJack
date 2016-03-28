package za.co.sintez.black.jack.gamefield;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.sintez.black.jack.gamefield.card.Card;
import za.co.sintez.black.jack.gamefield.players.Dealer;
import za.co.sintez.black.jack.gamefield.players.Player;

import java.io.Serializable;
import java.util.List;

public class GameField implements Serializable {
    private Player player;
    private Dealer dealer;
    private List<Card> cards;
    private int cash;

    public Dealer getDealer() {
        return dealer;
    }

    @JsonProperty
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Player getPlayer() {
        return player;
    }

    @JsonProperty
    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Card> getCards() {
        return cards;
    }

    @JsonProperty
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getCash() {
        return cash;
    }

    @JsonProperty
    public void setCash(int cash) {
        this.cash = cash;
    }

    public void clearCash() {
        this.cash = 0;
    }

    public void clearPlayers(List<Card> playerCards, List<Card> dealerCards) {
        player.getCards().removeAll(playerCards);
        dealer.getCards().removeAll(dealerCards);
        player.setWinner(false);
        dealer.setWinner(false);
    }
}