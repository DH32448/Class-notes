package cn.tom.week1;

import cn.tom.entity.Master;
import cn.tom.entity.NewBie;
import cn.tom.entity.Person;

public class Demo3 {
    public static void main(String[] args) {
        //多态: 父类   继承重写  向上转型
        //多态目的就是调用子类对象方法

        Person newbie = new NewBie();
        Person master = new Master();

        newbie.play();
        System.out.println("========================================");
        master.play();

    }
}
