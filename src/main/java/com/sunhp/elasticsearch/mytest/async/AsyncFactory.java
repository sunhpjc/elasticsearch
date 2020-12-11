package com.sunhp.elasticsearch.mytest.async;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author sunhp
 * @Description
 * @Date 2020/12/7 16:16
 **/
@Component
public class AsyncFactory {
    @Resource(name = "async1TestService")
    private Async1TestService async1TestService;
    @Resource(name = "async2TestService")
    private Async2TestService async2TestService;
    @Resource(name = "async3TestService")
    private Async3TestService async3TestService;
    @Resource(name = "async4TestService")
    private Async4TestService async4TestService;
    @Resource(name = "async5TestService")
    private Async5TestService async5TestService;

    public AsyncInterface get(String key){
        if(key.equals("async1")){
            return async1TestService;
        }
        else if(key.equals("async2")){
            return async2TestService;
        }
        else if(key.equals("async3")){
            return async3TestService;
        }
        else if(key.equals("async4")){
            return async4TestService;
        }
        else {
            return async5TestService;
        }
    }
}
