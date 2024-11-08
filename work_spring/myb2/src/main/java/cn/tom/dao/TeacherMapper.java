package cn.tom.dao;

import cn.tom.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;
@Mapper  //将这个 TeacherMapper 类型对象 put 到 IOC 容器
public interface TeacherMapper {
    public List<Map<String, Object>> findAll();
//  多个参数优先考虑走 Map， 如果有实体类走实体类

    //add
    public int add(Teacher t);
    //    分页Map  startnum 起始行  pageline 每页几行
    List<Teacher> findPage(Map<String, Integer> map);


//    分页  startnum 起始行  pageline 每页几行
    List<Teacher> findPage2(@Param("n1") int startnum,
                            @Param("n2") int pageline);


}
