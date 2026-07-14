package com.practice.coursemanagement.cache.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
public class RedisConfig {

	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory factory) {
		
		RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
		.disableCachingNullValues()
		.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
		
		return RedisCacheManager.builder(factory)
				.cacheDefaults(defaultConfig)
				.withCacheConfiguration("students", defaultConfig.entryTtl(Duration.ofMinutes(30)))
				.build();
	}
}
