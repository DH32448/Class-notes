package cn.tom.demo;


import cn.tom.entity.Clz;
import cn.tom.entity.Course;
import cn.tom.entity.User;

public class DemoClone {
    public static void main(String[] args) {

        Clz c = new Clz();
        c.setClzno("119");
        c.setClzname("119班");

        //正常拷贝， 浅拷贝
        Clz  c2 =   new Clz();
        c2.setClzno(c.getClzno());
        c2.setClzname(c.getClzname());



        Clz  c3 =   new Clz();
        c2.setClzno(c.getClzno());
        c2.setClzname(c.getClzname());


        Course course = new Course();
        course.setCno("C00");
        course.setCname("MYSQL");

        // 拷贝一个对象  course  ---> course2
    }
     private static void copy( Clz x) {
        x.setClzname("999班");
     }
}
