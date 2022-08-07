package ru.rosbank.optimization.config.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import org.checkerframework.checker.index.qual.NonNegative;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CaffeineCacheConfig {

    public static String CACHE_NAME_SIGNATURE = "signature";
    public static String CACHE_NAME_SIGNATURE_CONST = "signatureConst";

    @Bean("defaultCacheManager")
    @Primary
    public CacheManager defaultCacheManager() {
        var cacheManager = new CaffeineCacheManager("signature");
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

    @Bean("constantLifetimeCacheManager")
    public CacheManager constantLifetimeCacheManager() {
        var cacheManager = new CaffeineCacheManager(CACHE_NAME_SIGNATURE_CONST);
        cacheManager.setCaffeine(constantLifetimeCacheBuilder());
        return cacheManager;
    }

    public Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .maximumSize(5000)
                .expireAfterWrite(Duration.ofSeconds(60)) // истечение после последней записи
                //.expireAfterAccess(Duration.ofDays(1)) // истечение после последнего доступа
                ;
    }

    // фиксированное время жизни 5 минут
    public Caffeine<Object, Object> constantLifetimeCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(1000)
                .maximumSize(5000)
                .expireAfter(new Expiry<>() {
                    @Override
                    public long expireAfterCreate(Object key, Object value, long currentTime) {
                        return TimeUnit.MINUTES.toNanos(5);
                    }

                    @Override
                    public long expireAfterUpdate(Object key, Object value, long currentTime, @NonNegative long currentDuration) {
                        return currentDuration;
                    }

                    @Override
                    public long expireAfterRead(Object key, Object value, long currentTime, @NonNegative long currentDuration) {
                        return currentDuration;
                    }
                });
    }
}
