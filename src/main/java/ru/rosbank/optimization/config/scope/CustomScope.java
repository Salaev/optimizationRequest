package ru.rosbank.optimization.config.scope;

import com.github.benmanes.caffeine.cache.Cache;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import ru.rosbank.optimization.config.ThreadLocalCustom;

@Slf4j
@AllArgsConstructor
public class CustomScope implements Scope {
    private final Cache<Object, Object> defaultCacheManager;
    private final Cache<Object, Object> constantLifetimeCacheManager;

    @NotNull
    @Override
    public Object get(@NotNull String name, @NotNull ObjectFactory<?> objectFactory) {
        if (Long.parseLong(ThreadLocalCustom.getContext().getCustomId()) % 2 == 0) {
            return defaultCacheManager.get(name + ThreadLocalCustom.getContext().getCustomId(), k -> objectFactory.getObject());
        } else {
            return constantLifetimeCacheManager.get(name + ThreadLocalCustom.getContext().getCustomId(), k -> objectFactory.getObject());
        }
    }

    @Override
    public Object remove(@NotNull String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(@NotNull String name, @NotNull Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(@NotNull String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

}
