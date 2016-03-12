package za.co.sintez.black.jack.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    private int bet;

    public int getBet() {
        return bet;
    }

    @JsonProperty
    public void setBet(int bet) {
        this.bet = bet;
    }

}