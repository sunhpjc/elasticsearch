package com.sunhp.elasticsearch.thread.test;

import com.sunhp.elasticsearch.thread.service.ThreadPoolService;

/**
 * @author
 * @Description
 * @Date
 **/
public class TestMain {
    public static void main(String[] args) {
        ThreadPoolService threadPoolService = new ThreadPoolService();
        threadPoolService.test();
    }
}
