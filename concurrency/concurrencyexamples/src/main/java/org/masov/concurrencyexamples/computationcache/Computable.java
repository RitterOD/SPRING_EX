package org.masov.concurrencyexamples.computationcache;

public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
