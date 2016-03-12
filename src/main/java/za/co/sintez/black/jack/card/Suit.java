package za.co.sintez.black.jack.card;

public enum Suit {
    DIAMONDS("diamonds"),
    SPADES("spades"),
    HEARTS("hearts"),
    CLUBS("clubs");

    private String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public String value() {
        return suit;
    }
}