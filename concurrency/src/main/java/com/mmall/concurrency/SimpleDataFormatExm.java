package com.mmall.concurrency;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SimpleDataFormatExm {

    private static int clientTotal = 5000;

    private static int threadTotal = 200;

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) throws Exception{
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch count = new CountDownLatch(clientTotal);
        long start = System.currentTimeMillis();
        for (int i = 0; i < clientTotal; i++) {
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    format();
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

    private synchronized static void format() {
        try {
            sdf.parse("20191121");
        } catch (ParseException e) {
            log.error("parse error, {}", e.getMessage());
        }
    }
}
