package za.co.sintez.black.jack.players;

import java.io.Serializable;

public class Dealer implements Serializable {
    private int cash = 100;
    private int bet;

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}