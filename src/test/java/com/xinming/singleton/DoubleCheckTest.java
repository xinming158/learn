package com.xinming.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

public class DoubleCheckTest {

    @Test
    public void test() throws InterruptedException {
        final List<DoubleCheck> instances = new CopyOnWriteArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 10; i++) {
            Future<?> submit = executor.submit(new Runnable() {
                @Override
                public void run() {
                    DoubleCheck instance = DoubleCheck.getInstance();
                    instances.add(instance);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        boolean eq = true;
        DoubleCheck last = instances.get(0);
        for (int i = 1; i < instances.size(); i++) {
            if (last != instances.get(i)) {
                System.out.println(last + "   " + instances.get(i));
                eq = false;
                break;
            }
        }
        Assert.assertTrue(eq);
    }
}
