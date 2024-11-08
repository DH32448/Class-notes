package cn.tom;

import cn.tom.dao.TeacherDao;
import cn.tom.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestTeacherDao {
    //取出对象去消费
    @Autowired
    TeacherDao teacherDao;
    @Test
    void findAll() {
        System.out.println(teacherDao);

        List<Teacher> aLl = teacherDao.findALl();
        System.out.println(aLl);
    }

}
