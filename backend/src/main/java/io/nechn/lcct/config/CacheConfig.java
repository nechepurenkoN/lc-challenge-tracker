package io.nechn.lcct.config;

import java.util.List;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(List.of(
            new ConcurrentMapCache("allTasks"),
            new ConcurrentMapCache("acByUser")
        ));
        return cacheManager;
    }


    @CacheEvict(value = "allTasks", allEntries = true)
    @Scheduled(fixedRateString = "${cache.evict.all.problems}")
    public void evictAllProblemsCache() {}

    @CacheEvict(value = "acByUser", allEntries = true)
    @Scheduled(fixedRateString = "${cache.evict.ac.user}")
    public void evictAllAcByUserCache() {}

}
