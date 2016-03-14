package za.co.sintez.black.jack.playfield.card;

import java.util.List;

public class CardDeck {
    private List<Card> cards;

    public CardDeck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

}