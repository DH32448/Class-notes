package cn.tom.dao;

import cn.tom.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.*;
// 生产对象， 放在 IOC 容器
@Mapper
public interface TeacherDao {
    //别名使用  ， Camel 骆驼峰 和 _
    @Select("Select tid,tname name,phone," +
            "pwd,birth_day, salary from t_teacher")
    public List<Teacher> findALl();

    //添加, 自动增长主键
    @Insert("insert into t_teacher(tname,phone,pwd,birth_day,salary) " +
                                     //表的字段名
            "values (#{name},#{phone}, #{pwd}, #{birthDay}, #{salary})")
                  // 对象 t 的成员变量名称
    public int add(Teacher t);

    //添加, 自动增长主键
    @Insert("insert into t_teacher(tname,phone,pwd,birth_day,salary) " +
            //表的字段名
            "values (#{name},#{phone}, #{pwd}, #{birthDay}, #{salary})")
    // 对象 t 的成员变量名称
    public int add2(Map<String, Object> map);
    /*
       map.put("name",  "开老师");
       map.put("phone",  "135101");
       map.put("pwd",  "111");
       map.put("birthDay",   new Date());
       map.put("salary", 109.99）;
     */

    //@Update
    //@Delete
}
