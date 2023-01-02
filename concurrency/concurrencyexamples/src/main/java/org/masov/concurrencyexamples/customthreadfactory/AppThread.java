package org.masov.concurrencyexamples.customthreadfactory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AppThread extends Thread{

    private static final String DEFAULT_NAME = "AppThread";
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static volatile boolean debugLifecycle = false;

    public AppThread(Runnable target) {
        this(target, DEFAULT_NAME);
    }
    public AppThread(Runnable target, String name) {
        super(target, name +"-" + created.incrementAndGet());
        setUncaughtExceptionHandler((t, e) -> log.info("In thread " + t.getName() + "was not caught exception", e));
    }

    @Override
    public void run() {
        boolean debug = debugLifecycle;
        if (debug) {
            log.info("Created: " + getName());
        }
        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) {
                log.info("Finishing: " + getName());
            }
        }
    }
    public static  int getThreadsCreated() { return created.get(); }
    public static int getThreadsAlive() { return alive.get(); }
    public static boolean getDebug() { return debugLifecycle; }
    public static  void setDebug(boolean b) { debugLifecycle = b; }
}
