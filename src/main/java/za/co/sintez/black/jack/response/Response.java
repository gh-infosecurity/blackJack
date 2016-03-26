package za.co.sintez.black.jack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.sintez.black.jack.playfield.PlayField;

public class Response {
    private PlayField playField;

    public PlayField getPlayField() {
        return playField;
    }

    @JsonProperty
    public void setPlayField(PlayField playField) {
        this.playField = playField;
    }
}