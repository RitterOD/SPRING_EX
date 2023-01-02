package org.masov.concurrencyexamples.customthreadfactory;

import java.util.concurrent.ThreadFactory;

public class DebugThreadFactory implements ThreadFactory {
    private final String poolName;

    public DebugThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new AppThread(r, poolName);
    }
}
