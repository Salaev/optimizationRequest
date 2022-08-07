package ru.rosbank.optimization.config.cache;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.stereotype.Component;
import ru.rosbank.optimization.config.cache.CaffeineCacheConfig;

import java.util.ArrayList;
import java.util.Collection;

@Component
@AllArgsConstructor
public class MultipleCacheResolver implements CacheResolver {

    @Qualifier("defaultCacheManager")
    private final CacheManager defaultCacheManager;
    @Qualifier("constantLifetimeCacheManager")
    private final CacheManager constantLifetimeCacheManager;

    @NotNull
    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        var caches = new ArrayList<Cache>();
        var counterpartyId = (long) context.getArgs()[0];
        if (counterpartyId % 2 == 0) {
            caches.add(defaultCacheManager.getCache(CaffeineCacheConfig.CACHE_NAME_SIGNATURE));
        } else {
            caches.add(constantLifetimeCacheManager.getCache(CaffeineCacheConfig.CACHE_NAME_SIGNATURE_CONST));
        }
        return caches;
    }
}
