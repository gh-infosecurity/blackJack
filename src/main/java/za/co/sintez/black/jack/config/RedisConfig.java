package za.co.sintez.black.jack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import za.co.sintez.black.jack.Controller;
import za.co.sintez.black.jack.ScoreChecker;
import za.co.sintez.black.jack.dao.CacheDao;
import za.co.sintez.black.jack.dao.CacheDaoI;
import za.co.sintez.black.jack.gamefield.GameField;
import za.co.sintez.black.jack.gamefield.card.CardBuilder;
import za.co.sintez.black.jack.gamefield.players.Dealer;
import za.co.sintez.black.jack.gamefield.players.Player;

@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, GameField> redisTemplate() {
        RedisTemplate<String, GameField> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setHashValueSerializer(redisTemplate.getDefaultSerializer());
        return redisTemplate;
    }

    @Bean
    public CacheDaoI studentRepository() {
        return new CacheDao(redisTemplate());
    }

    @Bean
    public GameField gameField() {
        GameField gameField = new GameField();
        gameField.setPlayer(new Player());
        gameField.setDealer(new Dealer());
        gameField.setCash(0);
        return gameField;
    }

    @Bean
    public Controller controller() {
        return new Controller();
    }

    @Bean
    public ScoreChecker scoreChecker() {
        return new ScoreChecker();
    }

    @Bean
    public CardBuilder cardBuilder() {
        return new CardBuilder();
    }
}