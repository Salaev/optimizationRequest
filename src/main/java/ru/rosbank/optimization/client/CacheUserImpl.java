package ru.rosbank.optimization.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import ru.rosbank.optimization.models.entity.SignatureLevel;

import java.util.Set;

@Slf4j
public class CacheUserImpl extends AbstractUserImpl {

    @Override
    @Cacheable(cacheNames = {"signature"},
            key = "{#counterpartyId, T(ru.rosbank.optimization.config.ThreadLocalCustom).getContext().getCustomId()}",
            cacheResolver = "multipleCacheResolver", sync = true)
    public Set<SignatureLevel> getSignatureLevels(long counterpartyId) {
        return getSignatureLevelsByCounterparty(counterpartyId);
    }
}
