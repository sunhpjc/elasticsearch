package com.sunhp.elasticsearch.mytest.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author sunhp
 * @Description
 * @Date 2020/12/7 15:02
 **/
@Service
public class Async2TestService implements AsyncInterface {
    @Async
    @Override
    public void myTest() {
        for (int i = 0; i < 100; i++) {
            System.out.println("异步执行2"+Thread.currentThread().getName()+ "id:" + i);
        }
    }
}
