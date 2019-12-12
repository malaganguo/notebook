package com.mmall.concurrency.example;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@ThreadSafe
public class AtomicBooleanExample {
    //请求数
    public static int clientTotal = 5000;
    //并发数
    public static int threadTotal = 200;

    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);//信号量
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0;i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception:" + e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();//等待闭锁减为0
        executorService.shutdown();
        log.info("isHappened:{}", isHappened);
    }

    private static void test() {
        if (isHappened.compareAndSet(false, true))
            log.info("execute");
    }
}
