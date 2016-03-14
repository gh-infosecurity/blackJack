package za.co.sintez.black.jack.playfield.players;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.sintez.black.jack.playfield.card.Card;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {
    private Integer cash = 100;
    private List<Card> cards;

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
}