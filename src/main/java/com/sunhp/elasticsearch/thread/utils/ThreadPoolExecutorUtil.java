package com.sunhp.elasticsearch.thread.utils;

/**
 * @author
 * @Description
 * @Date
 **/
public class ThreadPoolExecutorUtil {
    private volatile static ThreadPoolExecutorUtil threadPoolExecutorUtil;
    private ThreadPoolExecutorUtil(){}

    public static ThreadPoolExecutorUtil getExecutor(){
        if(threadPoolExecutorUtil == null){
            synchronized (ThreadPoolExecutorUtil.class){
                if(threadPoolExecutorUtil == null){
                    threadPoolExecutorUtil = new ThreadPoolExecutorUtil();
                }
            }
        }
        return threadPoolExecutorUtil;
    }

}
