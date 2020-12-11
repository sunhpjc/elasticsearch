package com.sunhp.elasticsearch.thread.service;

import com.sunhp.elasticsearch.thread.utils.ThreadPoolExecutorUtil1;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author
 * @Description
 * @Date
 **/
@Service
public class ThreadPoolService {
    private static ThreadPoolService threadPoolService;
    @Resource
    private TestMethod testMethod;

    public void test(){
        ThreadPoolExecutor instance = ThreadPoolExecutorUtil1.getInstance();
        System.out.println("开始时间："+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
        for (int i = 0; i < 10; i++) {
            instance.execute(()->{
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("CurrentThread name:" + Thread.currentThread().getName() + "date：" + Instant.now());
                testMethod.test1();
            });
        }
        System.out.println("结束时间："+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
    }
}
