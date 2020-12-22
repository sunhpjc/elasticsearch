package com.sunhp.elasticsearch.guava.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sunhp.elasticsearch.config.SpringContextUtil;
import com.sunhp.elasticsearch.guava.entity.Course;
import com.sunhp.elasticsearch.guava.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component(value = "guavaUtil")
public class GuavaCacheUtil {
    private static final Logger logger = LoggerFactory.getLogger(GuavaCacheUtil.class);

    @Resource
    private CourseService courseService;

    public LoadingCache buildCache(){
        List<Course> courseList = courseService.selectCourse();

        LoadingCache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(100) // 设置缓存的最大容量
                .refreshAfterWrite(20,TimeUnit.SECONDS)// 设置缓存在写入20秒后刷新，通过CacheLoader的load方法进行刷新
                .concurrencyLevel(10)// 设置并发级别为10
                .recordStats()// 开启缓存统计
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        for (Course course : courseList){
                            if(key.equals(course.getCourseId())){
                                return course.getCourseName();
                            }
                        }
                        return null;
                    }
                });
        if(cache != null){
            return cache;
        }
        else {
            return null;
        }
    }

    public static String getGuavaValue(String key){
        GuavaCacheUtil guavaUtil = SpringContextUtil.getBean("guavaUtil", GuavaCacheUtil.class);
        LoadingCache<String,String> cache = guavaUtil.buildCache();

        if(cache != null){
            String value = null;
            try {
                value = cache.get(key);
            } catch (ExecutionException e) {
                logger.error("获取缓存异常，{}",e);
            }
            return value;
        }
        else {
            logger.info("cache为null");
            return null;
        }
    }
}
