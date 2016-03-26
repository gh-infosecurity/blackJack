package za.co.sintez.black.jack.gamefield.players;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.sintez.black.jack.gamefield.card.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dealer implements Serializable {
    private boolean winner;
    private Integer cash = 100;
    private List<Card> cards = new ArrayList<>();

    public boolean isWinner() {
        return winner;
    }

    @JsonProperty
    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public Integer getCash() {
        return cash;
    }

    @JsonProperty
    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public List<Card> getCards() {
        return cards;
    }

    @JsonProperty
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int doBet(int bet) {
        cash = cash - bet;
        return bet;
    }

    public void win(int cash) {
        this.cash = this.cash + cash;
        winner = true;
    }
}