package cn.tom.dao;

import cn.tom.entity.Clz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper  根据接口及 SQL 及方法， 自动创建出 实现类（代理）， 创建出对象放在 IOC 容器里面
@Mapper
public interface ClzDao {
    @Select("select * from t_clz")
    public List<Clz> findAll();
}
