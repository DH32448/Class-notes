package cn.tom;

import cn.tom.dao.TeacherMapper;
import cn.tom.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class TestTeacherMapper {
// 从 IOC 容器 TeacherMapper 类型对象
    @Autowired
    TeacherMapper teacherMapper;

    @Test
    void findALl() {
        System.out.println(teacherMapper.findAll());
    }

    @Test
    void add() {
        for(int i=0; i<10; i++) {
            Teacher t = new Teacher();
            t.setTname("测试老师" + i);
            t.setPhone("13800" + i);
            t.setBirthDay(new Date());
            t.setPwd("222"+ i);
            t.setSalary(9999.0 -i);
            int ret = teacherMapper.add(t);
            System.out.println("ret=" + ret);
        }
    }
    @Test
    void addKey() {
         int i= 22;
        Teacher t = new Teacher();
        t.setTname("测试老师" + i);
        t.setPhone("13800" + i);
        t.setBirthDay(new Date());
        t.setPwd("222"+ i);
        t.setSalary(9999.0 -i);
        System.out.println(t);
        int ret = teacherMapper.add(t);
        System.out.println(t);

    }

    @Test
    void findPage() {
        Map<String, Integer> m = new HashMap<>();
        int pagenum = 3;  //页数
        int pageline = 5;  //行数

        m.put("startnum",(pagenum-1)*pageline);
        m.put("pageline", pageline );
        List<Teacher> page = teacherMapper.findPage(m);
        System.out.println(page);
    }
}
