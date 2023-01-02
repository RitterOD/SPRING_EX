package org.masov.concurrencyexamples.computationcache;

import org.thymeleaf.spring6.util.FieldUtils;

import java.util.Map;
import java.util.concurrent.*;

import static org.masov.concurrencyexamples.utils.Utils.launderThrowable;

public class ComputationCache<A,V> implements Computable<A,V>{
    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A,V> function;

    public ComputationCache(Computable<A, V> function) {
        this.function = function;
    }


    @Override
    public V compute(final A arg) throws InterruptedException {
        while (true){
            Future<V> f = cache.get(arg);
            if(f == null) {
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return function.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<>(eval);
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {f = ft; ft.run();}
            }
            try {
                return f.get();
            }
            catch (CancellationException e ){
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                throw launderThrowable(e.getCause());
            }
        }
    }
}
