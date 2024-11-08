package cn.tom.dao;

import cn.tom.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;
@Mapper
public interface TeacherMapper {
    public List<Teacher> findAll();
    public int update(Teacher teacher);
    public int add(Teacher teacher);
    public int remove(int tid);
    public Teacher findOneIf(Map<String, Object> map);
}
