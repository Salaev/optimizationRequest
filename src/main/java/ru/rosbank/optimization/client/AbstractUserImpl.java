package ru.rosbank.optimization.client;

import lombok.extern.slf4j.Slf4j;
import ru.rosbank.optimization.models.entity.SignatureLevel;

import java.util.Set;

@Slf4j
public abstract class AbstractUserImpl implements UserApi {

    protected Set<SignatureLevel> getSignatureLevelsByCounterparty(long counterpartyId) {
        log.info("getSignatureLevels: " + this.hashCode());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Set.of(SignatureLevel.values());
    }
}
