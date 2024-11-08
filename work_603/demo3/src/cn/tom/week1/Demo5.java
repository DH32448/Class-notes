package cn.tom.week1;

import cn.tom.entity.Pig;
public class Demo5 {
    public static void main(String[] args) {
        //成员变量肯定有个初始值： 构造方法会对成员变量进行初始化
        //局部变量不会被初始化
        Pig p1 = new Pig();
        p1.setName("李世民");   //Pig 的 Pet 的 Pet.setName
        System.out.println( p1 );   //这种写法默认也是调用 toString, 可以打印出 null
        System.out.println(p1.toString() ); //报空指针异常
        // ?

    }
}
