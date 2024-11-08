package cn.tom.dao;

import cn.tom.entity.Clz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClzMapper {
    public List<Clz> findAll();
    public int add(Clz clz);
    public int update(Clz  clz);
    public int remove(String clzno);
    public Clz findOne(String clzno);
}
