package com.sunhp.elasticsearch.mytest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static ch.qos.logback.core.CoreConstants.CORE_POOL_SIZE;

/**
 * @author sunhp
 * @Description
 * @Date 2020/12/7 10:32
 **/
public class TestPoll {
//    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 20;
    private static final Long KEEP_ALIVE_TIME = 1L;

    private static final Long COUNT = 100000000000L;

    public void test(){
        serial();
        concurrency();


//        executor.execute(()->{
//            System.out.println("===线程名："+Thread.currentThread().getName());
//        });
//        executor.execute(()->{
//            System.out.println("===线程名："+Thread.currentThread().getName());
//        });
//        executor.execute(()->{
//            System.out.println("===线程名："+Thread.currentThread().getName());
//        });
//        executor.execute(()->{
//            System.out.println("===线程名："+Thread.currentThread().getName());
//        });
    }

    public void serial(){
        long start = System.currentTimeMillis();

        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += 5;
        }

        long b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        long time = System.currentTimeMillis()-start;
        System.out.println("串行耗时："+ time);
    }

    public void concurrency(){
        long start = System.currentTimeMillis();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        executor.execute(()->{
            long a = 0;
            for (long i = 0; i < COUNT; i++) {
                a += 5;
            }

            long b = 0;
            for (long i = 0; i < COUNT; i++) {
                b--;
            }
            long time = System.currentTimeMillis()-start;
            System.out.println("并行耗时："+ time);
        });
    }

    public static void main(String[] args) {
//        TestPoll testPoll = new TestPoll();
//        testPoll.test();
        String str = "A";
        switch (str){
            case "A":
                for (int i = 0; i < 3; i++) {
                    System.out.println("测试"+i);
                }
                break;
            default:
                System.out.println("默认");
                break;
        }
    }
}
