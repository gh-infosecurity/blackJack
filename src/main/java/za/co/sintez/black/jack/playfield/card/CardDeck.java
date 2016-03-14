package za.co.sintez.black.jack.playfield.card;

import java.util.List;

public class CardDeck {
    private List<Card> cardDeck;

    public CardDeck(List<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public List<Card> getCardDeck() {
        return cardDeck;
    }

}