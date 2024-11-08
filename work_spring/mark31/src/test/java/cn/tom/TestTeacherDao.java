package cn.tom;

import cn.tom.dao.TeacherMapper;
import cn.tom.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.*;

@SpringBootTest
public class TestTeacherDao {
    @Autowired
    TeacherMapper teacherMapper;

    @Test
    public void testFindAll() {
        List<Teacher> all = teacherMapper.findAll();
        for(Teacher t : all) System.out.println(t);
    }
    @Test
    public void testAdd() {
        Teacher t = new Teacher();
        t.setBirthday( new java.util.Date());
        t.setSalary(7000);
        t.setPwd("199199");
        t.setPhone("199001");
        t.setTname("卢世泉");
        teacherMapper.add(t);
        List<Teacher> all = teacherMapper.findAll();
        for(Teacher t2 : all) System.out.println(t2);
    }
    @Test
    public void testIf() {
       Map<String, Object> m = new HashMap<>();
        m.put("phone", "199001");
        Teacher t = teacherMapper.findOneIf(m);
        System.out.println(t);
        Map<String, Object> m2 = new HashMap<>();
        m2.put("tid", 20003);
        Teacher t2 = teacherMapper.findOneIf(m2);
        System.out.println(t2);
    }
}

