package za.co.sintez.black.jack;

import za.co.sintez.black.jack.gamefield.card.Card;

import java.util.List;

public class ScoreChecker {

    public static final int BLACK_JACK = 21;
    public static final int ZERO = 0;

    public boolean isBlackJack(List<Card> cards) {
        int score = ZERO;
        for (Card card : cards) {
            score += card.getScore();
        }
        return score == BLACK_JACK;
    }
}
