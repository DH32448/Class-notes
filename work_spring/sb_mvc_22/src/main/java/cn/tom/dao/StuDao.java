package cn.tom.dao;

import cn.tom.entity.Stu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;
@Mapper
public interface StuDao {
    @Insert("insert into t_stident(sno, sname,phone,imgid) values " +
            "(#{sno}, #{sname},#{phone},#{imgid})")
    public int add(Stu stu);

    @Select("select sno, sname,phone,imgid from t_student")
    public List<Stu> findAll();

    @Select("select sno, sname,phone,imgid from t_student where sno=#{sno}")
    public Stu findById(String sno);

}
