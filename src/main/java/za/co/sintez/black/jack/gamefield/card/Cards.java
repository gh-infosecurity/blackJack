package za.co.sintez.black.jack.gamefield.card;

public enum Cards {
    _2_DIAMONDS(false, "2", Suit.DIAMONDS, 2),
    _2_SPADES(false, "2", Suit.SPADES, 2),
    _2_HEARTS(false, "2", Suit.HEARTS, 2),
    _2_CLUBS(false, "2", Suit.CLUBS, 2),

    _3_DIAMONDS(false, "3", Suit.DIAMONDS, 3),
    _3_SPADES(false, "3", Suit.SPADES, 3),
    _3_HEARTS(false, "3", Suit.HEARTS, 3),
    _3_CLUBS(false, "3", Suit.CLUBS, 3),

    _4_DIAMONDS(false, "4", Suit.DIAMONDS, 4),
    _4_SPADES(false, "4", Suit.SPADES, 4),
    _4_HEARTS(false, "4", Suit.HEARTS, 4),
    _4_CLUBS(false, "4", Suit.CLUBS, 4),

    _5_DIAMONDS(false, "5", Suit.DIAMONDS, 5),
    _5_SPADES(false, "5", Suit.SPADES, 5),
    _5_HEARTS(false, "5", Suit.HEARTS, 5),
    _5_CLUBS(false, "5", Suit.CLUBS, 5),

    _6_DIAMONDS(false, "6", Suit.DIAMONDS, 6),
    _6_SPADES(false, "6", Suit.SPADES, 6),
    _6_HEARTS(false, "6", Suit.HEARTS, 6),
    _6_CLUBS(false, "6", Suit.CLUBS, 6),

    _7_DIAMONDS(false, "7", Suit.DIAMONDS, 7),
    _7_SPADES(false, "7", Suit.SPADES, 7),
    _7_HEARTS(false, "7", Suit.HEARTS, 7),
    _7_CLUBS(false, "7", Suit.CLUBS, 7),

    _8_DIAMONDS(false, "8", Suit.DIAMONDS, 8),
    _8_SPADES(false, "8", Suit.SPADES, 8),
    _8_HEARTS(false, "8", Suit.HEARTS, 8),
    _8_CLUBS(false, "8", Suit.CLUBS, 8),

    _9_DIAMONDS(false, "9", Suit.DIAMONDS, 9),
    _9_SPADES(false, "9", Suit.SPADES, 9),
    _9_HEARTS(false, "9", Suit.HEARTS, 9),
    _9_CLUBS(false, "9", Suit.CLUBS, 9),

    _10_DIAMONDS(false, "10", Suit.DIAMONDS, 10),
    _10_SPADES(false, "10", Suit.SPADES, 10),
    _10_HEARTS(false, "10", Suit.HEARTS, 10),
    _10_CLUBS(false, "10", Suit.CLUBS, 10),

    JACK_DIAMONDS(false, "jack", Suit.DIAMONDS, 10),
    JACK_SPADES(false, "jack", Suit.SPADES, 10),
    JACK_HEARTS(false, "jack", Suit.HEARTS, 10),
    JACK_CLUBS(false, "jack", Suit.CLUBS, 10),

    QUEEN_DIAMONDS(false, "queen", Suit.DIAMONDS, 10),
    QUEEN_SPADES(false, "queen", Suit.SPADES, 10),
    QUEEN_HEARTS(false, "queen", Suit.HEARTS, 10),
    QUEEN_CLUBS(false, "queen", Suit.CLUBS, 10),

    KING_DIAMONDS(false, "king", Suit.DIAMONDS, 10),
    KING_SPADES(false, "king", Suit.SPADES, 10),
    KING_HEARTS(false, "king", Suit.HEARTS, 10),
    KING_CLUBS(false, "king", Suit.CLUBS, 10),

    ACE_DIAMONDS(false, "ace", Suit.DIAMONDS, 11),
    ACE_SPADES(false, "ace", Suit.SPADES, 11),
    ACE_HEARTS(false, "ace", Suit.HEARTS, 11),
    ACE_CLUBS(false, "ace", Suit.CLUBS, 11);

    private boolean visible;
    private String name;
    private Suit suit;
    private int score;

    Cards(boolean visible, String name, Suit suit, int score) {
        this.visible = visible;
        this.score = score;
        this.name = name;
        this.suit = suit;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getName() {
        return name;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getScore() {
        return score;
    }
}