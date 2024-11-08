package cn.tom.dao;

import cn.tom.entity.TaskInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {
    public List<TaskInfo> findAll();
    public List<TaskInfo> findByClzno(String clzno);
    public List<TaskInfo> findByTid(int tid);
    public int  add(TaskInfo task);
    public int remove(int kid);
}
