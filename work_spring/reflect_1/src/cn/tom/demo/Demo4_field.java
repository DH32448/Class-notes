package cn.tom.demo;

import cn.tom.entity.Clz;
import cn.tom.entity.Course;
import cn.tom.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 类对象：  描述 所有数据类型信息  的对象

// 数据类型信息:  名称   成员变量（对象）    方法（对象）
public class Demo4_field {
    public static void main(String[] args) throws Exception {
        // 获取类对象， 类对象的数据类型 Class <?>

        // 第三种方式  已知普通的对象， 获取类对象

        Clz  c = new Clz();
        c.setClzno("119");
        c.setClzname("119班");
        add(c);    //普通对象

        Course course = new Course();
        course.setCno("C00");
        course.setCname("MYSQL");
        add(course);
//        add(new Course()); //普通对象
//        add(new User()); //普通对象

    }

    // Field = 字段  成员变量
    private static void add( Object  obj)  throws Exception{
        //通过普通对象， 获取类对象
        Class<?> c = obj.getClass();
        System.out.println("类对象："  + c);

        //通过类对象获取所有的成员变量
        Field[] ff = c.getDeclaredFields();
        for(Field f: ff) {
            System.out.println(f.getName());
        }

        //再通过反射获取成员的值：
        // 1. 成员变量对象  f
        // 2. 成员变量所在的对象  obj
        //  正常写法: 对象.成员变量
        //  反射:  Object 返回值 =  成员变量.get(成员变量所在的对象)
        //             Object x  =  f.get( obj )

        System.out.println("=============成员变量的值===============");
        for(Field f: ff) {
            //因为成员变量 是 私有的 ( private)
            f.setAccessible(true);  // 允许你直接访问私有的成员变量
                                     // access 访问   ble (能）
            System.out.println("成员变量名:" + f.getName());
            System.out.println("成员变量值:" + f.get(obj));
        }
        // 拼接一个 Insert 的 SQL 语句
        // Insert into 表名  (clzno, clzname) values ('119', '119班');
        /*
            -- SimpleFormatDate
            --  values = values + "'" +  f.get(obj) + "'" + ",";
         insert into t_student(sname, birthday) values ('LUSQ','2022-12-31');
         */

        String tableName = "t_" + c.getSimpleName().toLowerCase();
        System.out.println("表名:" + tableName);

        String fields = "";  //字段名
        String values = "";  //字段名对应的 值
        for(Field f: ff) {
            //因为成员变量 是 私有的 ( private)
            f.setAccessible(true);  // 允许你直接访问私有的成员变量
            fields = fields + f.getName() + ",";
            Object vv = f.get(obj);
            //.....
            values = values + "'" +  vv + "'" + ",";
            // access 访问   ble (能）
        }
        System.out.println("字段：" + fields);
        System.out.println("值：" + values);
        //最后最后一个  ,  要求去掉
        String sql = "INSERT INTO " + tableName + "("  +  fields +")";
        sql = sql + "values (" + values + ")";
        System.out.println("SQL=" + sql);
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
