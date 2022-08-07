package ru.rosbank.optimization.client;

import ru.rosbank.optimization.models.entity.SignatureLevel;

import java.util.Set;

public interface UserApi {
    Set<SignatureLevel> getSignatureLevels(long counterpartyId);
}
