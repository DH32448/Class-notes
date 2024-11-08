package cn.tom;

import cn.tom.dao.CourseMapper;
import cn.tom.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test1v1 {

    @Autowired
    CourseMapper courseMapper;
    @Test
    void findAll() {

        List<Course> all = courseMapper.findAll2();
        for(Course c :all) {

            System.out.println(c);
        }

    }
}
