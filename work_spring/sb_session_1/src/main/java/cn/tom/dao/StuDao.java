package cn.tom.dao;

import cn.tom.entity.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StuDao {
    @Select("select sno,phone, sname, pwd " +
            "from t_student where phone=#{x}")
    public Stu findOneByPhone(String phone);
}
