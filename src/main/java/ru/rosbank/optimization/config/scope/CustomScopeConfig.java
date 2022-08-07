package ru.rosbank.optimization.config.scope;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Configuration;
import ru.rosbank.optimization.config.scope.CustomBeanFactoryPostProcessor;

@Configuration
public class CustomScopeConfig {
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }
}
