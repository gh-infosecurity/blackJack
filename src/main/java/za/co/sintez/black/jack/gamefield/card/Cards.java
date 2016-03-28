package za.co.sintez.black.jack.gamefield.card;

import static za.co.sintez.black.jack.gamefield.card.Suit.CLUBS;
import static za.co.sintez.black.jack.gamefield.card.Suit.DIAMONDS;
import static za.co.sintez.black.jack.gamefield.card.Suit.HEARTS;
import static za.co.sintez.black.jack.gamefield.card.Suit.SPADES;

public enum Cards {
    _2_DIAMONDS(false, "2", DIAMONDS, 2),
    _2_SPADES(false, "2", SPADES, 2),
    _2_HEARTS(false, "2", HEARTS, 2),
    _2_CLUBS(false, "2", CLUBS, 2),

    _3_DIAMONDS(false, "3", DIAMONDS, 3),
    _3_SPADES(false, "3", SPADES, 3),
    _3_HEARTS(false, "3", HEARTS, 3),
    _3_CLUBS(false, "3", CLUBS, 3),

    _4_DIAMONDS(false, "4", DIAMONDS, 4),
    _4_SPADES(false, "4", SPADES, 4),
    _4_HEARTS(false, "4", HEARTS, 4),
    _4_CLUBS(false, "4", CLUBS, 4),

    _5_DIAMONDS(false, "5", DIAMONDS, 5),
    _5_SPADES(false, "5", SPADES, 5),
    _5_HEARTS(false, "5", HEARTS, 5),
    _5_CLUBS(false, "5", CLUBS, 5),

    _6_DIAMONDS(false, "6", DIAMONDS, 6),
    _6_SPADES(false, "6", SPADES, 6),
    _6_HEARTS(false, "6", HEARTS, 6),
    _6_CLUBS(false, "6", CLUBS, 6),

    _7_DIAMONDS(false, "7", DIAMONDS, 7),
    _7_SPADES(false, "7", SPADES, 7),
    _7_HEARTS(false, "7", HEARTS, 7),
    _7_CLUBS(false, "7", CLUBS, 7),

    _8_DIAMONDS(false, "8", DIAMONDS, 8),
    _8_SPADES(false, "8", SPADES, 8),
    _8_HEARTS(false, "8", HEARTS, 8),
    _8_CLUBS(false, "8", CLUBS, 8),

    _9_DIAMONDS(false, "9", DIAMONDS, 9),
    _9_SPADES(false, "9", SPADES, 9),
    _9_HEARTS(false, "9", HEARTS, 9),
    _9_CLUBS(false, "9", CLUBS, 9),

    _10_DIAMONDS(false, "10", DIAMONDS, 10),
    _10_SPADES(false, "10", SPADES, 10),
    _10_HEARTS(false, "10", HEARTS, 10),
    _10_CLUBS(false, "10", CLUBS, 10),

    JACK_DIAMONDS(false, "jack", DIAMONDS, 10),
    JACK_SPADES(false, "jack", SPADES, 10),
    JACK_HEARTS(false, "jack", HEARTS, 10),
    JACK_CLUBS(false, "jack", CLUBS, 10),

    QUEEN_DIAMONDS(false, "queen", DIAMONDS, 10),
    QUEEN_SPADES(false, "queen", SPADES, 10),
    QUEEN_HEARTS(false, "queen", HEARTS, 10),
    QUEEN_CLUBS(false, "queen", CLUBS, 10),

    KING_DIAMONDS(false, "king", DIAMONDS, 10),
    KING_SPADES(false, "king", SPADES, 10),
    KING_HEARTS(false, "king", HEARTS, 10),
    KING_CLUBS(false, "king", CLUBS, 10),

    ACE_DIAMONDS(false, "ace", DIAMONDS, 11),
    ACE_SPADES(false, "ace", SPADES, 11),
    ACE_HEARTS(false, "ace", HEARTS, 11),
    ACE_CLUBS(false, "ace", CLUBS, 11);

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