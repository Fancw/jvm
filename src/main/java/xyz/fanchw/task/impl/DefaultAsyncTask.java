package xyz.fanchw.task.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import xyz.fanchw.task.AsyncTask;

import java.util.Random;
import java.util.concurrent.Future;

@Slf4j
@Component
public class DefaultAsyncTask implements AsyncTask {
    private static final String ASYNC_CONFIG = "taskExecutor";
    public static Random random = new Random();

    @Async(ASYNC_CONFIG)
    public void doTaskOne() throws Exception {
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Async(ASYNC_CONFIG)
    public void doTaskTwo() throws Exception {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Async(ASYNC_CONFIG)
    public void doTaskThree() throws Exception {
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
    }

    @Async(ASYNC_CONFIG)
    public Future<String> result() {
        int val = random.nextInt(10000);
        return new AsyncResult<>("" + val);
    }

}
