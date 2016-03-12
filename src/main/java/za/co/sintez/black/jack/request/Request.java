package za.co.sintez.black.jack.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {
    private int bet;

    public int getBet() {
        return bet;
    }

    @JsonProperty
    public void setBet(int bet) {
        this.bet = bet;
    }
}