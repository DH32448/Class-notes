package cn.tom.dao;

import cn.tom.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface CourseMapper {
    List<Course> findAll();
    List<Course> findAll2();
}
