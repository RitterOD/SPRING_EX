package org.masov.cachedemo.core.configuration;


import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.masov.cachedemo.core.infra.cache.CacheEntryListener;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.spi.CachingProvider;
import java.math.BigDecimal;
import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfiguration {


    @Bean
    public CacheManager ehCacheManager() {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();

        CacheConfigurationBuilder<Long, BigDecimal> configuration =
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                                Long.class,
                                BigDecimal.class,
                                ResourcePoolsBuilder
                                        .newResourcePoolsBuilder().offheap(1, MemoryUnit.MB))
                        .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(20)));

        javax.cache.configuration.Configuration<Long, BigDecimal> longBigDecimalConfiguration =
                Eh107Configuration.fromEhcacheCacheConfiguration(configuration);
        //longBigDecimalConfiguration
        var rv = cacheManager.createCache("squareCache", longBigDecimalConfiguration);
        var listenerConfiguration
                = new MutableCacheEntryListenerConfiguration<Long, BigDecimal>(
                FactoryBuilder.factoryOf(new CacheEntryListener()), null, false, true);
        rv.registerCacheEntryListener(listenerConfiguration);
        return cacheManager;
    }
}