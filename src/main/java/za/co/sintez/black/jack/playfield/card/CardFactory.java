package za.co.sintez.black.jack.playfield.card;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {

    public static final int INITIAL_CAPACITY = 52;

    public CardDeck createCardDeck() {
        List<Card> cardDeck = new ArrayList<Card>(INITIAL_CAPACITY);
        for (Cards card : Cards.values()) {
            cardDeck.add(new Card(card.isVisible(), card.getName(), card.getSuit().value(), card.getScore()));
        }
        return new CardDeck(cardDeck);
    }
}