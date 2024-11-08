package cn.tom;

import cn.tom.dao.TeacherMapper;
import cn.tom.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestTeacherMapper {
    @Autowired
    TeacherMapper teacherMapper;

    @Test
    void findById() {
        Teacher t = teacherMapper.findById(20001);
        System.out.println(t);
    }

}
