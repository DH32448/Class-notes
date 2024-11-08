package cn.tom.dao;

import cn.tom.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

@Mapper
public interface StuDao {
    public int add(Student t);
    public Student findOne(String sno);
    public List<Student> findAll();  //工作很少用

    //分页, 避免全部找出来（速度很慢）
    public List<Student> findPage(@Param("curline") int n1,
                                  @Param("lines") int n2);
    //分页， 找出对应条件的总的记录数， 计算页数
    public int getTotal();
}
