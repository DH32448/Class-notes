package cn.tom.mb1.entity;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import java.util.List;
@Mapper //把ClzDao的实现类的对象 保存到IOC容器
public interface ClzDao {
    @Select("select * from t_clz")
    public List<Map<String,Object>> findAll();
    @Insert("Insert into t_clz(clzno,clzname) values(#{clzno},#{clzname})")
    public int add2(Map<String,Object> map);
//        Map<String,Object> m = new HashMap<>();
//        m.put("clzno","211");
//        m.put("clzname","3115");
//        clzDao.add(m);
    @Delete("delete form t_clz where clzno =#{clzno} ")
    public int delete(String clzno);
}
