package za.co.sintez.black.jack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.sintez.black.jack.playfield.PlayField;
import za.co.sintez.black.jack.playfield.card.CardDeck;
import za.co.sintez.black.jack.playfield.card.CardFactory;
import za.co.sintez.black.jack.playfield.players.Dealer;
import za.co.sintez.black.jack.playfield.players.Player;

@Configuration
public class ServiceConfig {

    @Bean
    Dealer dealer() {
        return new Dealer();
    }

    @Bean
    public Player player() {
        return new Player();
    }

    @Bean
    public CardDeck cardDeck(){
        return new CardFactory().createCardDeck();
    }

    @Bean
    public PlayField playfield(){
        PlayField playField = new PlayField();
        playField.setPlayer(new Player());
        playField.setDealer(new Dealer());
        playField.setCash(0);
        return playField;
    }
}