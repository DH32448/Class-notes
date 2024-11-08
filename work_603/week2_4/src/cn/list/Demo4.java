package cn.list;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {
    public static void main(String[] args) {

        Object[] a = new Object[4]; //ArrayList 成员变量 Object[]

        a[0] = 1;          //1  ---> 装箱 Integer  ---》 Object
        a[1] = "Hello";    // 向上转型  Object
        a[2] = new Pig();  // 向上转型  Object
        a[3] = new String[3];

        Pig p2 = (Pig) a[2];   //Object --向下转型--> Pig
        System.out.println("=======================");
        //String s = (String) a[2];   //Object --向下转型--> Pig

        //ArrayList 成员变量 Object[]
        List  lst  = new ArrayList(128);
        lst.add(100);
        lst.add("Hello");
        lst.add(new Pig());

        String obj = (String) lst.get(1);
        System.out.println(obj);

        List<String> lst2 = new ArrayList<>();
        //lst2.add(100);      //写代码时报错
        lst2.add("hello");  //泛型： 写代码时帮助你完成类型检查
                            // Object 数组[], 发生向上转型 Object

        String s = lst2.get(0);   //发生向下转型, Object ---> String
                                  //泛型： 会自动根据 <类型> 帮助你向下转型

        //一切都是 Object 类型给你惹的祸
        //编译后（生成字节码文件）擦除， 字节码文件里面没有 < >

    }
}
