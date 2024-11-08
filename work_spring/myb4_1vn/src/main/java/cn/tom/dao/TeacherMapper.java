package cn.tom.dao;

import cn.tom.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TeacherMapper {
    List<Teacher> findAll();
}
