package cn.tom.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClzDao {
    @Select("select * from t_clz")
    public List<Map<String, Object>> findAll();
}
