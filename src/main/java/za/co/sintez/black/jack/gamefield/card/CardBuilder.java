package za.co.sintez.black.jack.gamefield.card;

import java.util.ArrayList;
import java.util.List;

public class CardBuilder {
    private static final int INITIAL_CAPACITY = 52;

    public List<Card> build() {
        List<Card> cards = new ArrayList<>(INITIAL_CAPACITY);
        for (Cards card : Cards.values()) {
            cards.add(new Card(card));
        }
        return cards;
    }
}