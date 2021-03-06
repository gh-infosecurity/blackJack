package za.co.sintez.black.jack.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.co.sintez.black.jack.playfield.card.Card;
import za.co.sintez.black.jack.playfield.players.Dealer;
import za.co.sintez.black.jack.playfield.players.Player;

import java.util.List;

@Component
@Repository
public class CacheDao implements CacheDaoI {
    private static final String KEY = "key";
    private StringRedisTemplate redisTemplate;

    @Autowired
    public CacheDao(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void savePlayer(Player player, String key) {
        redisTemplate.opsForHash().put(KEY, key, player);
    }

    @Override
    public void saveDealer(Dealer dealer, String key) {
        redisTemplate.opsForHash().put(KEY, key, dealer);
    }

    @Override
    public Player getPlayer(String key) {
        return redisTemplate.<String, Player>opsForHash().get(KEY, key);
    }

    @Override
    public Dealer getDealer(String key) {
        return redisTemplate.<String, Dealer>opsForHash().get(KEY, key);
    }

    @Override
    public void saveCardDeck(List<Card> cards, String key) {
        redisTemplate.opsForHash().put(KEY, key, cards);
    }

    @Override
    public List<Card> getCardDeck(String key) {
        return redisTemplate.<String, List<Card>>opsForHash().get(KEY, key);
    }
}