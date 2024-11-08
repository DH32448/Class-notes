package cn.tom.dao;

import cn.tom.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

//@Mapper  根据接口及 SQL 及方法
// 自动创建出 实现类（代理）， 创建出对象放在 IOC 容器里面
@Mapper
public interface CourseMapper {
    public List<Course> findAll();
    public Course findOne(String no);
    public List<Map<String, Object>> findInfo();
    public int  add(Course c);
    public int add2(Map<String, Object> map);
    public int updateByNo(Map<String, Object>  m);
}
