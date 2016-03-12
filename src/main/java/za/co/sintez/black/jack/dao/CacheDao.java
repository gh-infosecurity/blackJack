package za.co.sintez.black.jack.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.co.sintez.black.jack.players.Dealer;
import za.co.sintez.black.jack.players.Player;

@Component
@Repository
public class CacheDao implements CacheDaoI {
    private RedisTemplate redisTemplate;

    @Autowired
    public CacheDao(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void savePlayer(Player player, String key) {
        redisTemplate.opsForValue().set(key, player);
    }

    @Override
    public void saveDealer(Dealer dealer, String key) {
        redisTemplate.opsForValue().set(key, dealer);
    }

    @Override
    public Player findPlayer(String key) {
        return (Player) redisTemplate.opsForValue().get(key);
    }

    @Override
    public Dealer findDealer(String key) {
        return null;
    }
}