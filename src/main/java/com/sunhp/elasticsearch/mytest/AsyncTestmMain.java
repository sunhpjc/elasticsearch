package com.sunhp.elasticsearch.mytest;

import com.sunhp.elasticsearch.mytest.async.AsyncFactory;
import com.sunhp.elasticsearch.mytest.async.AsyncInterface;
import com.sunhp.elasticsearch.mytest.async.AsyncInterfaceFive;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static ch.qos.logback.core.CoreConstants.CORE_POOL_SIZE;

/**
 * @author sunhp
 * @Description
 * @Date 2020/12/7 14:52
 **/
@Component
@EnableScheduling
@EnableAsync(proxyTargetClass = true)
public class AsyncTestmMain {
    private static final long COUNT = 10000;

    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 20;
    private static final Long KEEP_ALIVE_TIME = 1L;

    @Resource
    private AsyncFactory asyncFactory;
/*    @Resource
    private Async1TestService async1TestService;
    @Resource
    private Async2TestService async2TestService;
    @Resource
    private Async3TestService async3TestService;
    @Resource
    private Async4TestService async4TestService;
    @Resource
    private Async5TestService async5TestService;*/

    @Resource
    private AsyncInterfaceFive asyncInterfaceFive;

    @Scheduled(cron = "0/5 * * * * ?")
    public void asyncTest(){
        List<String> list = new ArrayList<>();
        list.add("async1");
        list.add("async2");
        list.add("async3");
        list.add("async4");
        list.add("async5");

        for (String str : list
             ) {
            AsyncInterface asyncInterface = asyncFactory.get(str);
            asyncInterface.myTest();
        }

/*        AsyncInterface asyncInterface1 = asyncFactory.get("async1");
        AsyncInterface asyncInterface2 = asyncFactory.get("async2");
        AsyncInterface asyncInterface3 = asyncFactory.get("async3");
        AsyncInterface asyncInterface4 = asyncFactory.get("async4");
        AsyncInterface asyncInterface5 = asyncFactory.get("async5");*/

/*        asyncInterface1.myTest();
        asyncInterface2.myTest();
        asyncInterface3.myTest();
        asyncInterface4.myTest();
        asyncInterface5.myTest();*/
/*        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        executor.execute(()->{
            asyncInterface1.myTest();
            asyncInterface2.myTest();
            asyncInterface3.myTest();
            asyncInterface4.myTest();
            asyncInterface5.myTest();
        });*/


/*        async1TestService.myTest();
        async2TestService.myTest();
        async3TestService.myTest();
        async4TestService.myTest();
        async5TestService.myTest();*/

//        asyncInterfaceFive.myTest1();
//        asyncInterfaceFive.myTest2();
//        asyncInterfaceFive.myTest3();
//        asyncInterfaceFive.myTest4();
//        asyncInterfaceFive.myTest5();

        long a = 0;
        long b = 0;
        long c = 0;
        long d = 0;
        for (int i = 0; i < COUNT; i++) {
            a += 5;
            b += 5;
            c += 5;
            d += 5;
            System.out.println("主线程定时任务执行："+Thread.currentThread().getName() + "id:" + i);
        }

//        for (int i = 0; i < COUNT; i++) {
//            a -= 3;
//            b -= 3;
//            c -= 3;
//            d -= 3;
//            System.out.println("主线程定时任务执行："+Thread.currentThread().getName() + "id:" + (i+10000));
//        }
    }
}
