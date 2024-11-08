package cn.tom.demo;

import cn.tom.entity.Clz;
import cn.tom.entity.Course;
import cn.tom.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 类对象：  描述 所有数据类型信息  的对象

// 数据类型信息:  名称   成员变量（对象）    方法（对象）
public class Demo2 {
    public static void main(String[] args) throws Exception {
        // 获取类对象， 类对象的数据类型 Class <?>

        // 第二种方式  根据字符串， 获取类对象
        // "cn.tom.entity.User"
        // <servlet-class>cn.tom.AbcServlet</servlet-class>
        //resultType="cn.tom.entity.User">

         String name = "cn.lusq.dao.UserDao";
         Class c1 = Class.forName(name);   //根据名称 产生类对象

         //发射创建对象： 根据类对象创建对象

        Object o = c1.newInstance();   //new  Instance(实例  对象)

        //无法调用 add()
        Method[] mm = c1.getDeclaredMethods();

        Method addMethod = mm[0];

        // 反射调用方法
        System.out.println("========反射调用方法============");
        addMethod.invoke( o );
        System.out.println("========反射调用方法结束============");

        showFileds(c1);
         showMethods(c1);

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
