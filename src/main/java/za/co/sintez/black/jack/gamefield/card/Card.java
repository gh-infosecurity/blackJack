package za.co.sintez.black.jack.gamefield.card;

import java.io.Serializable;

public class Card implements Serializable {
    private boolean visible;
    private String name;
    private String suit;
    private int score;

    public Card(Cards card) {
        this.visible = card.isVisible();
        this.name = card.getName();
        this.suit = card.getSuit().value();
        this.score = card.getScore();
    }

    public boolean isVisible() {
        return visible;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getScore() {
        return score;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
