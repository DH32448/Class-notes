package cn.tom.dao;

import cn.tom.entity.Clz;
import cn.tom.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    public List<Course> findAll();
    public int add(Course c);
    public int update(Course  c);
    public int remove(String cno);
    public Course findOne(String cno);
}
