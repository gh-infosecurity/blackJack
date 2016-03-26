package za.co.sintez.black.jack.playfield;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.sintez.black.jack.playfield.card.CardDeck;
import za.co.sintez.black.jack.playfield.players.Dealer;
import za.co.sintez.black.jack.playfield.players.Player;

public class PlayField {
    private Player player;
    private Dealer dealer;
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

    public int getCash() {
        return cash;
    }

    @JsonProperty
    public void setCash(int cash) {
        this.cash = cash;
    }
}