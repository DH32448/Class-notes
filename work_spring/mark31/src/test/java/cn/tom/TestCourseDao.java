package cn.tom;

import cn.tom.dao.CourseMapper;
import cn.tom.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestCourseDao {
    @Autowired
    CourseMapper mapper; //从 IOC 容器取出CourseMapper 这个类型对象

    @Test
    public void test1() {
        System.out.println("Test1......");
        List<Course> all = mapper.findAll();
        for(Course c : all) System.out.println(c);
    }
    @Test
    public void testFindAll() {
        List<Course> all = mapper.findAll();
        for(Course c : all) System.out.println(c);
    }
    @Test
    public void testFindOne() {
        Course one = mapper.findOne("005");
        System.out.println("one 005=" + one);
        one = mapper.findOne("A01");
        System.out.println("one A01=" + one);
    }
    @Test
    public void testFindInfo() {
        List<Map<String, Object>> infos = mapper.findInfo();
        for(Map<String, Object> m : infos) System.out.println(m);
    }

    @Test
    public void testAdd() {
        Course course = new Course();
        course.setCno("Q11");
        course.setCname("Python课程");
        course.setTid(2002);
        int ret = mapper.add(course); //受到影响的记录有几条
        System.out.println("ret=" + ret);
    }
    @Test
    public void testAdd2() {
        Map<String, Object> map = new HashMap<>();
        map.put("no", "M11");
        map.put("name", "HTML课程");
        map.put("tid", 2009);
        int ret = mapper.add2(map); //受到影响的记录有几条
        System.out.println("ret=" + ret);
    }
    @Test
    public void testUpdate() {
        System.out.println("更新");
        Map<String, Object> map = new HashMap<>();
        map.put("no", "M11");
        map.put("name", "Css3课程");
        map.put("tid", 2011);
        int ret = mapper.updateByNo(map); //受到影响的记录有几条
        System.out.println("ret=" + ret);
    }
}
