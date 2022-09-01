package ru.rosbank.optimization.config.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import ru.rosbank.optimization.client.CacheUserImpl;
import ru.rosbank.optimization.client.ScopeUserImpl;
import ru.rosbank.optimization.client.UserApi;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    @Scope(scopeName = "customScope", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserApi getScopeUserApi() {
        return new ScopeUserImpl();
    }

    @Bean
    //@Primary
    public UserApi getCacheUserApi() {
        return new CacheUserImpl();
    }
}
