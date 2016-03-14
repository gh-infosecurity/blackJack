package za.co.sintez.black.jack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.sintez.black.jack.playfield.Playfield;

public class Response {
    private Playfield playfield;

    public Playfield getPlayfield() {
        return playfield;
    }

    @JsonProperty
    public void setPlayfield(Playfield playfield) {
        this.playfield = playfield;
    }
}