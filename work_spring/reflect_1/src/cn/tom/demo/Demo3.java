package cn.tom.demo;

import cn.tom.entity.Clz;
import cn.tom.entity.Course;
import cn.tom.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 类对象：  描述 所有数据类型信息  的对象

// 数据类型信息:  名称   成员变量（对象）    方法（对象）
public class Demo3 {
    public static void main(String[] args) throws Exception {
        // 获取类对象， 类对象的数据类型 Class <?>

        // 第三种方式  已知普通的对象， 获取类对象

        add(new Clz());    //普通对象
        add(new Course()); //普通对象
        add(new User()); //普通对象

    }

    private static void add( Object  obj) {
        //通过普通对象， 获取类对象
        Class<?> c = obj.getClass();


        showFileds(c);
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
