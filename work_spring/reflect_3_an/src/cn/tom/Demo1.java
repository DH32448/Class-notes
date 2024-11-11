package cn.tom;

//如何获取和使用注解， 负责 善后工作
/*
获取类上注解：  -------> 先获取类对象
获取方法上注解:  ------->先获取类对象 ---> 获取 方法对象
获取成员变量上注解:  ------->先获取类对象 ---> 获取成员变量对象

 */


import cn.tom.anno.Table;

public class Demo1 {
    public static void main(String[] args) throws Exception{
        String[] entityPack = {"cn.tom.entity.Clz", "cn.tom.entity.Usr"};

        Class<?> aClass = Class.forName("cn.tom.entity.Usr"); //获取到类对象
        //注解也是数据类型
        Table anno = aClass.getAnnotation(Table.class); // anno 也是一个对象
        System.out.println("Usr  Table=" + anno);

        aClass = Class.forName("cn.tom.entity.Mark"); //获取到类对象
        //注解也是数据类型
        Table anno2 = aClass.getAnnotation(Table.class); // anno 也是一个对象
        System.out.println("Mark  Table=" + anno2);

    }
}
