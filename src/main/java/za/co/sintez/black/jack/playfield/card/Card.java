package za.co.sintez.black.jack.playfield.card;

import java.io.Serializable;

public class Card implements Serializable{
    private boolean visible;
    private String name;
    private String suit;
    private int score;

    public Card(boolean visible, String name, String suit, int score) {
        this.visible = visible;
        this.name = name;
        this.suit = suit;
        this.score = score;
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
