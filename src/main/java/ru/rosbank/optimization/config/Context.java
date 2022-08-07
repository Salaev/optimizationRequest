package ru.rosbank.optimization.config;

import lombok.Data;

@Data
public class Context {
    private String customId;

    public Context(String customId) {
        this.customId = customId;
    }
}
