package cn.tom.dao;

import cn.tom.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@Mapper  //把接口产生的对象 put  到 IOC  容器
public interface CourseDao {
    @Select("select * from t_course")
    public List<Map<String, Object>> findAll();

    @Select("select cno, cname, tid from t_course")
    public List<Course> findAll2();
    /*
     private String cno;
     private String cname;
     private String tid;
     */
//  查找单条
    @Select("select cno, cname, tid from t_course where cno=#{id}")
    public Map<String, Object> findByID(String id);

    @Select("select cno, cname, tid from t_course where cno=#{id}")
    public Course findByID2(String id);

 //模糊查找  where cname like 'java%'  java开始
 // 模糊查找  where cname like '%java%'  含有java
    @Select("select cno, cname, tid from t_course where cname like #{name}")
    public List<Map<String, Object>> findLikeByCname(String name);

    @Select("select cno, cname, tid from t_course where cname like #{name}")
    public List<Course> findLikeByCname2(String name);
//  分页查 limit n1, n2  n1 开始行， n2 取几行   n1 从 1 开始
    @Select("select cno, cname, tid from t_course limit #{nn1}, #{nn2}")
    public List<Course> findPage(Map<String, Object> m);
    /*
       key  nn1   开始
       key  nn2   结束
     */
// 聚合查询  count()  max() min()  avg() sum()
   @Select("select count(*) from t_course")
   public int getCount();  //表的记录数

}
