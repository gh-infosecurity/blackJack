package za.co.sintez.black.jack.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.co.sintez.black.jack.gamefield.GameField;

@Component
@Repository
public class CacheDao implements CacheDaoI {
    private static final String KEY = "play_field";

    private RedisTemplate<String, GameField> redisTemplate;

    @Autowired
    public CacheDao(RedisTemplate<String, GameField> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void saveGameField(GameField gameField) {
        redisTemplate.opsForValue().set(KEY, gameField);
    }

    @Override
    public GameField getGameField() {
        return redisTemplate.opsForValue().get(KEY);
    }
}