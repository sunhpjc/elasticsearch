package com.sunhp.elasticsearch.mytest;

/**
 * @author sunhp
 * @Description
 * @Date 2020/12/7 14:18
 **/
public class ConcurrencyTest {
    private static final long count = 10000000;

    public static void main(String[] args) {
        try {
            concurrency();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++)
                {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++)
        {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency : " + time + "ms,b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++)
        {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++)
        {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial : " + time + "ms,b=" + b);
    }
}
