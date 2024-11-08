package cn.tom4;

import java.util.ArrayList;

import java.util.*;

public class Demo41 {
    public static void main(String[] args) {
        List lst = new ArrayList<>();
          /*
            List 接口  没有成员变量
            ArrayList
            Object[] elementData
         */
        lst.add( new Pig());   //Pig 向上转型
        /**
         *   elementData[size++] = e;
         */

        Object obj = lst.get(0);  //add 向上转型了， 取的时候是 Object, 不是 Pig

        //Pig p  = obj;  // 因为这里向下转型（需要强制转换）

        Pig p = (Pig) obj; //向下转型（需要强制转换）, 可能会发生类型转换异常

        lst.add(new Dog());

        obj = lst.get(1);

        Pig p2 = (Pig) obj; //会报异常

        System.out.println("==================");

        System.out.println("避免： 向下转型（需要强制转换）, 可能会发生类型转换异常");

        List<Pig> lst2 = new ArrayList<>();

        //lst2.add(new Dog());  // add  帮助我们做类型安全检查
        //泛型只在编译期间起作用， 运行时没有泛型只说

        lst2.add( new Pig());  //add 向上转型 Object

        Pig pig = lst2.get(0); //泛型会根据指定类型完成向下代码 （Pig）



    }
}
