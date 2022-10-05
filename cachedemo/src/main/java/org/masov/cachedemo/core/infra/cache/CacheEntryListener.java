package org.masov.cachedemo.core.infra.cache;

import lombok.extern.slf4j.Slf4j;


import javax.cache.event.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Slf4j
public class CacheEntryListener implements
        CacheEntryCreatedListener<Long, BigDecimal>,
        CacheEntryUpdatedListener<Long, BigDecimal>,
        CacheEntryExpiredListener<Long, BigDecimal>,
        CacheEntryRemovedListener<Long, BigDecimal>,
        Serializable {


    public void onUpdated(
            Iterable<CacheEntryEvent<? extends Long,
                    ? extends BigDecimal>> events) throws CacheEntryListenerException {
            for(var event: events) {
                log.info("cache entry update. key: " + event.getKey() + " value: " + event.getValue());
            }
    }

    public void onCreated(
            Iterable<CacheEntryEvent<? extends Long,
                    ? extends BigDecimal>> events) throws CacheEntryListenerException {
        for(var event: events) {
            log.info("cache entry create. key: " + event.getKey() + " value: " + event.getValue());
        }

    }

    @Override
    public void onExpired(Iterable<CacheEntryEvent<? extends Long, ? extends BigDecimal>> events) throws CacheEntryListenerException {
        for(var event: events) {
            log.info("cache entry expired. key: " + event.getKey() + " value: " + event.getValue());
        }
    }

    @Override
    public void onRemoved(Iterable<CacheEntryEvent<? extends Long, ? extends BigDecimal>> events) throws CacheEntryListenerException {
        for(var event: events) {
            log.info("cache entry removed. key: " + event.getKey() + " value: " + event.getValue());
        }
    }
}
