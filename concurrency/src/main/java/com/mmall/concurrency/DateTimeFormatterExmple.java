package com.mmall.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class DateTimeFormatterExmple {
    private static int clientTotal = 5000;

    private static int threadTotal = 200;

    private volatile static DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) throws Exception{
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch count = new CountDownLatch(clientTotal);
        long start = System.currentTimeMillis();
        for (int i = 0; i < clientTotal; i++) {
            final int c = i;
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    format(c);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("execute error, {}", e.getMessage());
                }
                count.countDown();
            });
        }
        log.info("cast time: {}", System.currentTimeMillis() - start);
        count.await();
        threadPool.shutdown();
    }

    private static void format(int i) {
        try {
            log.info("{}, {}", i, DateTime.parse("20180208", dtf).toDate());
        } catch (Exception e) {
            log.error("parse error, {}", e.getMessage());
        }
    }
}
