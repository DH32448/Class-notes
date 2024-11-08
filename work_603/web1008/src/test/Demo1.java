package test;


import cn.tom.dao.CourseDao;
import cn.tom.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) throws Exception{
        System.out.println("Demo1");
        System.out.println("查询");
        CourseDao courseDao = new CourseDao();
        System.out.println(courseDao.findAll());

        Course c = new Course();
        c.setCid(2);
        c.setCname("2课程");
        c.setScore(10);
        courseDao.update(c);
    }
}
