package cn.tom;

import cn.tom.dao.TeacherMapper;
import cn.tom.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Myb41vnApplicationTests {

    @Autowired
    TeacherMapper teacherMapper;
    @Test
    void test() {
        List<Teacher> all = teacherMapper.findAll();
        for(Teacher  t : all) {
            System.out.println(t);
        }
    }

}
