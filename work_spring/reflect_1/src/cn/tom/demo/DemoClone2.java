package cn.tom.demo;


import cn.tom.entity.Clz;
import cn.tom.entity.Course;

import java.lang.reflect.Field;

public class DemoClone2 {
    public static void main(String[] args) throws Exception {

        Clz c = new Clz();
        c.setClzno("119");
        c.setClzname("119班");
        Object newObj = copy(c);
        System.out.println(newObj.toString());   //多态
        c.setClzname("000班");
        System.out.println(c);
        System.out.println(newObj);

    }
     private static Object copy( Object x )  throws Exception{
        //获取类对象
         Class<?> aClass = x.getClass();
         //获取所有的字段（成员变量对象
         Field[] ff = aClass.getDeclaredFields();

         //利用反射去创建对象
         Object newObj = aClass.newInstance();
         // 字段对象.get( x  )
         // 反射的设置值 字段对象.set(对象，  值)
         for( Field f: ff) {
             //私有打开
             f.setAccessible(true);

             // 获取值, 从旧的对象取出值
             Object v = f.get(x);

             //新旧对象的类对象不变， 字段对象不变
             f.set(newObj, v);
         }
         return newObj;
     }
}
