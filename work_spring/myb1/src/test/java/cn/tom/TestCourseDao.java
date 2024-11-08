package cn.tom;

import cn.tom.dao.CourseDao;
import cn.tom.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest  //测试
class TestCourseDao {

    @Autowired  //按照类型（向上转型）从 IOC 容器取出
    CourseDao courseDao;

    @Test
    void findAll() {
        System.out.println(courseDao);
        List<Map<String, Object>> all = courseDao.findAll();
        //System.out.println(all);
        for(Map<String, Object> m : all) {
            System.out.print(m.get("cno"));
            System.out.print("\t"+ m.get("cname"));
            System.out.println("\t" + m.get("tid"));
        }
    }
    @Test
    void findAll2() {
        System.out.println(courseDao);
        List<Course> all = courseDao.findAll2();
        //System.out.println(all);
        for( Course m : all) {
            System.out.print(m.getCno());
            System.out.print("\t"+ m.getCname());
            System.out.println("\t" + m.getTid());
        }
    }
    @Test
    void findLineByCname2() {
        String name="Java"; //网页传递过来

        name= name + "%";

        List<Course> lst = courseDao.findLikeByCname2(name);

        System.out.println(lst);
    }

    @Test
    void findPage() {
        int n1=2;
        int n2=4;
        Map<String,Object> map = new HashMap<>();
        map.put("nn1", n1);
        map.put("nn2", n2);
        List<Course> lst = courseDao.findPage( map );

        System.out.println(lst);
    }
}
