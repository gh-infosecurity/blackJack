package za.co.sintez.black.jack.gamefield.card;

public enum Cards {
    _2_DIAMONDS(true, "2", Suit.DIAMONDS, 2),
    _2_SPADES(true, "2", Suit.SPADES, 2),
    _2_HEARTS(true, "2", Suit.HEARTS, 2),
    _2_CLUBS(true, "2", Suit.CLUBS, 2),

    _3_DIAMONDS(true, "3", Suit.DIAMONDS, 3),
    _3_SPADES(true, "3", Suit.SPADES, 3),
    _3_HEARTS(true, "3", Suit.HEARTS, 3),
    _3_CLUBS(true, "3", Suit.CLUBS, 3),

    _4_DIAMONDS(true, "4", Suit.DIAMONDS, 4),
    _4_SPADES(true, "4", Suit.SPADES, 4),
    _4_HEARTS(true, "4", Suit.HEARTS, 4),
    _4_CLUBS(true, "4", Suit.CLUBS, 4),

    _5_DIAMONDS(true, "5", Suit.DIAMONDS, 5),
    _5_SPADES(true, "5", Suit.SPADES, 5),
    _5_HEARTS(true, "5", Suit.HEARTS, 5),
    _5_CLUBS(true, "5", Suit.CLUBS, 5),

    _6_DIAMONDS(true, "6", Suit.DIAMONDS, 6),
    _6_SPADES(true, "6", Suit.SPADES, 6),
    _6_HEARTS(true, "6", Suit.HEARTS, 6),
    _6_CLUBS(true, "6", Suit.CLUBS, 6),

    _7_DIAMONDS(true, "7", Suit.DIAMONDS, 7),
    _7_SPADES(true, "7", Suit.SPADES, 7),
    _7_HEARTS(true, "7", Suit.HEARTS, 7),
    _7_CLUBS(true, "7", Suit.CLUBS, 7),

    _8_DIAMONDS(true, "8", Suit.DIAMONDS, 8),
    _8_SPADES(true, "8", Suit.SPADES, 8),
    _8_HEARTS(true, "8", Suit.HEARTS, 8),
    _8_CLUBS(true, "8", Suit.CLUBS, 8),

    _9_DIAMONDS(true, "9", Suit.DIAMONDS, 9),
    _9_SPADES(true, "9", Suit.SPADES, 9),
    _9_HEARTS(true, "9", Suit.HEARTS, 9),
    _9_CLUBS(true, "9", Suit.CLUBS, 9),

    _10_DIAMONDS(true, "10", Suit.DIAMONDS, 10),
    _10_SPADES(true, "10", Suit.SPADES, 10),
    _10_HEARTS(true, "10", Suit.HEARTS, 10),
    _10_CLUBS(true, "10", Suit.CLUBS, 10),

    JACK_DIAMONDS(true, "jack", Suit.DIAMONDS, 10),
    JACK_SPADES(true, "jack", Suit.SPADES, 10),
    JACK_HEARTS(true, "jack", Suit.HEARTS, 10),
    JACK_CLUBS(true, "jack", Suit.CLUBS, 10),

    QUEEN_DIAMONDS(true, "queen", Suit.DIAMONDS, 10),
    QUEEN_SPADES(true, "queen", Suit.SPADES, 10),
    QUEEN_HEARTS(true, "queen", Suit.HEARTS, 10),
    QUEEN_CLUBS(true, "queen", Suit.CLUBS, 10),

    KING_DIAMONDS(true, "king", Suit.DIAMONDS, 10),
    KING_SPADES(true, "king", Suit.SPADES, 10),
    KING_HEARTS(true, "king", Suit.HEARTS, 10),
    KING_CLUBS(true, "king", Suit.CLUBS, 10),

    ACE_DIAMONDS(true, "ace", Suit.DIAMONDS, 11),
    ACE_SPADES(true, "ace", Suit.SPADES, 11),
    ACE_HEARTS(true, "ace", Suit.HEARTS, 11),
    ACE_CLUBS(true, "ace", Suit.CLUBS, 11);

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