package cn.tom.dao;

import cn.tom.entity.Mark;
import cn.tom.entity.MarkInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

@Mapper
public interface MarkMapper {
    //查询某个学生某一门课程的分数
    public Mark findBySnoCno(Map<String, Object> map);
    //查询某个学生所有课程的分数
    public List<MarkInfo> findBySno(String sno);
    //更新分数， 根据主键 t_mark.id >0
    public int update(Mark mark);
    //添加分数， 根据主键 t_mark.id ==0
    public int add(Mark mark);
}
