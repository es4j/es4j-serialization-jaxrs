package jaxrs.examples.client.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.ws.rs.client.Configuration;
import javax.ws.rs.client.Feature;

/**
 *
 * @author Marek Potociar (marek.potociar at oracle.com)
 */
public class CachingFeature implements Feature {

    @Override
    public void onEnable(Configuration configuration) {
        if (setEnabledFlag(configuration, true)) {
            return;
        }

        final Map<String, CacheEntry> cacheStore = new ConcurrentHashMap<String, CacheEntry>();
        final AtomicBoolean flag = new AtomicBoolean(true);
        configuration
                .register(new CacheEntryLocator(cacheStore, flag))
                .register(new CacheResponseFilter(cacheStore, flag));
    }

    @Override
    public void onDisable(Configuration configuration) {
        setEnabledFlag(configuration, false);
    }

    private boolean setEnabledFlag(Configuration configuration, boolean value) {
        for (Object provider : configuration.getProviderInstances()) {
            if (provider instanceof CacheEntryLocator) {
                CacheEntryLocator.class.cast(provider).enabledFlag.set(value);
                return true;
            } else if (provider instanceof CacheResponseFilter) {
                CacheResponseFilter.class.cast(provider).enabledFlag.set(value);
                return true;
            }
        }
        return false;
    }
}
