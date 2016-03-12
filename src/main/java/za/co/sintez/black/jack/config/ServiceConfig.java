package za.co.sintez.black.jack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.sintez.black.jack.players.Dealer;
import za.co.sintez.black.jack.players.Player;

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
}
