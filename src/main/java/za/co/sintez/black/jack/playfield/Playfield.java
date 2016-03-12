package za.co.sintez.black.jack.playfield;

import za.co.sintez.black.jack.card.CardDeck;
import za.co.sintez.black.jack.players.Dealer;
import za.co.sintez.black.jack.players.Player;

public class Playfield {
    private Dealer dealer;
    private Player player;
    private CardDeck cardDeck;
    private int cash;

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
