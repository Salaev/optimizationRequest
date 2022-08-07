package ru.rosbank.optimization.client;

import lombok.extern.slf4j.Slf4j;
import ru.rosbank.optimization.models.entity.SignatureLevel;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ScopeUserImpl extends AbstractUserImpl {

    private final Set<SignatureLevel> signatureLevels = new HashSet<>();
    private boolean isCache = false;

    public Set<SignatureLevel> getSignatureLevels(long counterpartyId) {
        if (!isCache) {
            signatureLevels.addAll(getSignatureLevelsByCounterparty(counterpartyId));
            isCache = true;
        }
        return signatureLevels;
    }
}
