package cn.tom.week1;

import cn.tom.Tool;
import cn.tom.entity.Gamer;
import cn.tom.entity.Person;

public class Demo4 {
    public static void main(String[] args) {
        //抽象类不能直接 new

        //Person p = new Person();
        Person p = new Gamer();
        p.setName("八戒");
        p.play();

        int n = Tool.getInt("请输入年龄:");
        String name = Tool.getSting("请输入姓名:");
    }
}
