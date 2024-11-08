package cn.tom.demo;

import cn.tom.entity.Clz;
import cn.tom.entity.Course;
import cn.tom.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 类对象：  描述 所有数据类型信息  的对象

// 数据类型信息:  名称   成员变量（对象）    方法（对象）
public class Demo1 {
    public static void main(String[] args) {
        // 获取类对象， 类对象的数据类型 Class <?>

        // 第一种方式  获取类对象
        Class c1 = Clz.class;
        Class c2 = Course.class;
        Class c3 = User.class;

       showFileds(c3);
       showMethods(c3);

    }

    //c1, c2 , c3
    private static void showFileds(  Class<?>   c     ) {
        System.out.println("===============获取名称=================");
        System.out.println(c.getSimpleName());  //类名称
        System.out.println(c.getName());      //全称
        System.out.println("===============获取成员变量=================");
        Field[] ff = c.getDeclaredFields();  //获取所有的成员变量对象  field 字段
        for(Field f: ff) {
            System.out.println(f.toString());
            System.out.println(f.getName());
        }
    }
    //c1, c2 , c3
    private static void showMethods(  Class<?>   c     ) {
        System.out.println("===============获取名称=================");
        System.out.println(c.getSimpleName());  //类名称
        System.out.println(c.getName());      //全称
        System.out.println("===============获取方法=================");
        Method[] mm = c.getDeclaredMethods();
        for(Method m : mm) {
            System.out.println(m.toString());
        }
    }
}
