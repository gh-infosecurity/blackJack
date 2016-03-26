package za.co.sintez.black.jack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.sintez.black.jack.gamefield.GameField;

public class Response {
    private GameField gameField;

    public GameField getGameField() {
        return gameField;
    }

    @JsonProperty
    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }
}