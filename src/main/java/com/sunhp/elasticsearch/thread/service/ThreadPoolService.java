package com.sunhp.elasticsearch.thread.service;

import com.sunhp.elasticsearch.thread.utils.ThreadPoolExecutorUtil1;

import java.time.Instant;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author
 * @Description
 * @Date
 **/
public class ThreadPoolService {
    public void test(){
        ThreadPoolExecutor instance = ThreadPoolExecutorUtil1.getInstance();
        for (int i = 0; i < 10; i++) {
            instance.execute(()->{
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("CurrentThread name:" + Thread.currentThread().getName() + "date：" + Instant.now());
            });
        }
    }
}
