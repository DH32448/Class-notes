package cn.tom.dao;

import cn.tom.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

//TeacherMapper  ---> mapper/TeacherMapper.xml
import java.util.*;
@Mapper
public interface TeacherMapper {
    public cn.tom.entity.Teacher findById(int tid);
    //     resultType               parmeterType
    public List<Teacher> findAll();
    public Map<String, Object> findById2(int tid);
    public int update(Teacher t);
    public int del(int tid);
    //这个 更新的行数， 无需写返回值类型

}
