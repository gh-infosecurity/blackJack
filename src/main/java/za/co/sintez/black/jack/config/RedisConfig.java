package za.co.sintez.black.jack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import za.co.sintez.black.jack.dao.CacheDao;
import za.co.sintez.black.jack.dao.CacheDaoI;

@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public StringRedisTemplate redisTemplate() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setHashValueSerializer(redisTemplate.getDefaultSerializer());
        return redisTemplate;
    }

    @Bean
    public CacheDaoI studentRepository() {
        return new CacheDao(redisTemplate());
    }
}