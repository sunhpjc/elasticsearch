package com.sunhp.elasticsearch.mytest.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author sunhp
 * @Description
 * @Date 2020/12/7 16:08
 **/
public interface AsyncInterface {
    void myTest();
}
