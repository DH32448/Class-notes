package cn.tom.dao;

import org.apache.ibatis.annotations.*;

import java.util.*;
//@Mapper  //把 ClzDao 的实现类的对象 保存到 IOC 容器
public interface ClzDao {
    @Select("select * from t_clz")
    public List<Map<String,Object>> findAll();

//    @Insert("Insert into t_clz(clzno, clzname) values(#{clzno}, #{clzname})")
//    public int add(Clz c);

    @Insert("Insert into t_clz(clzno, clzname) values(#{clzno}, #{clzname})")
    public int add2(Map<String, Object> m);

    /**
     *  Map<String,Object> m = new HashMap();
     *  m.put("clzno", "211");
     *  m.put("clzname", "211班");
     *  clzDao.add2(m);
     */


    @Update("update t_clz set clzname=#{clzname} where clzno=#{clzno}")
    public int update(Map<String, Object> m);

    /**
     *  Map<String,Object> m = new HashMap();
     *  m.put("clzno", "211");
     *  m.put("clzname", "211班22");
     *  clzDao.update(m);
     */

    @Delete("delete from t_clz where clzno=#{clzno}")
    public int delete(String clzno);

    /**
     *  clzDao.delete("211");
     */



}
