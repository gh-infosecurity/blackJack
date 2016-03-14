package za.co.sintez.black.jack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.sintez.black.jack.playfield.Playfield;
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
    public CardFactory cardFactory(){
        return new CardFactory();
    }

    @Bean
    public Playfield playfield(){
        Playfield playfield = new Playfield();
        playfield.setPlayer(new Player());
        playfield.setDealer(new Dealer());
        playfield.setCash(0);
        return playfield;
    }
}