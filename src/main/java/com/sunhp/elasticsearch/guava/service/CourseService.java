package com.sunhp.elasticsearch.guava.service;

import com.sunhp.elasticsearch.guava.entity.Course;
import com.sunhp.elasticsearch.guava.mapper.CourseMapper;
import com.sunhp.elasticsearch.guava.utils.GuavaCacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseService {

    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    @Resource
    private CourseMapper courseMapper;

    public List<Course> selectCourse(){
        List<Course> courseList = courseMapper.selectCourse();
        logger.info("==={}",courseList.toString());
        return courseList;
    }
}
