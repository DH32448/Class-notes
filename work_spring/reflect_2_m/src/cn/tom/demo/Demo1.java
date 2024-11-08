package cn.tom.demo;

import cn.tom.entity.Clz;
import cn.tom.entity.Clz2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //  ${对象.name}    name  ---> Name  ---> getName
        //  ${对象.clzno}    clzno  ---> Clzno  ---> getClzno

        Object c  = new Clz();
//        c.setClzname("1班");
//        c.setClzno("1");


        String  f = "clzno";
        String  f2 = "clzname";

        String s1 = f.substring(0,1);
        System.out.println("s1=" + s1);
        String s2 = f.substring(1);
        System.out.println("s2=" + s2);

        f = s1.toUpperCase() + s2;
        System.out.println("f=" + f);

        String fget = "get" + f;   //getClzno
        String fset = "set" + f;   //setClzno
        //---> Clzno   Clzname

        //获取方法对象， 先获取类对象

        Class<?> aClass = c.getClass();
        //Metthod m = 类对象.getDeclaredMethod("成员方法名称"， 参数类型, 参数类型)；
        Method getClzno = aClass.getDeclaredMethod(fget);
        System.out.println(getClzno.toString());
        // 反射方式调用方法  in-vo-ke 调用
        //Object 返回值 = method.invoke(Object  当前方法所在的对象, Object 参数1， Object 参数2)
        Object v = getClzno.invoke(c);
        System.out.println(" v =" + v);

        System.out.println("=====================set 方法==================");

        // 获取 set 方法的对象
        //Metthod m = 类对象.getDeclaredMethod("成员方法名称"， 参数类型, 参数类型)；
        Method setClzno = aClass.getDeclaredMethod("setClzno", String.class);

        //通过 get 方法的返回值类型来确定
        Method setClzno2 = aClass.getDeclaredMethod("setClzno", getClzno.getReturnType());

        System.out.println(setClzno.toString());
        //Object 返回值 = method.invoke(Object  当前方法所在的对象, Object 参数1， Object 参数2)
        setClzno.invoke( c, "111" );

        System.out.println("c=" + c);



        System.out.println("--------------------clz2 用 clz 的类对象方法-------------------");
        Object  c2  = new Clz();

        setClzno.invoke( c2, "222" );

        System.out.println(c2);
    }

    public static  String getGetterName( String  fname) {
        String s1 = fname.substring(0,1);
        System.out.println("s1=" + s1);
        String s2 = fname.substring(1);
        System.out.println("s2=" + s2);

        fname = s1.toUpperCase() + s2;
        System.out.println("fname=" + fname);
        return "get" + fname;
    }
}
