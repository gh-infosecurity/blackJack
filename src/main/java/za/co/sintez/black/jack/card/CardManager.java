package za.co.sintez.black.jack.card;

import java.util.List;

public class CardManager {

    private final CardFactory cardFactory;

    public CardManager() {
        cardFactory = new CardFactory();
    }

    public List<Card> test() {
        return cardFactory.createCardDeck();
    }
}