package com.sunhp.elasticsearch.thread.service;

import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @author
 * @Description
 * @Date
 **/
@Service
public class TestMethod {
    public void test1(){
        System.out.println("CurrentThread name:" + Thread.currentThread().getName() + "date：" + Instant.now());
    }
}
