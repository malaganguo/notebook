package com.mmall.concurrency.example;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
public class AtomicIntegerFieldUpdaterExample {
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterExample> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterExample.class, "count");

    @Getter
    private volatile int count = 100;

    public static void main(String[] args) throws Exception {
        AtomicIntegerFieldUpdaterExample example =
                (AtomicIntegerFieldUpdaterExample) Class.forName("com.mmall.concurrency.example.AtomicIntegerFieldUpdaterExample").newInstance();
        if(updater.compareAndSet(example, 100, 120))
            log.info("update success 1, {}", example.getCount());

        if(updater.compareAndSet(example, 100, 120))
            log.info("update success 2, {}", example.getCount());
        else
            log.info("update failed, {}", example.getCount());
    }
}
