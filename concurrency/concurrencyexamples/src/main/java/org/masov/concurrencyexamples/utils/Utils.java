package org.masov.concurrencyexamples.utils;

public class Utils {

    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException)
            return (RuntimeException) t;
        else if (t instanceof Error)
            throw (Error) t;
        else
            throw new IllegalStateException("No being checked exception", t);
    }
}
