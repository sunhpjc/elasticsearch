package com.sunhp.elasticsearch.guava.mapper;

import com.sunhp.elasticsearch.guava.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> selectCourse();
}
