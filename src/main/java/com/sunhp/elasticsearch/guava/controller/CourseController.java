package com.sunhp.elasticsearch.guava.controller;

import com.sunhp.elasticsearch.guava.entity.Course;
import com.sunhp.elasticsearch.guava.service.CourseService;
import com.sunhp.elasticsearch.guava.utils.GuavaCacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Resource
    private CourseService courseService;

    @GetMapping(value = "/selectCourse")
    public List<Course> selectCourse(){
        return courseService.selectCourse();
    }

    @GetMapping(value = "/guava/selectCourse")
    public String selectGuava(){
        String key = "1";
        String value = GuavaCacheUtil.getGuavaValue(key);
        return value;
    }

    @GetMapping(value = "/test")
    public String test(){
        logger.info("测试");
        return "测试";
    }
}
