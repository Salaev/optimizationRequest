package ru.rosbank.optimization.config.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import ru.rosbank.optimization.config.cache.CaffeineCacheConfig;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        var config = new CaffeineCacheConfig();
        beanFactory.registerScope("customScope", new CustomScope(
                config.caffeineCacheBuilder().build(),
                config.constantLifetimeCacheBuilder().build()
        ));
    }
}
