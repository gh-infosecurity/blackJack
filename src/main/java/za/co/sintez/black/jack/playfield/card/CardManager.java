package za.co.sintez.black.jack.playfield.card;

public class CardManager {

    private final CardFactory cardFactory;

    public CardManager() {
        cardFactory = new CardFactory();
    }

    public CardDeck test() {
        return cardFactory.createCardDeck();
    }
}