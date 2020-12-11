package com.sunhp.elasticsearch.mytest.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author sunhp
 * @Description
 * @Date 2020/12/7 17:02
 **/
@Service
public class AsyncTestFive implements AsyncInterfaceFive {
    @Async
    @Override
    public void myTest1() {
        for (int i = 0; i < 100; i++) {
            System.out.println("异步执行1"+Thread.currentThread().getName()+ "id:" + i);
        }
    }

    @Async
    @Override
    public void myTest2() {
        for (int i = 0; i < 100; i++) {
            System.out.println("异步执行2"+Thread.currentThread().getName()+ "id:" + i);
        }
    }

    @Async
    @Override
    public void myTest3() {
        for (int i = 0; i < 100; i++) {
            System.out.println("异步执行3"+Thread.currentThread().getName()+ "id:" + i);
        }
    }

    @Async
    @Override
    public void myTest4() {
        for (int i = 0; i < 100; i++) {
            System.out.println("异步执行4"+Thread.currentThread().getName()+ "id:" + i);
        }
    }

    @Async
    @Override
    public void myTest5() {
        for (int i = 0; i < 100; i++) {
            System.out.println("异步执行5"+Thread.currentThread().getName()+ "id:" + i);
        }
    }
}
