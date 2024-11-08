package cn.tom.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;
@Mapper
public interface CourseDao {
    @Select("select * from t_course")
    public List<Map<String, Object>> findAll();
}
